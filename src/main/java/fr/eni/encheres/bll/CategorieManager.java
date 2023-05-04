package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DaoFactory;

public class CategorieManager {
	/**
	 * Debut singleton
	 */
	private static CategorieManager instance;
	private CategorieManager () {}
	
	public static CategorieManager getInstance() {
		if (instance==null) {
			instance= new CategorieManager();
		}
	return instance;
	}
	/** fin singleton**/
	
	/** methodes**/
	
	public List<Categorie> getAllCategories (){
		return DaoFactory.getCategorieDao().selectAll();
	}
	
	public Categorie getOneCategorie(int noCategorie) {
		return DaoFactory.getCategorieDao().selectById(noCategorie);
		
	}
	public Categorie getOneCategorie(String libelle) {
		return DaoFactory.getCategorieDao().selectLibelle(libelle);
		
	}


}
