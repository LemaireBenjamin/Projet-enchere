<%@page import="fr.eni.encheres.helpers.Flash"%>
<%@page import="java.util.List"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>
<% List<String> erreurs = (List<String>) request.getAttribute("erreurs"); %>
<% String messageErreur = Flash.getMessage("error", request.getSession()); %>
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
			
				<%
					if(erreurs != null)
					for(String erreur : erreurs){	
				%>
				
				<div class="alert alert-danger">
					<%= erreur %>
				</div>
				
				<%} %>
				
				
				<%
					if(messageErreur != null){	
				%>
				
				<div class="alert alert-danger">
					<%= messageErreur %>
				</div>
				
				<%} %>				
			<form action="" method="post">
				<div class="row offset-3 mt-5">
					<div class="col-4">
						<label for="pseudo" >Pseudo :</label>
						<input autofocus="autofocus" name="pseudo" type="text"
						pattern="[A-Za-z0-9]+"
						value="${utilisateur.pseudo}">
					</div>
					<div class="col-4">
						<label for="nom" >Nom :</label>
						<input name="nom" type="text"
						value="${utilisateur.nom}">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="prenom" >Prénom :</label>
						<input name="prenom" type="text"
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
						<label for="telephone" >Téléphone :</label>
						<input name="telephone" type="tel"
						value="${utilisateur.telephone}">
					</div>
					<div class="col-4">
						<label for="rue" >Rue :</label>
						<input name="rue" type="text"
						value="${utilisateur.rue}">
					</div>
				</div>
				<div class="row offset-3 mt-4">
					<div class="col-4">
						<label for="codePostal" >Code postal :</label>
						<input name="codePostal" type="text"
						value="${utilisateur.codePostal}">
					</div>
					<div class="col-4">
						<label for="ville" >Ville :</label>
						<input name="ville" type="text"
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
						<a onclick="return confirm('Voulez-vous vraiment supprimer votre compte ?');" 
						href="<%= request.getContextPath() %>/supprimer-profil/${utilisateur.noUtilisateur }" class="btn btn-danger">Supprimer mon compte</a>
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