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

</div>
<%@ include file="/fragments/footer.html"%>
</body>
</html>