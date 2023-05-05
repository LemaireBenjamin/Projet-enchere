<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="javax.sound.sampled.TargetDataLine"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
List<Enchere> encheres = (List<Enchere>) request.getAttribute("encheres");
%>	
	
	
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Accueil</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row">
			<%@ include file="/WEB-INF/parts/header-accueil.jsp"%>
		</header>

		<main class="row mt-5">
			<div class="row text-center">
				<h1>Liste des enchères</h1>
			</div>

			<div>Filtres :</div>
				<div class="row form-group">
					<label for="search" class="form-label mt-3">Catégories :</label>
					<select class="form-select" id="search">
						<option>Faire une boucle sur les catégories</option>
					</select>
  					<button class="btn btn-lg btn-primary" type="submit">Rechercher</button>
			</div>




				<div class="col-8 offset-2">
					<div class="row mt-5">

					<%
					for (Enchere enchere : encheres){
					%>
					<div class="col-4">
						<div class="card mb-3">
							<h3 class="card-header" min ><%= enchere.getArticleVendu().getNomArticle() %></h3>
							<div class="card-body" >
								<h5 class="card-title "><%= enchere.getArticleVendu().getPrixVente() %></h5>
								<%
									LocalDate date = enchere.getDateEnchere();
							        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							        String DateFormatee = date.format(formater);
								%>
								<h6 class="card-subtitle text-muted"><%=  DateFormatee %></h6>
							</div>
							<svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="200" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size: 1.125rem; text-anchor: middle">
		    					<rect width="100%" height="100%" fill="#868e96"></rect>
		    					<text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image Article Vendu</text>
	  						</svg>
							<div class="card-body">
								<p class="card-text">Vendeur : <%= enchere.getUtilisateur().getPseudo() %></p>
							</div>
						</div>
						
					</div>
					<% } %>
				</div>
			</div>

	

		</main>

		<footer>
			<%@ include file="/WEB-INF/parts/footer.jsp"%>
		</footer>
	</div>
</body>
</html>