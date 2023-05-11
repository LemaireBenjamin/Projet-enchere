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

	public List<Enchere> selectEncheresEnCoursByUtilisateur(Utilisateur utilisateur, String etatEnchere);
	
	public List<Enchere> selectEncheresGagneByUtilisateur(Utilisateur utilisateur, String etatEnchere);
	
	 
	public Enchere selectEnchereGagneeByArticle(int noArticle);

	public boolean isMeilleurEncherisseur(int noArticle, int noUtilisateur);

	public Utilisateur selectMeilleurEncherisseur(Enchere enchere);
	
	public Enchere selectOne(int id);
	
	public void insert(Enchere enchere);

	public void update(Enchere enchere);

	public void deleteEnchere(int id);

	public void deleteByUserId(int noUtilisateur);

	public Enchere selectOneByIdArticle(int noArticle);
	

}
