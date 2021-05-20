<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Profil</title>
</head>
<body>
<%@ include file="/fragments/header.html"%>
<div class="container">
Contenu de la page d'affichage d'un profil utilisateur.

<<<<<<< HEAD
${ArticleVendu.dateFinEncheres}
Pseudo : pseudo
Nom : nom
Prénom : prenom
Email : email
Téléphone : telephone
Rue : rue
Code postal : codePostal
Ville : ville

<!-- A faire : si id utilisateur de la session = id utilisateur de la page on affiche le bouton modifier -->
<c:if test=""><button type="submit">Modifier</button></c:if>

=======

	<form action='${pageContext.request.contextPath}/AffichageProfil' method="post">	
	<div>
        <label for="ps">Pseudo :</label>
        <input type="text" id="ps" name="pseudo">
    </div>
	
	<div>
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom">
    </div>
    <div>
        <label for="pr">Prenom :</label>
        <input type="text" id="pr" name="prenom">
    </div>
    
     <div>
        <label for="email">Email :</label>
        <input type="text" id="email" name="email">
    </div>
    
    <div>
        <label for="tel">Téléphone</label>
        <input type="text" id="tel" name="telephone">
    </div>
    
    <div>
        <label for="rue">Rue :</label>
        <input type="text" id="rue" name="rue">
    </div>
    
    <div>
        <label for="cp">Code postal :</label>
        <input type="text" id="cp" name="codePostal">
    </div>
    
    <div>
        <label for="ville">Ville :</label>
        <input type="text" id="ville" name="ville">
    </div>
    
    <div>
        <label for="mdp">Mot de passe :</label>
        <input type="text" id="mdp" name="motDePasse">
    </div>
    
    <div>
        <label for="cr">Crédit :</label>
        <input type="number" id="cr" name="credit">
        
    </div>
    
     <div>
        <label for="cr">Administrateur :</label>
        <input type="number" id="cr" name="isAdministrateur">
        
    </div> 
    <br>
        <input type="submit" value="Valider">
	
	</form>
	
>>>>>>> refs/remotes/origin/develop
</div>
<%@ include file="/fragments/footer.html"%>
</body>
</html>