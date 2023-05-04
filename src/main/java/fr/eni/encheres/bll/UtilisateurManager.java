package fr.eni.encheres.bll;

import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;

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
		
		public void checkUtilisateur(Utilisateur utilisateur) throws BllException {
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

		private void checkField(String field, String name, BllException bll){
			if(field.isBlank()) {
				bll.ajouterErreur("Le champ %s ne peut pas être vide".formatted(name));
			}
			
		}
		
}
