SELECT pseudo,date_enchere FROM 
	UTILISATEURS u
		INNER JOIN 
			Encheres e
				ON u.no_utilisateur = e.no_utilisateur

SELECT pseudo, nom_article FROM
	UTILISATEURS u
		INNER JOIN 
			ARTICLES_VENDUS a
				ON u.no_utilisateur=a.no_utilisateur

SELECT nom_article, date_debut_encheres FROM
	ARTICLES_VENDUS a 
		INNER JOIN 
			CATEGORIES c 
				ON a.no_categorie=c.no_categorie

SELECT nom_article, date_debut_encheres FROM
	ARTICLES_VENDUS a 
		INNER JOIN 
			CATEGORIES c 
				ON a.no_categorie=c.no_categorie

SELECT nom_article, description, date_enchere, montant_enchere, pseudo
	FROM ARTICLES_VENDUS av
		INNER JOIN 
			ENCHERES en 
				ON av.no_article=en.no_article
		INNER JOIN 
			UTILISATEURS ut
				ON en.no_utilisateur=ut.no_utilisateur



INSERT INTO UTILISATEURS VALUES ('cle23','Le roux',
	'Clement','cle.leroux@gmail.com','0630201020','2 rue Liberté',
	'56000','Vannes', 'azerty', 100, 0);

SELECT * FROM UTILISATEURS;

-- Vérification des contraintes d'unicité 
INSERT INTO UTILISATEURS VALUES ('cle23','Le roux',
	'Clement','cle.ler2@gmail.com','0630201020','2 rue Liberté',
	'56000','Vannes', 'azerty', 100, 0);

-- Vérification de la contrainte sur le pseudo (alphanumérique) 
INSERT INTO UTILISATEURS VALUES ('azerty%','Croche',
	'Sarah','sarah.cr@gmail.com','0935211550','14 rue Merci',
	'75000','Paris', '123',0, 0);
