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
String[] categories = application.getInitParameter("CATEGORIES").split(";");
%>


<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Liste des Encheres</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row mb-5">
			<%@ include file="/WEB-INF/parts/header-accueil.jsp"%>
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
									<input type="text" class="form-control"
										placeholder="Le nom de l'article contient" id="inputDefault">
								</div>
								<div class="form-group">
									<label for="search" class="form-label col-5 mt-3"><h4>Catégories :</h4></label> <select class="form-select" id="search">
										<option value="">-- Toutes --</option>
										<%
										for (String categorie : categories) {
										%>
										<option><%=categorie%></option>
										<%
										}
										%>
									</select>
								</div>

								<div
									class="d-flex flex-column col-5  justify-content-center align-items-center">
									<button class="btn btn-lg btn-success col-10" type="submit">Rechercher</button>
								</div>
							</div>
						</div>
				</form>
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