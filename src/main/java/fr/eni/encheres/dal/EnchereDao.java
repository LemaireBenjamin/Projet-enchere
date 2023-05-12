package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * 
 * @author bertrand
 * @version 1.5
 */

public interface EnchereDao {
	//CRUD
	public List <Enchere> selectAll();
	public void insert(Enchere enchere);
	public void update(Enchere enchere);
	public void deleteEnchere(int id);
	
	
	
	// Méthodes pour récupérer les enchères en cours 
	public List<Enchere> selectEncheresEC(String etatEnchere);
	public List<Enchere> selectEncheresEnCoursByUtilisateur(Utilisateur utilisateur, String etatEnchere);
	public List<Enchere> selectEncheresEnCoursAchatByUtilisateur(Utilisateur utilisateur, String etatEnchere); 
	
	
	public List<Enchere> selectEncheresCommenceesByUtilisateur(Utilisateur utilisateur, String etatEnchere);
	

	public List<Enchere> selectEncheresGagneByUtilisateur(Utilisateur utilisateur, String etatEnchere);
	public Enchere selectEnchereGagneeByArticle(int noArticle);
	
	
	public List<Enchere> selectEncheresByLibelle(String libelle, String etatEnchere);
	public Enchere selectOneEnchereByIdArticle(int noArticle);
	public Enchere selectOne(int id);


	public boolean isMeilleurEncherisseur(int noArticle, int noUtilisateur);
	public Utilisateur selectMeilleurEncherisseur(Enchere enchere);
	

	
	public void deleteByUserId(int noUtilisateur);
}
