package fr.eni.encheres.bll;

import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;

/**
 * 
 * @author Bertrand 
 * Réécrit par Benjamin
 * @version 1.1 
 */
public class UtilisateurManager {
	//Singleton
		/**START SINGLETON **/
		
		//Etape 1
		private static UtilisateurManager instance;
		
		//Etape 2
		private UtilisateurManager() {}
		//Etape3
		public static UtilisateurManager getInstance() {
			if(instance == null) {
				instance = new UtilisateurManager();
			}
			return instance;
		}
		/**END SINGLETON **/

		
		
		public void addUtilisateur(Utilisateur utilisateur) throws BllException {
			checkUtilisateur(utilisateur);
			DaoFactory.getUtilisateurDao().insert(utilisateur);
		}
		
		public Utilisateur getUtilisateurById(int noUtilisateur) {
			return DaoFactory.getUtilisateurDao().selectById(noUtilisateur);
		}
		
		// Retourne un utilisateur si le login (pseudo ou email) et le mot de passe sont correctes
		public Utilisateur getUtilisateurByConnexion(String login, String motDePasse) {
			return DaoFactory.getUtilisateurDao().selectByConnexion(login, motDePasse);

		}
		
		public void updateUtilisateur(Utilisateur utilisateur) throws BllException{
			checkModificationUser(utilisateur);
			DaoFactory.getUtilisateurDao().update(utilisateur);
		}
		
		public Utilisateur getUtilisateurForConnexion(String utilisateurNom, String motDePasse) {
			return DaoFactory.getUtilisateurDao().selectByConnexion(utilisateurNom, motDePasse);
			
		}
		
		public void deleteUtilisateur(int noUtilisateur) throws BllException {
		
			// Vérifie que l'utilisateur a des enchères en cours
			if( DaoFactory.getUtilisateurDao().selectEnchereEnCour(noUtilisateur) != null){
				
				BllException bll = new BllException();
				bll.ajouterErreur("Vous avez des enchères en cours. Vous ne pouvez pas supprimer votre compte");
				throw bll;
			
			}else {
				DaoFactory.getUtilisateurDao().delete(noUtilisateur);
			}
		}
		
		public void checkUtilisateur(Utilisateur utilisateur) throws BllException {
			BllException bll = new BllException();
			checkUnicite(utilisateur.getPseudo(), "Pseudo", bll);
			checkField(utilisateur.getNom(), "Nom", bll);
			checkField(utilisateur.getPrenom(), "Prenom", bll);
			checkField(utilisateur.getEmail(), "Email", bll);
			checkField(utilisateur.getRue(), "Rue", bll);
			checkField(utilisateur.getCodePostal(), "Code postal", bll);
			checkField(utilisateur.getVille(), "Ville", bll);
			checkField(utilisateur.getMotDePasse(), "Mot de passe", bll);
			if(bll.getErreurs().size()>0) {
				throw bll;
			}
			
		}

		private void checkField(String field, String name, BllException bll){
			if(field.isBlank()) {
				bll.ajouterErreur("Le champ %s ne peut pas être vide".formatted(name));
			}
			
		}
		
		private void checkUnicite(String field, String name, BllException bll){
			if(DaoFactory.getUtilisateurDao().selectByPseudo(field) != null) {
				bll.ajouterErreur("Le %s %s est déjà pris par un autre utilisateur".formatted(name,field));
			}
			
		}
		
		// Pour la modification des champs de l'utilisateur. Pour éviter l'erreur lors de la modification du pseudo
		public void checkModificationUser(Utilisateur utilisateur) throws BllException {
			BllException bll = new BllException();
			checkField(utilisateur.getPseudo(), "Pseudo", bll);
			checkField(utilisateur.getNom(), "Nom", bll);
			checkField(utilisateur.getPrenom(), "Prenom", bll);
			checkField(utilisateur.getEmail(), "Email", bll);
			checkField(utilisateur.getRue(), "Rue", bll);
			checkField(utilisateur.getCodePostal(), "Code postal", bll);
			checkField(utilisateur.getVille(), "Ville", bll);
			checkField(utilisateur.getMotDePasse(), "Mot de passe", bll);
			if(bll.getErreurs().size()>0) {
				throw bll;
			}
			
		}
}
