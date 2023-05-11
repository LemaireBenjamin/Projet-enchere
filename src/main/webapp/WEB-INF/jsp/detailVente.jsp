<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
Enchere enchere = (Enchere) request.getAttribute("enchere");

HttpSession session1 = request.getSession(false);
Utilisateur sessionUtilisateur = (Utilisateur) session1.getAttribute("utilisateur");
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Détail de la vente</title>
</head>
<body>
	
<div class="container-fluid">
	
	
	
	<header class="row">

		<jsp:include page="/WEB-INF/parts/header-connexion.jsp" />

	</header>	
	
		<main class="mt-5 offset-5 col-2 text-center">
		
		
		<div class="row text-center">
			<h1 class="mt-5 mb-5">Détail vente</h1>
		</div>
		
			
		
					<div class="card mb-3">
						  <h3 class="card-header"><%= enchere.getArticleVendu().getNomArticle() %></h3>
						  <div class="card-body">
						    <label>Description :</label>
						    <label><%= enchere.getArticleVendu().getDescription() %></label>
						  </div>
						  <div class="card-body">
						   
						   
						    <label class="pb-3">Categorie : </label>
						 	<label><%= enchere.getArticleVendu().getCategorieArticle().getLibelle() %></label>
						 
						  <br>
						  	
						  	
						  	<label class="pb-3">Meilleure offre : </label>
						 	<label><%= enchere.getMontantEnchere() %></label>
						  	
						  	<br>
						  	
						  	
						  	<label class="pb-3">Mise à prix : </label>
						 	<label><%= enchere.getArticleVendu().getPrixInitial() %></label>
						  
						  <br>
						  	
						  	<label class="pb-3">Fin de l'enchère : </label>
						 	<label><%= enchere.getArticleVendu().getDateFinEncheres() %></label>
						  
						  <br>
						  	
						  	<label>Retrait : </label>
						 	<label class="pb-3"><%= enchere.getArticleVendu().getLieuRetrait() %></label>
						  	
						  <br>
						  
						  	<label class="pb-3">Vendeur : </label>
						 	<label><%= enchere.getUtilisateur().getPseudo() %></label>
						  	
						  </div>
						 <!--  <ul class="list-group list-group-flush">
						    
						  </ul>
						  <div class="card-body">
					
						
						  </div>
						  <div class="card-footer text-muted">
						 
						  </div> -->
						</div>
						
		
		
		</main>
	
	<footer>
			<%@ include file="/WEB-INF/parts/footer.jsp"%>
	</footer>
	
</div>

</body>
</html>