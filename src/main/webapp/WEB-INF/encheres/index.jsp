<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<title>Accueil</title>
</head>

<!-- On va faire une alternative pour conditionner l'affichage selon que l'utilisateur est connecté ou non -->


	<%@ include file="/fragments/header.html"%>
	<div class="container">
	<h1 align="center">Liste des encheres</h1>

	<div class="row">
		<strong class="fa fa-search">Filtres :</strong>
		<div class="col-md-8">
			<div class="pb-3">
				<input type="text" class="form-control"
					placeholder="Le nom de l'article contient">
			</div>
			<div class="row">
				<div class="col-md-2">
					<strong>Categories :</strong>
				</div>
				<div class="col-md-10">
					<select class="form-select form-select-sm"
						aria-label=".form-select-sm example">
						<option selected>Toutes</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="3">4</option>
					</select>
				</div>
			</div>
		</div>
		
	 <form action='${pageContext.request.contextPath}/AffichageRecherche' method="get">	 
		<div class="col-4 align-self-center">
			<button class="btn btn-primary btn-lg ">Rechercher</button>
		</div>		
	 </form> 
			<button class="btn btn-primary btn-lg ">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
</svg> 
Rechercher
</button>
		</div>
	</div>
	<hr>
<c:choose>
<c:when test="${ArticleVenduDao.size()>0}">
<!-- Cas où il y a des articles en vente -->
<c:forEach items="${ArticleVenduDao}">
<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-md-3">Photo de l'article</div>
						<div class="col">
							<h5 class="card-title">PC Gamer pour travailler</h5>
							<p class="card-text">
								Prix : 210 points<br />Fin de l'enchere: 10/08/2018<br />
								<strong>Vendeur :</strong> 
								<a href="${pageContext.request.contextPath}/listes?supprimer=${c.id}" class="badge text-danger" title="Supprimer">
								
								</a>
							</p>
						</div>
					</div>
				</div>
			</div>
</c:forEach>
</c:when>
<c:otherwise>
<!-- Cas où il n'y a aucun article en vente -->
<p>Il n'y a aucun objet en vente actuellement.</p>
</c:otherwise>
</c:choose>

<!--	<div class="row">
		<div class="col-sm-6">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-md-3">Photo de l'article</div>
						<div class="col">
							<h5 class="card-title">PC Gamer pour travailler</h5>
							<p class="card-text">
								Prix : 210 points<br />Fin de l'enchere: 10/08/2018<br />
								<strong>Vendeur :</strong> Jojo
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">2eme article</h5>
					<p class="card-text">
						Prix : <br />Fin de l'enchere: <br />
						<strong>Vendeur :</strong>
					</p>
				</div>
			</div>
		</div>
	</div> 
</div> -->
	<%@ include file="/fragments/footer.html"%>
</body>

</html>