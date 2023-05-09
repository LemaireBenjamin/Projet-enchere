<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Connection</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row mb-5">
			<%@ include file="/WEB-INF/parts/header-connexion.jsp"%>
		</header>

		<main>
			<div class="col-10 offset-1">
				<div class="row text-center">
					<h1 class="mt-5 mb-5">Se connecter</h1>
				</div>


				<form class="login-form" method="post">
					<div>
						<label for="login">Identifiant </label> 
						<input id="login" type="text" placeholder=" identifiant" name="login" required />
					</div>
					<br>



					<div>
						<label for="password">Mot de passe </label> <input id="password"
							type="password" placeholder="password" name="password" required />
					</div>
					<p>
						<a href="#"> Mot de passe oublié </a>
					</p>

					<!-- Renvoyer à la page d'acceuil: modifier le header pour afficher vente ou enchere -->
					<button type="submit" class="btn btn-warning">Se connecter</button>
					
					<div>
						<input type="checkbox" id="chk1" name="chk1"
							value="enrgMotDePasse"> <label for="chk1"> Se souvenir de moi</label><br>


					</div>
					<a href="<%=request.getContextPath()%>/inscription"><button
							type="button" class="btn btn-success">Creer un compte</button></a>
				</form>
			</div>

			<footer>
				<%@ include file="/WEB-INF/parts/footer.jsp"%>
			</footer>
		</main>
	</div>
</body>
</html>