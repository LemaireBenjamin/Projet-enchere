package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;
import fr.eni.encheres.bll.exception.BllException;
import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Cette classe n'est pas utilisé dans le projet  
 * Elle permetra de "hash" le mot de passe de l'utilisateur
 */



/**
 * 
 * @author marie-audrey
 *
 */


public class SecurityService {
	
	private static SecurityService instance= new SecurityService(); //lazy Singleton
	private SecurityService() {}
	
	public static SecurityService getInstance() {
		return instance;
	}
	
	
	public void addUser(Utilisateur utilisateur) {
		utilisateur.setMotDePasse(BCrypt.withDefaults().hashToString(12, utilisateur.getMotDePasse().toCharArray()));
		DaoFactory.getUtilisateurDao().insert(utilisateur);
	}

	public Utilisateur login(String login, String password) throws BllException {
		//REVOIR selectByUserName
		Utilisateur utilisateur = DaoFactory.getUtilisateurDao().selectByLogin(login);
		if(utilisateur == null) {
			throw new BllException();
		}
		
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), utilisateur.getMotDePasse());
		if(!result.verified) {
			throw new BllException("Le mot de passe est erroné !");	
		}
	
		return  utilisateur;
	}
}
