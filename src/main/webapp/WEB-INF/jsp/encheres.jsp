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
String [] categories = application.getInitParameter("CATEGORIES").split(";");
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
			<div class="col-10 offset-1">
			<div class="row text-center">
				<h1 class="mb-5">Liste des enchères</h1>
			</div>
			<form action="" method="POST">
				<h4>Filtres :</h4>
				<div class="form-group col-10 d-flex flex-row">	
					<div class="d-flew flex-column col-5"> 
						<div> 
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Le nom de l'article contient" id="inputDefault">	
						</div>
						<div class="form-group">
							<label for="search" class="form-label col-5 mt-3">Catégories :</label>
							<select class="form-select" id="search">
								<option value="">-- Choisir une catégorie --</option>
								<% for( String categorie : categories ){ %>
									<option><%= categorie %></option>
								<% } %>
							</select>
						</div>
					</div>
					
					<div class="d-flex flex-row mt-3">
							<div class="form-check flex-column col-5">
       							<input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
        							<label class="form-check-label" for="optionsRadios1">
         								Achat
        							</label>
        					</div>
        					
        					
        					<div class="form-check flex-column col-5">	
        						<input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
									<label class="form-check-label" for="optionsRadios2">
										Mes ventes
									</label>
      						</div>
					</div>
					
					
							
					</div>
					<div class="d-flex flex-column col-5  justify-content-center align-items-center">
						<button class="btn btn-lg btn-success col-10" type="submit">Rechercher</button>	
					</div>		
				</div>
			</form>
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
								<p class="card-text">No Article : <%= enchere.getArticleVendu().getNoArticle() %></p>
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