<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
HttpSession session1 = request.getSession(false);
Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); 
Utilisateur sessionUtilisateur = (Utilisateur) session1.getAttribute("utilisateur");
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Profil</title>
</head>
<body>
	
	<div class="container-fluid">
	
		<header class="row">
			<%@ include file="/WEB-INF/parts/header-connexion.jsp"%>
		</header>
		
		<main class="mt-5 offset-5 col-2 text-center">
			<div class="grid gap-3">
			<form action="" method="post">
					
					<div class="p-2 g-col-6">
						<label>Pseudo :</label>
						<label>${utilisateur.pseudo}</label>
					</div>
						
					<div class="p-2 g-col-6">
						<label for="lastname" >Nom :</label>
						<label>${utilisateur.nom}</label>
					</div>
			
					<div class="p-2 g-col-6">
						<label for="firstName" >Prénom :</label>
						<label>${utilisateur.prenom}</label>
					</div>
					
					
					<div class="p-2 g-col-6">
						<label for="email" >Email :</label>
						<label>${utilisateur.email}</label>
					</div>
				
					<div class="p-2 g-col-6">
						<label for="tel" >Téléphone :</label>
						<label>${utilisateur.telephone}</label>
					</div>
				
				
					<div class="p-2 g-col-6">
						<label for="road" >Rue :</label>
						<label>${utilisateur.rue}</label>
					</div>
				
				
					<div class="p-2 g-col-6">
						<label for="postalCode" >Code postal :</label>
						<label>${utilisateur.codePostal}</label>
					</div>
					
					<div class="p-2 g-col-6">
						<label for="city" >Ville :</label>
						<label>${utilisateur.ville}</label>
					</div>
			
			<% if (utilisateur.getNoUtilisateur() == sessionUtilisateur.getNoUtilisateur) {%>
				<div class="row offset-5 mt-4">
					<div class="col-2">
						<a href="<%= request.getContextPath() %>/modifier-profil/${utilisateur.noUtilisateur}">
						<button type="button" class="btn btn-success">Modifier</button></a>		
					</div>
					
				</div> 
			<% } %>
		</form>
		</div>
		</main>
	
		<footer>
			<%@ include file="/WEB-INF/parts/footer.jsp"%>
		</footer>
	</div>
</body>
</html>
