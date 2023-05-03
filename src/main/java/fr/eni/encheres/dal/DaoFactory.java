/**
 * Bertrand
 */
package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleVenduDaoImpl;
import fr.eni.encheres.dal.jdbc.CategorieDaoImpl;
import fr.eni.encheres.dal.jdbc.EnchereDaoImpl;
import fr.eni.encheres.dal.jdbc.RetraitDaoImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDaoImpl;

public class DaoFactory {
	
	public static ArticleVenduDao getArticleVenduDao() {
		return new ArticleVenduDaoImpl();
	}
	
	public static CategorieDao getCategorieDao() {
		return new CategorieDaoImpl();
	}
	
	public static EnchereDao getEnchereDao() {
		return new EnchereDaoImpl();
	}
	
	public static RetraitDao getRetraitDao() {
		return new RetraitDaoImpl();
	}

	public static UtilisateurDao getUtilisateurDao() {
		return new UtilisateurDaoImpl();
	}
}


	