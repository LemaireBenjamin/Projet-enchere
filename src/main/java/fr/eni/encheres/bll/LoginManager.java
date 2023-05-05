package fr.eni.encheres.bll;

import at.favre.lib.crypto.bcrypt.BCrypt;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;

/**
 * 
 * @author msonzia2023
 *
 */
public class LoginManager {
	
	/** debut singleton **/
	private static LoginManager instance;
	
	private LoginManager() {}
	
	public static LoginManager getInstance() {
		if (instance==null) {
			instance= new LoginManager();
		}
		return instance;
	}	
	/** fin singleton **/
	
	// ajout de l'utilisateur
	public void addUtilisateur(Utilisateur utilisateur) {
		
	
	// check fields
			utilisateur.setMotDePasse( 
					BCrypt.withDefaults().hashToString(12, utilisateur.getMotDePasse().toCharArray())
					);
			DaoFactory.getUtilisateurDao().insert(utilisateur);
			
		}

		public void Login(String pseudo,String motDePasse) {
			Utilisateur utilisateur = DaoFactory.getUtilisateurDao().selectByPseudo(pseudo);
			
		}
	
}


