/**
 * Bertrand
 */
package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;

import config.ConnectionProvider;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDao;

public class ArticleVenduDaoImpl implements ArticleVenduDao {
	

	private static final String DELETE_ARTICLE_BY_USER_ID = "DELETE FROM ARTICLES_VENDUS WHERE no_utilisateur = ?;";
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?,?)";
		
	@Override
	public void insert(ArticleVendu articlevendu) {
		try (Connection connection = ConnectionProvider.getConnection()){
			
			PreparedStatement pStmt = connection.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, articlevendu.getNomArticle());
			pStmt.setString(2, articlevendu.getDescription());
			pStmt.setDate(3, Date.valueOf(articlevendu.getDateDebutEncheres()));
			pStmt.setDate(4, Date.valueOf(articlevendu.getDateFinEncheres()));
			pStmt.setInt(5, articlevendu.getPrixInitial());
			pStmt.setInt(6, articlevendu.getPrixInitial());
			pStmt.setString(7, articlevendu.getEtatVente());
			pStmt.setInt(8, articlevendu.getUtilisateur().getNoUtilisateur());
			pStmt.setInt(9, articlevendu.getCategorieArticle().getNoCategorie());
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				articlevendu.setNoArticle(rs.getInt(1)); // pour la redirection
			}
			pStmt.executeUpdate();
	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
	@Override
	public List<ArticleVendu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void update(ArticleVendu articlevendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticleVendu(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByUserId(int noUtilisateur) {
		try (Connection connection = ConnectionProvider.getConnection();){
			
			PreparedStatement stmt = connection.prepareStatement(DELETE_ARTICLE_BY_USER_ID);
			stmt.setInt(1, noUtilisateur);
			stmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
