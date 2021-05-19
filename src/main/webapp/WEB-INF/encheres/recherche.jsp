<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rechercher</title>
</head>
<body>
<%@ include file="/fragments/header.html"%>
Contenu de la page d'affichage des resultats de la recherche.

	<form action='${pageContext.request.contextPath}/AffichageRecherche' method="post">
		<div>
        <label for="nom">nomArticle :</label>
        <input type="text" id="nom" name="nom_article" value="${ nom_article }">
    </div>
    <div>
        <label for="desc">description :</label>
        <input type="text" id="desc" name="description" value= "${ description }">
    </div>
    
     <div>
        <label for="datedeb">Date de début :</label>
        <input type="date" id="datedeb" name="dateDebutEncheres" value= "${ dateDebutEncheres }">
    </div>
    
    <div>
        <label for="dateFin">Date de fin :</label>
        <input type="date" id="dateFin" name="dateFinEncheres" value= "${ dateFinEncheres }">
    </div>
    
    <div>
        <label for="prixInit">Prix initial :</label>
        <input type="number" id="prixInit" name="miseAPrix" value= "${ miseAPrix }">
    </div>
    
    <div>
        <label for="prixVente">Prix de vente :</label>
        <input type="number" id="prixVente" name="prixVente" value= "${ prixVente }">
    </div>
    
    <div>
        <label for="NumUtil">Numero de l'utilisateur :</label>
        <input type="number" id="NumUtil" name="numUtilisateur" value= "${ numUtilisateur }">
    </div>
    
    <div>
        <label for="numCat"> Numero de la categorie :</label>
        <input type="number" id="numCat" name="numCategorie" value= "${ numCategorie }">
        
    </div>
    <br>
        <input type="submit" value="Valider">
	
	</form>

<%@ include file="/fragments/footer.html"%>
</body>
</html>