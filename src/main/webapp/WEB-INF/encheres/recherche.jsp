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
<div class="container">
Contenu de la page d'affichage des resultats de la recherche.

		<p>Les articles :</p>
	<c:forEach items="${ listArticles }" var="a"> 
		<p>
			<c:out value="${ a.nomArticle}" />	
		</p>
		
	</c:forEach>
	<br>
		<p>Les catégories :</p>
	<c:forEach items="${ listCat }" var="cat"> 
		<p>
			<c:out value="${ cat.libelle}" />
		</p>
	</c:forEach>
	
	
	<form action='${pageContext.request.contextPath}/AffichageRecherche' method="post">
		<div>
        <label for="nom">nomArticle :</label>
        <input type="text" id="nom" name="nomArticle">
    </div>
    <div>
        <label for="desc">description :</label>
        <input type="text" id="desc" name="description">
    </div>
    
     <div>
        <label for="datedeb">Date de début :</label>
        <input type="date" id="datedeb" name="dateDebutEncheres">
    </div>
    
    <div>
        <label for="dateFin">Date de fin :</label>
        <input type="date" id="dateFin" name="dateFinEncheres">
    </div>
    
    <div>
        <label for="prixInit">Prix initial :</label>
        <input type="number" id="prixInit" name="miseAPrix">
    </div>
    
    <div>
        <label for="prixVente">Prix de vente :</label>
        <input type="number" id="prixVente" name="prixVente">
    </div>
    
    <div>
        <label for="NumUtil">Numero de l'utilisateur :</label>
        <input type="number" id="NumUtil" name="noUtilisateur">
    </div>
    
    <div>
        <label for="no_categorie"> Numero de la categorie :</label>
        <input type="number" id="no_categorie" name="noCategorie">
        
    </div>
    <br>
        <input type="submit" value="Valider">
	
	</form>
	

</div>
<%@ include file="/fragments/footer.html"%>
</body>
</html>