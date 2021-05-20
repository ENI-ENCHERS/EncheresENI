<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"><title>Se connecter</title>
</head>
<body class="d-flex flex-column h-100">
	<%@ include file="/fragments/header.html"%>
	<div class="container">
				<h1>Connexion</h1>
	<form method="post" action="connexion">
		<fieldset>
			<p>Vous pouvez vous connecter via ce formulaire.</p>

			<div class="row">
			<div class="col">
			<label for="pseudo">Identifiant : </label>
			</div>
			<div class="col"> 
			<input type="text" class="form-control" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />
			</div>
			</div> 
				<br/>
			<div class="row">
			<div class="col">
			<label for="motdepasse">Mot de passe : </label>
			</div> 
			<div class="col">
			<input type="password" class="form-control" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
			</div>
			</div> 
				<br/> 
				<div class="row">
				<div class="col">
				<button class="btn btn-light" type="submit" value="Reset">Connexion</button>
				</div> 
				<br/>
				<div class="col"> 
				<input type="checkbox" id="rememberme" name="rememberme" value="" /> 
				<label for="rememberme"> Se souvenir de moi</label>
				<br/> 
				<a href="">Mot de passe oublie</a>
				</div>
				</div> 
				
		</fieldset>
	</form>
	<button class="btn btn-light lg" type="submit" value="creer un compte">Creer un compte</button>
	</div>
	<%@ include file="/fragments/footer.html"%>
</body>
</html>