<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Profil</title>
</head>
<body>
	
	<div class="container-fluid">
	
		<header>
			<%@ include file="/WEB-INF/parts/header-connexion.jsp"%>
		</header>
		
		<main class="mt-5">
			
			<form action="" method="post">
				<div class="row offset-3 mt-5">
					<div class="col-4">
						<label>Pseudo :</label>
						<label>${utilisateur.pseudo}</label>
					</div>
						<div class="col-4">
						<label for="lastname" >Nom :</label>
						<label>${utilisateur.nom}</label>
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="firstName" >Prénom :</label>
						<label>${utilisateur.prenom}</label>
					</div>
					<div class="col-4">
						<label for="email" >Email :</label>
						<label>${utilisateur.email}</label>
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="tel" >Téléphone :</label>
						<label>${utilisateur.telephone}</label>
					</div>
					<div class="col-4">
						<label for="road" >Rue :</label>
						<label>${utilisateur.rue}</label>
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="postalCode" >Code postal :</label>
						<label>${utilisateur.codePostal}</label>
					</div>
					<div class="col-4">
						<label for="city" >Ville :</label>
						<label>${utilisateur.ville}</label>
					</div>
				</div>
				<!-- <div class="row offset-5 mt-4">
					<div class="col-2">
						<button type="submit" class="btn btn-success">Modifier</button>
					</div>
					
				</div> -->
		</form>
		</main>
	
		<footer>
			<%@ include file="/WEB-INF/parts/footer.jsp"%>
		</footer>
	</div>
</body>
</html>