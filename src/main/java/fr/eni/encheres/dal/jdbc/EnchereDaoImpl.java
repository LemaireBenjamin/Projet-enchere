/**
 * Bertrand
 */
package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import config.ConnectionProvider;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.EnchereDao;




public class EnchereDaoImpl implements EnchereDao {
	
	private final static String SELECT_ENCHERES_EC = """
			SELECT u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres, MAX(montant_enchere) AS montant_max FROM ARTICLES_VENDUS av
			INNER JOIN ENCHERES e ON av.no_article = e.no_article
			INNER JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur
			WHERE etat_vente = ?
			GROUP BY u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres;
			""";
	
	private static final String SELECT_ENCHERES_EN_COURS_BY_UTILISATEUR =  """
			SELECT u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres, MAX(montant_enchere) AS montant_max FROM ENCHERES e
			INNER JOIN ARTICLES_VENDUS av ON e.no_utilisateur = av.no_utilisateur
			INNER JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur
			WHERE u.no_utilisateur = ? AND etat_vente = ?
			GROUP BY u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres;
			""";
	
	private static final String SELECT_ENCHERES_GAGNEES_BY_UTILISATEUR =  """
			SELECT u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres, MAX(montant_enchere) AS montant_max FROM ARTICLES_VENDUS av
			LEFT JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur
			INNER JOIN ENCHERES e ON av.no_article = e.no_article
			INNER JOIN CATEGORIES c ON av.no_categorie = c.no_categorie
			WHERE u.no_utilisateur = ? AND etat_vente = ?
			GROUP BY u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres;	
			""";
	
	private static final String SELECT_ENCHERES_COMMENCEES_BY_UTILISATEUR =  """
			SELECT u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres FROM ARTICLES_VENDUS av
			INNER JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur
			WHERE u.no_utilisateur = ? AND etat_vente = ?
			GROUP BY u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres;	
			""";
	
	
	// Requête sql, pour récupérer les informations quand l'on clique sur le nom de l'article lors d'une enchère
	private static final String SELECT_BY_ID_ARTICLE = """	
			SELECT e.no_utilisateur,e.no_article,e.date_enchere,
				em.montant_max,
				ca.libelle, re.rue,re.code_postal,re.ville,
				ut.pseudo,ut.credit, 
				av.nom_article,av.etat_vente, av.description,av.date_debut_encheres,
				av.date_fin_encheres, av.prix_initial, av.prix_vente,av.no_categorie
			FROM encheres e INNER JOIN (
			  SELECT MAX(montant_enchere) AS montant_max FROM encheres WHERE no_article = ?
			) em 
			ON e.montant_enchere = em.montant_max
			INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article 
			INNER JOIN RETRAITS re ON av.no_article=re.no_article 
			INNER JOIN CATEGORIES ca ON av.no_categorie = ca.no_categorie
			INNER JOIN UTILISATEURS ut ON e.no_utilisateur=ut.no_utilisateur
			WHERE e.no_article = ?;
			""";
	
	

	private static final String SELECT_ENCHERES_BY_LIBELLE =  """
			SELECT u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres, MAX(montant_enchere) AS montant_max FROM ARTICLES_VENDUS av
			LEFT JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur
			INNER JOIN ENCHERES e ON av.no_article = e.no_article
			INNER JOIN CATEGORIES c ON av.no_categorie = c.no_categorie
			WHERE c.libelle = ? AND etat_vente = ?
			GROUP BY u.no_utilisateur, pseudo, av.no_article, nom_article, date_fin_encheres;	
			""";
		

