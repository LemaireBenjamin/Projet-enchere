-- 1 - SUPPRESSION DES TABLES ET REINITIALISATION DES CPT IDENTITY


--Vidage de la table ENCHERES
DELETE FROM ENCHERES

DROP TABLE ENCHERES

--vidage de la table RETRAITS
DELETE FROM RETRAITS


-- vidage de la table ARTICLES_VENDUS
DELETE FROM ARTICLES_VENDUS;

	--reinitialiser l'identity à 1 (vider la table auparavant)
	DBCC CHECKIDENT ('ARTICLES_VENDUS', RESEED, 0)


-- vidage de la table UTILISATEURS
DELETE FROM UTILISATEURS;

	--reinitialiser l'identity à 1 (vider la table auparavant)
	DBCC CHECKIDENT ('UTILISATEURS', RESEED, 0)


-- vidage de la table CATEGORIES
DELETE FROM CATEGORIES;

	--reinitialiser l'identity à 1 (vider la table auparavant)
	DBCC CHECKIDENT ('CATEGORIES', RESEED, 0)




-- 2 - REMPLISSAGE DES TABLES

--JEU D'ESSAI UTILISATEURS
INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
VALUES 
('user1', 'Dupont', 'Jean', 'jd@gmail.com', '0123456789', 'Rue des Lilas', '75001', 'Paris', 'pwd1', 50, 0),
('user2', 'Martin', 'Marie', 'mm@gmail.com', '0234567891', 'Rue de la Paix', '69002', 'Lyon', 'pwd2', 20, 0),
('admin1', 'Lefebvre', 'Pierre', 'pl@hotmail.com', '0345678912', 'Rue des Roses', '44000', 'Nantes', 'pwd3', 75, 1),
('user3', 'Durand', 'Lucie', 'ld@yahoo.fr', '0456789123', 'Rue des Champs', '31000', 'Toulouse', 'pwd4', 10, 0),
('user4', 'Bernard', 'Philippe', 'pbd@outlook.com', '0567891234', 'Rue des Moulins', '67000', 'Strasbourg', 'pwd5', 40, 0),
('user5', 'Girard', 'Sophie', 'sg@gmail.com', '0678912345', 'Rue des Vignes', '33000', 'Bordeaux', 'pwd6', 60, 0),
('user6', 'Moreau', 'Antoine', 'am@laposte.net', '0789123456', 'Rue des Peupliers', '13000', 'Marseille', 'pwd7', 5, 0),
('user7', 'Rousseau', 'Julie', 'jr@gmail.com', '0891234567', 'Rue des Cèdres', '54000', 'Nancy', 'pwd8', 30, 0),
('user8', 'Fournier', 'Alexandre', 'af@hotmail.fr', '0912345678', 'Rue des Châtaigniers', '35000', 'Rennes', 'pwd9', 15, 0),
('admin2', 'Mercier', 'Emilie', 'em@yahoo.fr', '0023456789', 'Rue des Tilleuls', '69003', 'Lyon', 'pwd10', 90, 1);


-- JEU ESSAI  CATEGORIES

INSERT INTO CATEGORIES (libelle)
VALUES 
('Informatique'),
('Ameublement'),
('Vêtement'),
('Sport&Loisirs')


--JEU ESSAI ARTICLES_VENDUS
-- !!! les tables UTILISATEURS ET CATEGORIES DOIVENT CONTENIR DES DONNEES !!!--
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie)
VALUES
('Ordinateur portable', 'Un ordinateur portable de la marque Dell en excellent état', '2023-06-01', '2023-06-30', 50, 600, 'RE', 1, 1),
('Canapé en cuir', 'Un canapé en cuir véritable de couleur noire, en très bon état', '2023-07-01', '2023-07-01', 100, NULL, 'EC', 2, 2),
('Veste en cuir', 'Une veste en cuir véritable pour femme, taille M, en excellent état', '2023-08-01', '2023-08-10', 20, NULL, 'CR', 3, 3),
('Raquette de tennis', 'Une raquette de tennis professionnelle de la marque Wilson', '2023-09-01', '2023-09-01', 10, NULL, 'EC', 4, 4),
('Imprimante multifonction', 'Une imprimante multifonction de la marque HP en excellent état', '2023-10-01', '2023-10-01', 15, NULL, 'EC', 5, 1),
('Table de salle à manger', 'Une grande table de salle à manger en bois massif, en très bon état', '2023-11-01', '2023-11-15', 80, 1500, 'RE', 6, 2),
('Chaussures de sport', 'Des chaussures de sport pour homme, taille 42, de la marque Adidas', '2023-12-01', '2023-12-01', 5, 900, 'ET', 7, 4),
('Canapé d''angle', 'Un grand canapé d''angle en tissu beige, en très bon état', '2024-01-01',  '2024-01-01', 120, NULL,  'EC', 8, 2),
('T-shirt à manches courtes', 'Un t-shirt à manches courtes pour femme, taille S, de la marque Levi''s', '2024-02-01', '2024-02-28', 3, 45, 'RE', 9, 3),
('Vélo de course', 'Un vélo de course pour homme de la marque Trek', '2024-03-01', '2024-03-01', 50, NULL, 'EC', 10, 4);


-- JEU ESSAI ENCHERES
INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere)
VALUES

(4, 5, 2023-04-25, 600),
(2, 5, 2023-04-26, 900),
(10, 5, 2023-04-27, 1200),
(6, 5, 2023-04-29, 1300),

(10, 6, 2023-04-24, 700),
(1, 6, 2023-04-26, 900),
(9, 6, 2023-04-29, 1000),
(2, 6, 2023-04-30, 1100),

(6, 7, 2023-04-25, 800),
(1, 7, 2023-04-29, 1200),
(8, 7, 2023-04-28, 1500),

(3, 8, 2023-04-27, 2000),
(7, 8, 2023-04-28, 3000),

(8, 9, 2023-04-24, 500),
(5, 9, 2023-04-27, 800),
(3, 9, 2023-05-05, 1000),

(7, 10, 2023-04-25, 700),
(9, 10, 2023-04-26, 800),
(4, 10, 2023-04-28, 1100);


---JEU ESSAI RETRAITS
INSERT INTO RETRAITS (no_article, rue, code_postal, ville)
VALUES 
    (1, 'Rue de la Paix', '75001', 'Paris'),
    (2, 'Rue de l''Université', '69007', 'Lyon'),
    (3, 'Avenue des Champs-Élysées', '75008', 'Paris'),
    (4, 'Rue des Capucins', '31000', 'Toulouse'),
    (5, 'Rue de la République', '13001', 'Marseille'),
    (6, 'Avenue du Prado', '13008', 'Marseille'),
    (7, 'Rue de la Pompe', '75116', 'Paris'),
    (8, 'Rue de l''Église', '69008', 'Lyon'),
    (9, 'Rue des Écoles', '31000', 'Toulouse'),
    (10, 'Rue de la Gare', '13002', 'Marseille');