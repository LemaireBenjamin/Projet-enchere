<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Inscription</title>
</head>
<body>
	<div class="container-fluid">
		<header>
			<%@ include file="/WEB-INF/parts/header-connexion.jsp"%>
		</header>
		
		<main class="mt-5">
			<div class="row text-center">
				<h1>Mon profil</h1>
			</div>
			<form action="" method="post">
				<div class="row offset-3 mt-5">
					<div class="col-4">
						<label for="pseudo" >Pseudo :</label>
						<input autofocus="autofocus" name="pseudo" type="text">
					</div>
						<div class="col-4">
						<label for="lastname" >Nom :</label>
						<input name="lastname" type="text">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="firstName" >Prénom :</label>
						<input name="firstName" type="text">
					</div>
					<div class="col-4">
						<label for="email" >Email :</label>
						<input name="email" type="email">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="tel" >Téléphone :</label>
						<input name="tel" type="tel">
					</div>
					<div class="col-4">
						<label for="road" >Rue :</label>
						<input name="road" type="text">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="postalCode" >Code postal :</label>
						<input name="postalCode" type="text">
					</div>
					<div class="col-4">
						<label for="city" >Ville :</label>
						<input name="city" type="text">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="password" >Mot de passe :</label>
						<input name="password" type="password">
					</div>
					<div class="col-4">
						<label for="confirmPassword" >Confirmation :</label>
						<input name="confirmPassword" type="password">
					</div>
				</div>
				<div class="row offset-5 mt-4">
					<div class="col-2">
						<button type="submit" class="btn btn-success">Confirmer</button>
					</div>
					<div class="col-2">
						<a href="<%= request.getContextPath() %>"><button type="button" class="btn btn-danger px-10">Annuler</button></a>
					</div>
				</div>
		</form>
		</main>
	
		<footer>
			<%@ include file="/WEB-INF/parts/footer.jsp"%>
		</footer>
	</div>
</body>
</html>