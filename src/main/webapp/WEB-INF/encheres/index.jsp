<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>

<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>

<body class="d-flex flex-column h-100">
	<%@ include file="/fragments/header.html"%>
	<h2 align="center">Liste des encheres</h2>
	Bonjour

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

		<div class="col-4 align-self-center">
			<button class="btn btn-primary btn-lg ">Rechercher</button>
		</div>
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

	<%@ include file="/fragments/footer.html"%>
</body>

</html>