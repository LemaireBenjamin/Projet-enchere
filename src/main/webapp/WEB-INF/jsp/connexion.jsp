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
			<%@ include file="/WEB-INF/parts/header-nav.jsp"%>
		</header>
	</div>

	<div class="container">
		<h2 class="login-title">Se Connecter</h2>

		<form class="login-form">
			<div>
				<label for="name">Identifiant </label> <input id="name" type="text"
					placeholder="Eren Buruk" name="name" required />
			</div>

			<div>
				<label for="password">Mot de passe </label> <input id="password"
					type="password" placeholder="password" name="password" required />
			</div>

			<button class="btn btn--form" type="submit" value="Log in">
				Se connecter</button>
			<div>
				<input type="checkbox" id="chk1" name="chk1" value="enrgMotDePasse">
				<label for="chk1"> Se souvenir de moi</label><br>

				<p>
					<a href="#"> Mot de passe oublié </a>
				</p>
			</div>
			<button class="btn btn--form" type="submit" value="Log in">
				Creer un compte</button>
		</form>
	</div>

</body>
</html>