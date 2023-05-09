<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Inscription</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row mb-5">
			<%@ include file="/WEB-INF/parts/header-nav.jsp"%>
		</header>
		
		<main>
			<div class="col-10 offset-1">
				<div class="row text-center">
					<h1 class="mt-5 mb-5">Mon profil</h1>
				</div>
				<form action="" method="post">
					<div class="container">
						<div class="row offset-2 mb-4">
							<div class="col-sm-5">
								<label>Pseudo :</label>
								<input class="form-control" autofocus="autofocus" name="pseudo" type="text">
							</div>
							<div class="col-sm-5">
								<label>Nom :</label>
								<input class="form-control" name="lastname" type="text">
							</div>
						</div>
						<div class="row offset-2 mb-4">
							<div class="col-sm-5">
								<label>Prénom :</label>
								<input class="form-control" name="firstname" type="text">
							</div>
							<div class="col-sm-5">
								<label>Email :</label>
								<input class="form-control" name="email" type="email">
							</div>
						</div>
						<div class="row offset-2 mb-4">
							<div class="col-sm-5">
								<label>Téléphone :</label>
								<input class="form-control" name="tel" type="tel">
							</div>
							<div class="col-sm-5">
								<label>Rue :</label>
								<input class="form-control" name="rue" type="text">
							</div>
						</div>
						<div class="row offset-2 mb-4">
							<div class="col-sm-5">
								<label>Code postal :</label>
								<input class="form-control" name="postalCode" type="text">
							</div>
							<div class="col-sm-5">
								<label>Ville :</label>
								<input class="form-control" name="city" type="text">
							</div>
						</div>
						<div class="row offset-2 mb-4">
							<div class="col-sm-5">
								<label>Mot de passe :</label>
								<input class="form-control" name="password" type="password">
							</div>
							<div class="col-sm-5">
								<label>Confirmation :</label>
								<input class="form-control" name="confirmPassword" type="password">
							</div>
						</div>
						<div class="row offset-2 mb-4">
							<div class="d-flex col-sm-5 text-end">
								<button type="submit" method="post" class="btn btn-success ">Créer</button>
							</div>
							<div class="d-flex col-sm-5 text-left">
								<a href=""><button class="btn btn-danger">Annuler</button></a>
							</div>
						</div>
						
					</div>				

				</form>
			</div>
		</main>
	
		<footer>
			<%@ include file="/WEB-INF/parts/footer.jsp"%>
		</footer>
	</div>
</body>
</html>