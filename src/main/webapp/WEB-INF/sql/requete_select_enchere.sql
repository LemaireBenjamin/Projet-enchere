SELECT * FROM ENCHERES en INNER JOIN ARTICLES_VENDUS av ON en.no_article = av.no_article 
	INNER JOIN RETRAITS re ON av.no_article=re.no_article 
	WHERE en.no_article = 5;


SELECT e.no_utilisateur,e.no_article,e.date_enchere,
	em.montant_max,
	ca.libelle, re.rue,re.code_postal,re.ville,
	ut.pseudo,ut.credit, 
	av.nom_article,av.etat_vente, av.description,av.date_debut_encheres,
	av.date_fin_encheres, av.prix_initial, av.prix_vente,av.no_categorie
FROM encheres e INNER JOIN (
			  SELECT MAX(montant_enchere) AS montant_max FROM encheres WHERE no_article = 5
			) em 
			ON e.montant_enchere = em.montant_max
			INNER JOIN ARTICLES_VENDUS av ON e.no_article = av.no_article 
			INNER JOIN RETRAITS re ON av.no_article=re.no_article 
			INNER JOIN CATEGORIES ca ON av.no_categorie = ca.no_categorie
			INNER JOIN UTILISATEURS ut ON e.no_utilisateur=ut.no_utilisateur
			WHERE e.no_article = 5;