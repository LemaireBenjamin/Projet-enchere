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
		<header class="row">
			<%@ include file="/WEB-INF/parts/header-connexion.jsp"%>
		</header>
	</div>

	<div class="row mt-5">

		<div class="row text-center">
			<div class="container">
				<h2 class="login-title">Se Connecter</h2>


				<form class="login-form">
					<div>
						<label for="name">Identifiant </label> <input id="name"
							type="text" placeholder=" identifiant" name="name" required />
					</div>
					<br>

					<div>
						<label for="password">Mot de passe </label> <input id="password"
							type="password" placeholder=" mot de passe" name="password"
							required />
					</div>

					<br>
					<button type="button" class="btn btn-Danger">Se connecter</button>
					<div>
						<input type="checkbox" id="chk1" name="chk1"
							value="enrgMotDePasse"> <label for="chk1"> Se
							souvenir de moi</label><br>

						<p>
							<a href="#"> Mot de passe oublié </a>
						</p>
					</div>
					<button type="button" class="btn btn-success">Creer un
						compte</button>
				</form>
				<br>
			</div>
		</div>
	</div>

	<footer>
		<%@ include file="/WEB-INF/parts/footer.jsp"%>
	</footer>
</body>
</html>