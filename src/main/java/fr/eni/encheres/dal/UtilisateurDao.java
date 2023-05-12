package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

/**
 * 
 * @author bertrand et modifié par benjamin
 *
 */
public interface UtilisateurDao {
	//CRUD
	public List <Utilisateur> selectAll();
	public void insert(Utilisateur utilisateur);
	public void update(Utilisateur utilisateur);
	public void delete(int id);
	public Utilisateur selectById(int id);

	
	public Utilisateur selectByPseudo(String nomUtilisateur);
	public Utilisateur selectByConnexion(String identifiant, String motDePasse);
	public Utilisateur selectByLogin(String login);
	
	Utilisateur selectEnchereEnCour(int noUtilisateur);	
}
