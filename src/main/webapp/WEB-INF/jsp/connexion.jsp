<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%
List<String> erreurs = (List<String>) request.getAttribute("erreurs");
%>
<%
String erreurCnx = (String) request.getAttribute("erreur");
%>

<!DOCTYPE html>
<html>
<head>
<link href="/assets/css/syle-connexion.css" rel="stylesheet">
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Connection</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row mb-5">
			<%@ include file="/WEB-INF/parts/header-connexion.jsp"%>
		</header>
		<main>
			<h1>Veuillez vous identifier</h1>

			<div class="row mt-5">

				<div class="row text-center">
					<div class="container">
						<h2 class="login-title">Se Connecter</h2>
						<!--  -->
						<%
						if (erreurCnx != null) {
						%>
						<p color="red">
							<%=erreurCnx%>
						</p>
						<%
						}
						%>

						<%
						if (erreurs != null)
							for (String erreur : erreurs) {
						%>
						<p color="red">
							<%=erreur%>
						</p>
						<%
						}
						%>
						<!--  -->
						<form class="login-form" method="post">
							<div>
								<label for="login">Identifiant </label> <input id="login"
									type="text" placeholder=" pseudo ou email" name="login"
									required />
							</div>
							<br>
							<div>
								<label for="password">Mot de passe </label> <input id="password"
									type="password" placeholder="password" name="password" required />
							</div>


							<!-- Renvoyer à la page d'acceuil: modifier le header pour afficher vente ou enchere -->

							<div class="d-flex justify-content-center bg-secondary mb-3">
								<div class="p-2">
								
								<a href="<%=request.getContextPath()%>">
									<button type="submit" class="btn btn-warning">
										Connexion</button></a>
								</div>
								<div class="p-2 ">
									<input type="checkbox" id="chk1" name="chk1"
										value="enrgMotDePasse"> <label for="chk1"> Se
										souvenir de moi</label><br>
									<p>
										<a href="#"> Mot de passe oublié </a>
									</p>
								</div>
							</div>
					</div>

					<a href="<%=request.getContextPath()%>/inscription"><button
							type="button" class="btn btn-success">Creer un compte</button></a>
					</form>
				</div>
		</main>
	</div>
	

	<footer>
		<%@ include file="/WEB-INF/parts/footer.jsp"%>
	</footer>

	</div>
</body>
</html>