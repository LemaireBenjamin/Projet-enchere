package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticleVendu;

import java.util.List;

/**
 * 
 * @author bertrand
 *
 */

public interface ArticleVenduDao {
	//CRUD
	public List <ArticleVendu> selectAll();
	
	public ArticleVendu selectOne(int id);
	
	public void insert(ArticleVendu articlevendu);
	
	public void update(ArticleVendu articlevendu);

	// Méthode de suppression d'un article
	public void deleteArticleVendu(int id);

	public void deleteByUserId(int noUtilisateur);
}