	@Override
	public List<Enchere> selectEncheresEC(String etatEnchere) {
		
		List<Enchere> encheres = new ArrayList<>();
		
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_ENCHERES_EC);
			pStmt.setString(1, etatEnchere);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				encheres.add(new Enchere (rs.getDate("date_fin_encheres").toLocalDate(),	
						new ArticleVendu (rs.getInt("no_article"), rs.getString("nom_article"), rs.getInt("montant_max")),
						new Utilisateur (rs.getInt("no_utilisateur"), rs.getString("pseudo"))));
						
			}
			return encheres;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}

	
	@Override
	public List<Enchere> selectEncheresEnCoursByUtilisateur(Utilisateur utilisateur, String etatEnchere) {
	
		List<Enchere> encheres = new ArrayList<>();	
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_ENCHERES_EN_COURS_BY_UTILISATEUR);
			pStmt.setInt(1, utilisateur.getNoUtilisateur());
			pStmt.setString(2, etatEnchere);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				encheres.add(new Enchere (rs.getDate("date_fin_encheres").toLocalDate(),	
						new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getInt("montant_max")),
						new Utilisateur (rs.getInt("no_utilisateur"), rs.getString("pseudo"))));			
			}
			return encheres;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	

	@Override
	public List<Enchere> selectEncheresEnCoursAchatByUtilisateur(Utilisateur utilisateur, String etatEnchere) {

		List<Enchere> encheres = new ArrayList<>();	
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_ENCHERES_EN_COURS_BY_UTILISATEUR);
			pStmt.setInt(1, utilisateur.getNoUtilisateur());
			pStmt.setString(2, etatEnchere);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				encheres.add(new Enchere (rs.getDate("date_fin_encheres").toLocalDate(),	
						new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getInt("montant_max")),
						new Utilisateur (rs.getInt("no_utilisateur"), rs.getString("pseudo"))));			
			}
			return encheres;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	

	@Override
	public Enchere selectOneEnchereByIdArticle(int noArticle) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_ID_ARTICLE);
			pStmt.setInt(1, noArticle);
			pStmt.setInt(2, noArticle);
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) 
				return new Enchere (rs.getDate("date_fin_encheres").toLocalDate(),rs.getInt("montant_max"),	
						new ArticleVendu((Integer) rs.getInt("no_article"), 
								rs.getString("nom_article"),
								rs.getString("description"),
								rs.getDate("date_debut_encheres").toLocalDate(),
								rs.getDate("date_fin_encheres").toLocalDate(),
								(Integer) rs.getInt("prix_initial"),
								(Integer) rs.getInt("prix_vente"),
								(Categorie) (new Categorie(rs.getInt("no_categorie"),rs.getString("libelle"))),
								rs.getString("etat_vente"),
								(Retrait) new Retrait(rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"))),
						new Utilisateur (rs.getInt("no_utilisateur"), rs.getString("pseudo"),rs.getInt("credit")));			
						
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<Enchere> selectEncheresGagneByUtilisateur(Utilisateur utilisateur, String etatEnchere) {
	
		List<Enchere> encheres = new ArrayList<>();	
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_ENCHERES_GAGNEES_BY_UTILISATEUR);
			pStmt.setInt(1, utilisateur.getNoUtilisateur());
			pStmt.setString(2, etatEnchere);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				encheres.add(new Enchere (rs.getDate("date_fin_encheres").toLocalDate(),	
						new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getInt("montant_max")),
						new Utilisateur (rs.getInt("no_utilisateur"), rs.getString("pseudo"))));			
			}
			return encheres;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	@Override
	public List<Enchere> selectEncheresByLibelle(String libelle, String etatEnchere) {
		List<Enchere> encheres = new ArrayList<>();	
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_ENCHERES_BY_LIBELLE);
			pStmt.setString(1, libelle);
			pStmt.setString(2, etatEnchere);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				encheres.add(new Enchere (rs.getDate("date_fin_encheres").toLocalDate(),	
						new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getInt("montant_max")),
						new Utilisateur (rs.getInt("no_utilisateur"), rs.getString("pseudo"))));			
			}
			return encheres;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	@Override
	public List<Enchere> selectEncheresCommenceesByUtilisateur(Utilisateur utilisateur, String etatEnchere) {
		List<Enchere> encheres = new ArrayList<>();	
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_ENCHERES_COMMENCEES_BY_UTILISATEUR);
			pStmt.setInt(1, utilisateur.getNoUtilisateur());
			pStmt.setString(2, etatEnchere);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				encheres.add(new Enchere (rs.getDate("date_fin_encheres").toLocalDate(),	
						new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article")),
						new Utilisateur (rs.getInt("no_utilisateur"), rs.getString("pseudo"))));			
			}
			return encheres;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
	

	@Override
	public List<Enchere> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEnchere(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Enchere selectEnchereGagneeByArticle(int noArticle) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isMeilleurEncherisseur(int noArticle, int noUtilisateur) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Utilisateur selectMeilleurEncherisseur(Enchere enchere) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteByUserId(int noUtilisateur) {
		// TODO Auto-generated method stub
		
	}


}
