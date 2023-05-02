/**
 * Bertrand
 */
package fr.eni.encheres.dal;


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


	