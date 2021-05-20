<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Nouvelle Vente</title>
</head>

<body>
    <%@ include file="/fragments/header.html"%>
    <div class="container">
    <h1>Nouvelle vente</h1>
    <form method="post" action="creationvente">
        <fieldset>
            <label for="article">Article : </label>
            <input type="text" class="form-control" id="article" name="article" value="" size="20" maxlength="20" />

            <label for="description">Description : </label>
            <input type="text" class="form-control" id="description" name="description" value="" size="20" maxlength="20" />

            <label for="categorie">Categorie : </label>
            <select class="form-select form-select-sm" class="form-control">
						<c:forEach var="Categorie" items="${List}" varStatus="iter">
<option value="${Categorie.categorieId}">${Categorie.libelle}</option>
</c:forEach>
					</select>
            <label for="photoarticle">Photo de l'article : </label>
            <input type="file" class="form-control" id="photoarticle" name="photoarticle" accept="image/png, image/jpeg" />

            <label for="prix">Mise a prix : </label>
            <input type="number" class="form-control" id="prix" name="prix" value="" size="20" maxlength="20" />

            <label for="datedebut">Debut de l'enchere : </label>
            <input type="date" class="form-control" id="datedebut" name="datedebut" value="" size="20" maxlength="20" />

            <label for="datefin">Fin de l'enchere : </label>
            <input type="date" class="form-control" id="datefin" name="datefin" value="" size="20" maxlength="20" />
            <br />
        </fieldset>
        <fieldset style="border:1px solid grey;padding:1em">
            <legend>Retrait</legend>
            <label for="motdepasse">Rue : </label>
            <input type="text" class="form-control" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
            <br />

            <label for="codepostal">Code Postal : </label>
            <input type="text" class="form-control" id="codepostal" name="codepostal" value="" size="20" maxlength="20" />
            <br/>

            <label for="motdepasse">Ville : </label>
            <input type="text" class="form-control" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
            <br/>
        </fieldset>

        <button class="btn btn-primary" type="submit" value="Enregistrer">Enregistrer</button>
        <button class="btn btn-light" type="reset" value="Reset">Annuler</button>
        <button class="btn btn-danger" type="submit" value="Annuler la vente">Annuler la vente</button>

        <br />
    </form>
    </div>
    <%@ include file="/fragments/footer.html"%>
</body>

</html>