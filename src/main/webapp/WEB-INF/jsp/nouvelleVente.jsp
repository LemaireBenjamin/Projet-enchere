<%@page import="fr.eni.encheres.bo.Utilisateur"%>
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
HttpSession session1 = request.getSession(false);
Utilisateur sessionUtilisateur = (Utilisateur) session1.getAttribute("utilisateur");
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
			<%@ include file="/WEB-INF/parts/header-nav.jsp"%>
		</header>

		<main>
			<section>
				<div class="logo">
					<img src="<%=request.getContextPath()%>/assets/img/logo.jpg"
						alt="logo" width="100" height="150">
				</div>

				<div class="col-sm-6 offset-3">
					<div class="row text-center">
						<h1 class="mt-5 mb-5">Nouvelle vente</h1>
					</div>
					<!-- Formulaire -->
					<form action="" method="POST">

						<div class="form-group row">
							<label for="nom-article" class="col-sm-2 col-form-label">Article</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="nom-article"
									name="nom-article" placeholder="Fauteuil">
							</div>
						</div>
						<br>
						<div class="form-group row">
							<label for="text" class="col-sm-2 col-form-label">Description</label>
							<div class="col-sm-10">
								<textarea id="description" name="description" rows="4" cols="50">Fauteuil en cuir</textarea>
								<br>
							</div>
						</div>
			

					<div class="form-group">
						<label for="categorie" class="form-label col-5 mt-3"><h4>Catégories:</h4></label>
						<select class="form-select" id="categorie" name="categorie">

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
						<label for="photo-article" class="col-sm-2 col-form-label">Photo
							de l'article</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="photo-article"
								name="photo-article" placeholder="Uploader">
						</div>
					</div>

					<br>
					<div class="form-group row">
						<label for="mise-a-prix" class="col-sm-2 col-form-label">Mise
							à prix </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="mise-a-prix"
								name="mise-a-prix" placeholder="310">
						</div>
					</div>
					<br>
					<div class="form-group row">
						<label for="debut-enchere" class="col-sm-2 col-form-label">Début
							de l'enchère </label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="debut-enchere"
								name="debut-enchere" placeholder="10/08/2018">
						</div>
					</div>
					<br>
					<div class="form-group row">
						<label for="fin-enchere" class="col-sm-2 col-form-label">Fin
							de l'enchère </label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="fin-enchere"
								name="fin-enchere" placeholder="01/09/2018">
						</div>
					</div>
					<br>

						<fieldset>
							<legend>Retrait</legend>
							<div class="form-group row">
								<label for="road" class="col-sm-2 col-form-label">Rue</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="road" name="road"
										placeholder="Rue des Mouettes" value="<%= sessionUtilisateur.getRue() %>">
								</div>
							</div>
							<br>
							<div class="form-group row">
								<label for="postalCode" class="col-sm-2 col-form-label">Code
									postal</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="postalCode"
										name="postalCode" placeholder="44800" value="<%= sessionUtilisateur.getCodePostal() %>">
								</div>
							</div>
							<br>
							<div class="form-group row">
								<label for="city" class="col-sm-2 col-form-label">Ville</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="city" name="city"
										placeholder="Saint Herblain" value="<%= sessionUtilisateur.getVille() %>">
								</div>
							</div>
						</fieldset>
						<section>
							<br> <br>
								<section>
									<div class="col-sm-6 offset-3 text-center">
										<div class="d-flex justify-content-around bg-secondary mb-3">
											<div class="p-2 bg-info">
												<button type="submit" class="btn ">Enregistrer</button>
											</div>
											<div class="p-2 bg-warning">
												<button type="reset" class="btn">Annuler</button>
											</div>
											<div class="p-2 bg-primary">
												<button type="submit" class="btn">Annuler la vente</button>
											</div>
										</div>
									</div>
								</section>
						</section>
					</form>
				</div>
			</section>


		</main>
	</div>
	<br>
	<footer>
		<%@ include file="/WEB-INF/parts/footer.jsp"%>
	</footer>
</body>
</html>