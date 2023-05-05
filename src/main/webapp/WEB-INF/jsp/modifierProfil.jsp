<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Modification - Profil</title>
</head>
<body>
		<div class="container-fluid">
	
		<header class="row">
			<%@ include file="/WEB-INF/parts/header-connexion.jsp"%>
		</header>
		
		<main class="mt-5 ">
			
			<form action="" method="post">
				<div class="row offset-3 mt-5">
					<div class="col-4">
						<label for="pseudo" >Pseudo :</label>
						<input autofocus="autofocus" name="pseudo" type="text"
						value="${utilisateur.pseudo}">
					</div>
						<div class="col-4">
						<label for="lastname" >Nom :</label>
						<input name="lastname" type="text"
						value="${utilisateur.nom}">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="firstName" >Prénom :</label>
						<input name="firstName" type="text"
						value="${utilisateur.prenom}">
					</div>
					<div class="col-4">
						<label for="email" >Email :</label>
						<input name="email" type="email"
						value="${utilisateur.email}">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="tel" >Téléphone :</label>
						<input name="tel" type="tel"
						value="${utilisateur.telephone}">
					</div>
					<div class="col-4">
						<label for="road" >Rue :</label>
						<input name="road" type="text"
						value="${utilisateur.rue}">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="postalCode" >Code postal :</label>
						<input name="postalCode" type="text"
						value="${utilisateur.codePostal}">
					</div>
					<div class="col-4">
						<label for="city" >Ville :</label>
						<input name="city" type="text"
						value="${utilisateur.ville}">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="password" >Mot de passe :</label>
						<input name="password" type="password">
					</div>
					
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="nouveauPassword" >Nouveau mot de passe :</label>
						<input name="nouveauPassword" type="password">
					</div>
					<div class="col-4">
						<label for="confirmPassword" >Confirmation :</label>
						<input name="confirmPassword" type="password">
					</div>
				</div>
				
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label>Crédit</label>
						<label>${utilisateur.credit}</label>
					</div>
				</div>
				
				
				<div class="row offset-5 mt-4">
					<div class="col-2">
						<button type="submit" class="btn btn-success">Enregistrer</button>	
					</div>
					<div class="col-2">
						<a href="<%= request.getContextPath() %>"><button type="button" class="btn btn-danger px-10">Supprimer mon compte</button></a>
					</div>
				</div> 
		</form>
	
	<div class="container">
  <div class="row">
    <div class="col-md-6">
      <div class="form-check">
        <input class="form-check-input" type="radio" name="exampleRadios" id="radio1" value="option1" checked>
        <label class="form-check-label" for="radio1">
          Radio 1
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="exampleRadios" id="radio2" value="option2">
        <label class="form-check-label" for="radio2">
          Radio 2
        </label>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-check">
        <input class="form-check-input" type="radio" name="exampleRadios" id="radio3" value="option3">
        <label class="form-check-label" for="radio3">
          Radio 3
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="exampleRadios" id="radio4" value="option4">
        <label class="form-check-label" for="radio4">
          Radio 4
        </label>
      </div>
    </div>
  </div>
</div>


		</main>
	
		<footer>
			<%@ include file="/WEB-INF/parts/footer.jsp"%>
		</footer>
	</div>
</body>
</html>