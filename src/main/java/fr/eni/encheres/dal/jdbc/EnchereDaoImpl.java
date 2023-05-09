/**
 * Bertrand
 */
package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import config.ConnectionProvider;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.EnchereDao;

public class EnchereDaoImpl implements EnchereDao {
	
	private final static String SELECT_ENCHERES_EC = """
			 SELECT UTILISATEURS.no_utilisateur, pseudo, ARTICLES_VENDUS.no_article, nom_article, date_fin_encheres, MAX(montant_enchere) AS montant_max FROM ARTICLES_VENDUS
			 INNER JOIN ENCHERES ON ARTICLES_VENDUS.no_utilisateur = ENCHERES.no_utilisateur
			 INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur 
			 WHERE etat_vente = ? 
			 GROUP BY UTILISATEURS.no_utilisateur, pseudo, ARTICLES_VENDUS.no_article, nom_article, date_fin_encheres;
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
	public List<Enchere> selectEncheresByCategorie(String categorie) {
		// TODO Auto-generated method stub
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
	public List<Enchere> selectEncheresEnCoursByUtilisateurs(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Enchere> selectEncheresGagneByUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
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

	
	
	
	
	
}
