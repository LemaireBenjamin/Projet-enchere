<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="javax.sound.sampled.TargetDataLine"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Enchere> encheres = (List<Enchere>) request.getAttribute("encheres");
String [] categories = application.getInitParameter("CATEGORIES").split(";");
HttpSession session1 = request.getSession(false);
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
	<%
	if (session1 != null && session1.getAttribute("utilisateur") != null) {
	   // L'utilisateur est connecté, afficher le header correspondant
	%>
	  	<jsp:include page="/WEB-INF/parts/header-nav.jsp"/>
	<%
	 	} else {
	   // L'utilisateur n'est pas connecté, afficher le header correspondant
	%>
	   	<jsp:include page="/WEB-INF/parts/header-accueil.jsp" />
	<%
	  }
	%>
	</header>	


		<main>
			<div class="col-10 offset-1">
			<div class="row text-center">
				<h1 class="mt-5 mb-5">Liste des enchères</h1>
			</div>
	
			<form action="" method="POST">
				<h3>Filtres :</h3>
				<div class="form-group col-10 d-flex flex-row">	
					<div class="d-flew flex-column col-5"> 
						<div> 
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Le nom de l'article contient" id="inputDefault">	
						</div>
						<div class="form-group">
							<label for="search" class="form-label col-5 mt-3"><h4>Catégories :</h4></label>
							<select class="form-select" id="search">
								<option value="">-- Choisir une catégorie --</option>
								<% for( String categorie : categories ){ %>
									<option><%= categorie %></option>
								<% } %>
							</select>
						</div>
					</div>
							<%
							if (session1 != null && session1.getAttribute("utilisateur") != null) {
					 		// L'utilisateur est connecté, afficher le header correspondant
							%>
						<div class="d-flex flex-row mt-3">
							<div class="form-check flex-column col-6">
						
       							<input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
        							<label class="form-check-label" for="optionsRadios1">
         								Achat
        							</label></br>
        							<label>
										<input type="checkbox" name="achat-checkbox" value="encheres-ouvertes">
							        		enchères ouvertes
							      	</label>
							      	<label>
							        	<input type="checkbox" name="achat-checkbox" value="mes-encheres-en-cours">
							        		mes enchères en cours
							      	</label>
							      	<label>
							        	<input type="checkbox" name="achat-checkbox" value="mes-encheres-remportees">
							        		mes enchères remportées
							      	</label>
        					</div>
	        					
	        					
        					<div class="form-check flex-column col-6">	
        						<input class="form-check-input" type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
									<label class="form-check-label" for="optionsRadios2">
										Mes ventes
									</label></br>
        							<label>
										<input type="checkbox" name="vente-checkbox" value="mes-ventes-en-cours">
 											mes ventes en cours
									</label>
									<label>
										<input type="checkbox" name="vente-checkbox" value="mes-encheres-en-cours">
 											mes enchères en cours
									</label>
									<label>
										<input type="checkbox" name="vente-checkbox" value="mes-encheres-remportees">
 											mes enchères remportées
									</label>
      						</div>
						</div>
						<%
						}
						%>
					</div>
					
					<div class="d-flex flex-column col-3  justify-content-center align-items-center">
						<button class="btn btn-lg btn-success col-10" type="submit">Rechercher</button>	
					</div>		
				</div>
				
			</form>
					<div class="row mt-5">
					<%
					for (Enchere enchere : encheres){
					%>
					<div class="col-4">
						<div class="card mb-4">
							<a href=""><h3 class="no-underline d-flex card-header justify-content-center align-items-center"><%= enchere.getArticleVendu().getNomArticle() %></h3></a>
							<div class="card-body" >
								<h5 class="card-title ">Prix : <%= enchere.getArticleVendu().getPrixVente() %> points</h5>
								<%
									LocalDate date = enchere.getDateEnchere();
							        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							        String DateFormatee = date.format(formater);
								%>
								<h6 class="card-subtitle text-muted">Fin de l'enchère : <%=  DateFormatee %></h6>
							</div>
							<svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="300" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size: 1.125rem; text-anchor: middle">
		    					<rect width="100%" height="100%" fill="#868e96"></rect>
		    					<text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image Article Vendu</text>
	  						</svg>
							<div class="card-body">
							
							<a class="navbar-brand" href="<%=request.getContextPath()%>">ENI - Enchères</a>
								<h5 class="card-text">Vendeur :<a href="<%=request.getContextPath()%>/profil/<%=enchere.getUtilisateur().getNoUtilisateur() %>" class="card-link"><%= enchere.getUtilisateur().getPseudo() %></a></h5>
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
	<script type="text/javascript">
		// Récupérer les éléments HTML des boutons radio et des cases à cocher pour la vente
		const achatRadio = document.getElementById('optionsRadios1');
		const venteRadio = document.getElementById('optionsRadios2');
		const venteCheckboxes = document.querySelectorAll('input[name="vente-checkbox"]');
		const achatCheckboxes = document.querySelectorAll('input[name="achat-checkbox"]');
	
		//Configuration par default
		venteCheckboxes.forEach((checkbox) => {
			checkbox.disabled = true;
			checkbox.checked = false;
		});
		// Ajouter un gestionnaire d'événements pour le changement d'état du bouton radio
		achatRadio.addEventListener('change', () => {
		  // Désactiver et griser les cases à cocher pour la vente
			venteCheckboxes.forEach((checkbox) => {
			    checkbox.disabled = true;
			    checkbox.checked = false;
			});
			achatCheckboxes.forEach((checkbox) => {
				    checkbox.disabled = false;
				    checkbox.checked = false;
			});
		});
		// Ajouter un gestionnaire d'événements pour le changement d'état du bouton radio
		venteRadio.addEventListener('change', () => {
		// Activer et dégriser les cases à cocher pour la vente
			venteCheckboxes.forEach((checkbox) => {
			    checkbox.disabled = false;
			    checkbox.checked = false;
			});
			achatCheckboxes.forEach((checkbox) => {
				checkbox.disabled = true;
				checkbox.checked = false;
			});
		});
	</script>
</body>
</html>