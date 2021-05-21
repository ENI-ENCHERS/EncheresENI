<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>S'inscrire</title>
</head>
<body>
	<%@ include file="/fragments/header.html"%>
	<div class="container">
	<h1 align="center">Inscription</h1>
	<form id="formulaireInscription" action="inscription" method="POST">
		<fieldset>
			<div class="row">
				<div class="col">
					<label for="pseudo">Pseudo : </label> <input type="text"
						class="form-control" id="pseudo" name="pseudo" value="<c:out value="${pseudo}"/>" size="30" maxlength="30" />
						<span class="erreur">${form.erreurs['pseudo']}</span>
				</div>

				<div class="col">
					<label for="nom">Nom : </label> <input type="text"
						class="form-control" id="nom" name="nom" value="<c:out value="${nom}"/>" size="30" maxlength="30" />
						<div class="invalid-feedback"><span class="erreur">${form.erreurs['nom']}</span></div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label for="prenom">Prénom : </label> <input type="text"
						class="form-control" id="prenom" name="prenom" value="<c:out value="${prenom}"/>" size="30" maxlength="30" />
						<span class="erreur">${form.erreurs['prenom']}</span>
				</div>

				<div class="col">
					<label for="email">Email : </label> <input type="email"
						class="form-control" id="email" name="email" value="<c:out value="${email}"/>" size="20" maxlength="20" />
						<div class="invalid-feedback"><span class="erreur">${form.erreurs['email']}</span></div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label for="telephone">Téléphone : </label> 
					<input type="tel" class="form-control" id="telephone" name="telephone" value="<c:out value="${telephone}"/>" size="10" maxlength="10" />
						<span class="erreur">${form.erreurs['telephone']}</span>
				</div>

				<div class="col">
					<label for="rue">Rue : </label> <input type="text"
						class="form-control" id="rue" name="rue" value="<c:out value="${rue}"/>" size="30" maxlength="30" />
						<span class="erreur">${form.erreurs['rue']}</span>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label for="codePostal">Code Postal : </label> <input type="text"
						class="form-control" id="codePostal" name="codePostal" value="<c:out value="${codePostal}"/>" size="10" maxlength="10" />
						<span class="erreur">${form.erreurs['codePostal']}</span>
				</div>

				<div class="col">
					<label for="ville">Ville : </label> <input type="text"
						class="form-control" id="ville" name="ville" value="<c:out value="${ville}"/>" size="30" maxlength="30" />
						<span class="erreur">${form.erreurs['ville']}</span>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label for="motDePasse">Mot de passe : </label> 
					<input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="Caracteres alphanumeriques [A-Za-z0-9] seulement" value="<c:out value="${motDePasse}"/>" size="30" maxlength="30" />
					<div class="invalid-feedback"><span class="erreur">${form.erreurs['motDePasse']}</span></div>
				</div>

				<div class="col">
					<label for="confirmation">Confirmation : </label> 
					<input type="password" class="form-control" id="confirmation" name="confirmation" value="<c:out value="${email}"/>" size="30" maxlength="30" />
					<span class="erreur">${form.erreurs['confirmation']}</span>
				</div>
			</div>
			<br />
			<div align="center">
				<button class="btn btn-primary" type="submit" value="inscrireUtilisateur">Créer</button>
				<button class="btn btn-light" type="reset" value="Reset">Annuler</button>
			</div>
			<br/>
  
			<div class=" ${empty form.erreurs ? 'succes' : 'erreur'}" role="alert">${form.resultat}</div>
		</fieldset>
	</form>
	</div>
	<%@ include file="/fragments/footer.html"%>
</body>
</html>