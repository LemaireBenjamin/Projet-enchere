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
<title>Nouvelle vente</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row mb-5">
			<%@ include file="/WEB-INF/parts/header-accueil.jsp"%>
		</header>

		<main>
			<div class="col-10 offset-1">
				<div class="row text-center">
					<h1 class="mt-5 mb-5">Nouvelle vente</h1>
				</div>

				<form action="" method="POST">

					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">Article</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="inputEmail3"
								placeholder="Fauteuil">
						</div>
					</div>
					<br>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">Description</label>
						<div class="col-sm-10">
							<textarea id="w3review" name="w3review" rows="4" cols="50">Fauteuil en cuir</textarea>
							<br>
						</div>
					</div>
				</form>

				<div class="form-group">
					<label for="search" class="form-label col-5 mt-3"><h4>Catégories
							:</h4></label> <select class="form-select" id="search">
						<option value=""> Maison </option>
						<%
						for (String categorie : categories) {
						%>
						<option><%=categorie%></option>
						<%
						}
						%>
					</select>
				</div>
				<br>
				<div class="form-group row">
					<label for="photoarticle" class="col-sm-2 col-form-label">Photo
						de l'article</label>
					<div class="col-sm-10">
						<input type="photoarticle" class="form-control" id="photoarticle"
							placeholder="Uploader">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="photoarticle" class="col-sm-2 col-form-label">Mise à prix
						</label>
					<div class="col-sm-10">
						<input type="photoarticle" class="form-control" id="photoarticle"
							placeholder="310">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="debutenchere" class="col-sm-2 col-form-label">Début de l'enchère
						</label>
					<div class="col-sm-10">
						<input type="debutenchere" class="form-control" id="debutenchere"
							placeholder="date debut">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="finenchere" class="col-sm-2 col-form-label">Fin de l'enchère
						</label>
					<div class="col-sm-10">
						<input type="finenchere" class="form-control" id="finenchere"
							placeholder="date fin">
					</div>
				</div>
				<br>
				<fieldset class="form-group">
					<div class="form-group row">
						<label for="Rue" class="col-sm-2 col-form-label">Rue</label>
						<div class="col-sm-10">
							<input type="Rue" class="form-control" id="Rue"
								placeholder="ex. 3 rue de la Porte">
						</div>
					</div>
					<br>
					<div class="form-group row">
						<label for="code postal" class="col-sm-2 col-form-label">Description</label>
						<div class="col-sm-10">
							<input type="codepostal" class="form-control" id="codepostal"
								placeholder="ex. 29200">
						</div>
					</div>
					<br>
					<div class="form-group row">
						<label for="ville" class="col-sm-2 col-form-label">Ville</label>
						<div class="col-sm-10">
							<input type="codepostal" class="form-control" id="ville"
								placeholder="ex. Brest">
						</div>
					</div>
				</fieldset>
			</div>
		</main>
	</div>

	<section>
		<form action=""></form>
	</section>
	<br>
	<section>
		<div class="d-flex justify-content-around bg-secondary mb-3">
			<div class="p-2 bg-info">
			<button type="submit" class="btn ">
				Enregistrer</button>
			</div>
			<div class="p-2 bg-warning">
			<button type="submit" class="btn">Annuler</button></div>
			<div class="p-2 bg-primary">
			<button type="submit" class="btn">Annuler la vente</button> </div>
		</div>
	</section>
	<section>
		<div class=""></div>
	</section>

	<footer>
		<%@ include file="/WEB-INF/parts/footer.jsp"%>
	</footer>
	
	
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