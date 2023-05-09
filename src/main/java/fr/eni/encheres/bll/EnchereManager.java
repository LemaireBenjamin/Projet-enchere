package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;

public class EnchereManager {
	//Singleton
			/**START SINGLETON **/
			
			//Etape 1
			private static EnchereManager instance;
			
			//Etape 2
			private EnchereManager() {}
			//Etape3
			public static EnchereManager getInstance() {
				if(instance == null) {
					instance = new EnchereManager();
				}
				return instance;
			}
			/**END SINGLETON **/
			
			public List<Enchere> getAllEncheresEC(String etatEnchere) {
				return DaoFactory.getEnchereDao().selectEncheresEC(etatEnchere);
			}
			
			public List<Enchere> getAllEncheresEnCoursByUser(Utilisateur utilisateur) {
				return DaoFactory.getEnchereDao().selectEncheresEnCoursByUtilisateur(utilisateur);
			}
			
			
			
}
