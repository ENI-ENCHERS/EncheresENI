<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Detail de la vente</title>
</head>
<body>
	<%@ include file="/fragments/header.html"%>
	<div class="container">
	<h1>Detail vente</h1>
	Affichage du detail de la vente
	</div>
	
	<form action='${pageContext.request.contextPath}/AffichageDetailVente' method="post">
		<div>
        <label for="dte">Date enchère :</label>
        <input type="DATE" id="dte" name="dateDebutEncheres">
    </div>
    <div>
        <label for="mont">Montant encère :</label>
        <input type="number" id="mont" name="montantEnchere">
    </div>
    
    <div>
        <label for="desc">Numéro article :</label>
        <input type="enumber" id="desc" name="idArticle">
    </div>
    
     <div>
        <label for="util">Numéro utilisateur :</label>
        <input type="number" id="util" name="idUtilisateur">
    </div>
    
    <br>
        <input type="submit" value="Valider">
	
	</form>
	
	<%@ include file="/fragments/footer.html"%>
</body>
</html>