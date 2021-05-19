<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
>>>>>>> branch 'develop' of https://github.com/ENI-ENCHERS/EncheresENI.git
<!DOCTYPE html>
<html>
<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>

<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>

<!-- On va faire une alternative pour conditionner l'affichage selon que l'utilisateur est connecté ou non -->


<c:choose>
<c:when test="">
<!-- Cas où l'utilisateur est connecté -->
</c:when>
<c:otherwise>
<!-- Cas où l'utilisateur n'est pas connecté -->
</c:otherwise>
</c:choose>
<body class="d-flex flex-column h-100">
	<%@ include file="/fragments/header.html"%>
	<div class="container">
	<h2 align="center">Liste des encheres</h2>

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
<<<<<<< HEAD
			<button class="btn btn-primary btn-lg ">Rechercher</button>
		</div>		
	 </form> 
	
=======
			<button class="btn btn-primary btn-lg ">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
</svg> 
Rechercher
</button>
		</div>
>>>>>>> branch 'develop' of https://github.com/ENI-ENCHERS/EncheresENI.git
	</div>
	<hr>

	<div class="row">
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
</div>
	<%@ include file="/fragments/footer.html"%>
</body>

</html>