-- Script de création de la base de données ENCHERES
--   type :      SQL Server 2012
--
--	Modifié par Benjamin LEMAIRE
--
-- DROP DATABASE ENCHERE_DB
-- CREATE DATABASE ENCHERE_DB
USE ENCHERE_DB;
GO

CREATE TABLE CATEGORIES (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL
)

ALTER TABLE CATEGORIES 
	ADD constraint categorie_pk 
		PRIMARY KEY (no_categorie)

CREATE TABLE ENCHERES (
    no_utilisateur   INTEGER NOT NULL,
    no_article       INTEGER NOT NULL,
    date_enchere     datetime NOT NULL,
	montant_enchere  INTEGER NOT NULL

)

ALTER TABLE ENCHERES 
	ADD constraint enchere_pk 
		PRIMARY KEY (no_utilisateur, no_article)

CREATE TABLE RETRAITS (
	no_article       INTEGER NOT NULL,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL
)

ALTER TABLE RETRAITS ADD constraint retrait_pk PRIMARY KEY  (no_article)

CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(150) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(30) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL
)

ALTER TABLE UTILISATEURS ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur)

-- Ajout de contraintes d'unicité pour le pseudo et l'email
ALTER TABLE UTILISATEURS ADD CONSTRAINT utilisateur_pseudo_uq UNIQUE (pseudo)
ALTER TABLE UTILISATEURS ADD CONSTRAINT utilisateur_email_uq UNIQUE (email)

-- Ajout d'une valeur par défaut pour le crédit
ALTER TABLE UTILISATEURS ADD CONSTRAINT utilisateur_credit_df DEFAULT 0 FOR credit

-- Ajout d'une contrainte sur le pseudo qui n'accepte que des caractères alphanumériques
ALTER TABLE UTILISATEURS ADD CONSTRAINT utilisateurs_login_ck CHECK (pseudo NOT LIKE '%[^0-9A-z]%')

CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
	etat_vente					  VARCHAR(30) NOT NULL,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL
)

ALTER TABLE ARTICLES_VENDUS ADD constraint articles_vendus_pk PRIMARY KEY (no_article)

-- ALTER TABLE ARTICLE_VENDUS ADD CONSTRAINT etat_vente_ck CHECK (etat_vente IN('Créée','En cours','Enchères terminées','Retrait effectué'))



ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) 
	REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action

ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE RETRAITS
    ADD CONSTRAINT retraits_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 


ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categories ( no_categorie )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY ( no_utilisateur )
        REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 
