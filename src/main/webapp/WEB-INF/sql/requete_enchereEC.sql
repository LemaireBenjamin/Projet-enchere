DELETE FROM utilisateurs WHERE no_utilisateur = ?;

SELECT * FROM UTILISATEURS u INNER JOIN ENCHERES en ON u.no_utilisateur=en.no_utilisateur
	INNER JOIN ARTICLES_VENDUS art ON en.no_article=art.no_article
	WHERE u.no_utilisateur = 9 AND art.etat_vente ='EC'


SELECT * FROM UTILISATEURS