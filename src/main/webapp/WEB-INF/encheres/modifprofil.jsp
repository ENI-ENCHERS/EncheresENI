<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
			<title>Modifier le profil</title>
		</head>
		<body class="d-flex flex-column h-100"><%@ include file="/fragments/header.html"%>
			<div class="container">
				<h1 align="center">Mon profil</h1>
				<c:choose>
					<c:when test="${cnx}">
						<form action="<%=request.getContextPath() %>/modules/module4/ServletAjoutAvis" method="POST">
							<fieldset>
								<p>Vous pouvez modifier votre profil.</p>
								<div class="row">
									<div class="col">
										<label for="pseudo">Pseudo :</label>
										<input type="text" class="form-control" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />
									</div>
									<div class="col">
										<label for="nom">Nom : </label>
										<input type="text" class="form-control" id="nom" name="nom" value="" size="20" maxlength="20" />
									</div>
								</div>
								<div class="row">
									<div class="col">
										<label for="prenom">Prénom : </label>
										<input type="text" class="form-control" id="prenom" name="prenom" value="" size="20" maxlength="20" />
									</div>
									<div class="col">
										<label for="email">Email : </label>
										<input type="email" class="form-control" id="email" name="email" value="" size="20" maxlength="60" />
									</div>
								</div>
								<div class="row">
									<div class="col">
										<label for="telephone">Téléphone : </label>
										<input type="tel" class="form-control" id="telephone" name="telephone" value="" size="20" maxlength="60" />
									</div>
									<div class="col">
										<label for="rue">Rue : </label>
										<input type="text" class="form-control" id="rue" name="rue" value="" size="20" maxlength="60" />
									</div>
								</div>
								<div class="row">
									<div class="col">
										<label for="codePostal">Code Postal : </label>
										<input type="text" class="form-control" id="codePostal" name="codePostal" value="" size="20" maxlength="60" />
									</div>
									<div class="col">
										<label for="ville">Ville : </label>
										<input type="text" class="form-control" id="ville" name="ville" value="" size="20" maxlength="60" />
									</div>
								</div>
								<div class="row">
									<div class="col-6">
										<label for="motdepasse">Mot de passe actuel : </label>
										<input type="password" class="form-control" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
									</div>
								</div>
								<div class="row">
									<div class="col">
										<label for="nouveaumotdepasse">Mot de passe : </label>
										<input type="password" class="form-control" id="nouveaumotdepasse" name="nouveaumotdepasse" value="" size="20" maxlength="20" />
									</div>
									<div class="col">
										<label for="confirmation">Confirmation : </label>
										<input type="password" class="form-control" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
									</div>
								</div>
								<p>Credit :</p>
								<button class="btn btn-primary" type="submit" value="Enregistrer">Enregistrer</button>
								<button class="btn btn-danger" type="submit" value="Supprimer mon compte">Supprimer mon compte</button>
								<br />
							</fieldset>
						</form>
					</c:when>
					<c:otherwise>
						<p>Vous devez être connecté.e pour effectuer cette action.</p>
					</c:otherwise>
				</c:choose>
			</div><%@ include file="/fragments/footer.html"%>
		</body>
	</html>