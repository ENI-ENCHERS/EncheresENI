USE BDD_ENCHERES
GO 

-- Insertion donnees pour test
-- Ne pas oublier d'adapter les valeurs no_utilisateur, no_categorie si on teste plusieurs fois (incr�mental)
BEGIN TRANSACTION
INSERT INTO CATEGORIES (libelle)
	VALUES	('V�tements'),
			('Electrom�nager'),
			('Animalerie'),
			('Jouets et jeux'),
			('Livres et BD'),
			('Maison'),
			('Sports'),
			('Musique');

SELECT * FROM CATEGORIES;

INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)
	VALUES	('izi','marega','issa','maregaissa@hotmail.com','0605845704','rue des Champions','35000','Rennes','issa123','3000',1),
			('bob','Bon','Robert','robert@hotmail.com','0605000001','rue des Fleurs','35510','Cesson Sevigne','bob123','1000',1);

SELECT * FROM UTILISATEURS;

INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie)
	VALUES	('Guitare Electrique Ibanez','Une guitare �lectrique pour faire des riffs endiabl�s!',getdate(),dateadd(day,8,getdate()),100,150,1,8),
			('Kallax 8 cases','Meuble Kallax 8 cases comme neuf.',getdate(),dateadd(day,8,getdate()),40,55,2,6);

SELECT * FROM ARTICLES_VENDUS;

INSERT INTO RETRAITS (no_article,rue,code_postal,ville)
	VALUES	(1,'2 rue de la Margoulette','35000','Rennes'),
			(2,'rue des Gentils','59000','Lille');

SELECT * FROM RETRAITS;

--Penser � mettre la m�me fonction getdate que pour les articles_vendus concern�s pour faire ses tests

INSERT INTO ENCHERES(date_enchere,montant_enchere,no_article,no_utilisateur)
	VALUES	(dateadd(day,8,getdate()),150,1,1),
			(dateadd(day,8,getdate()),55,2,2);

SELECT * FROM ENCHERES;

ROLLBACK;