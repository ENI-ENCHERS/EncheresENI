<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Se connecter</title>
</head>
<body class="d-flex flex-column h-100">
	<%@ include file="/fragments/header.html"%>
				<h2>Connexion</h2>
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
	<%@ include file="/fragments/footer.html"%>
</body>
</html>