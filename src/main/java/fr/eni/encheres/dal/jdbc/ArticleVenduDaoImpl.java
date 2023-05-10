/**
 * Bertrand
 */
package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import config.ConnectionProvider;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDao;

public class ArticleVenduDaoImpl implements ArticleVenduDao {
	
	private static final String DELETE_ARTICLE_BY_USER_ID = "DELETE FROM ARTICLES_VENDUS WHERE no_utilisateur = ?;";
	
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
	public void insert(ArticleVendu articlevendu) {
		// TODO Auto-generated method stub
		
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
