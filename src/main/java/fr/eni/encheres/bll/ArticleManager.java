package fr.eni.encheres.bll;

import java.time.LocalDate;

import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DaoFactory;

public class ArticleManager {
			//Singleton
			/**START SINGLETON **/
			
			//Etape 1
			private static ArticleManager instance;
			
			//Etape 2
			private ArticleManager() {}
			//Etape3
			public static ArticleManager getInstance() {
				if(instance == null) {
					instance = new ArticleManager();
				}
				return instance;
			}
			/**END SINGLETON **/
			
			
			public void addArticle(ArticleVendu articlevendu) throws BllException {
				checkArticle(articlevendu);
				DaoFactory.getArticleVenduDao().insert(articlevendu);
			}
			
			public void checkArticle(ArticleVendu articlevendu) throws BllException {
				BllException bll = new BllException();
				checkField(articlevendu.getNomArticle(), "nom-article", bll);
				checkField(articlevendu.getDescription(), "description", bll);
				checkField(articlevendu.getDateDebutEncheres(), "debut-enchere", bll);
				checkField(articlevendu.getDateFinEncheres(), "fin-enchere", bll);

				if(bll.getErreurs().size()>0) {
					throw bll;
				}
				
			}

			private void checkField(String field, String name, BllException bll){
				if(field.isBlank()) {
					bll.ajouterErreur("Le champ %s ne peut pas être vide".formatted(name));
				}
				
			}
			
			private void checkField(LocalDate field, String name, BllException bll){
				if(field == null) {
					bll.ajouterErreur("Le champ %s ne peut pas être vide".formatted(name));
				}
				
			}
			
			
}
