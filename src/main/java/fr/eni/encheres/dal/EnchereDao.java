/**
 * Bertrand
 */
package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public interface EnchereDao {
	//CRUD
	public List <Enchere> selectAll();
	
	public List<Enchere> selectEncheresEC(String etatEnchere);
	
	public List<Enchere> selectEncheresByCategorie(String categorie);
	
	List<Enchere> selectEncheresEnCoursByUtilisateurs(Utilisateur utilisateur);
	
	List<Enchere> selectEncheresGagneByUtilisateur(Utilisateur utilisateur);
	 
	public Enchere selectEnchereGagneeByArticle(int noArticle);

	public boolean isMeilleurEncherisseur(int noArticle, int noUtilisateur);

	public Utilisateur selectMeilleurEncherisseur(Enchere enchere);
	
	public Enchere selectOne(int id);
	
	public void insert(Enchere enchere);

	public void update(Enchere enchere);

	public void deleteEnchere(int id);
	

	
	
	
	
}
