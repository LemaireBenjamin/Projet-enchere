package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
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
			
			public List<Enchere> gettAllEncheresEC(String etatEnchere) {
				return DaoFactory.getEnchereDao().selectEncheresEC(etatEnchere);
			}
}
