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
			<div class="col-sm-5 offset-4">

				<div class="row">
					<div class="container">
						<h2 class="login-title">Se Connecter</h2>
						<br>
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

						<!-- Début Formulaire -->

						<form class="login-form" method="post">
							<div class="form-group row">
								<label for="login" class="col-sm-2 col-form-label">Identifiant</label>
								<div class="col-sm-6">
									<input type="text" name="login" class="form-control" id="login"
										placeholder=" pseudo ou email" required />
								</div>
							</div>
							<br>
							<div class="form-group row">
								<label for="password" class="col-sm-2 col-form-label">Mot
									de passe</label>
								<div class="col-sm-6">
									<input type="password" class="form-control" type="password"
										placeholder="password" name="password" required />
								</div>
							</div>
							<br>
							<!-- button -->
							<div class="d-flex bg-secondary mb-3">
								<div class="p-2">
									<button type="submit" class="btn btn-warning">Connexion</button>
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
							<!-- Fin button -->
							<a href="<%=request.getContextPath()%>/inscription"><button
									type="button" class="btn btn-success">Creer un compte</button></a>

						</form>
					</div>
				</div>
			</div>
		</main>
	</div>

	<footer>
		<%@ include file="/WEB-INF/parts/footer.jsp"%>
	</footer>

</body>
</html>