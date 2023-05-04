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

<div class= "row text-center"> 
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

			<button type="button" class="btn btn-Warning">
				Se connecter</button>
			<div>
				<input type="checkbox" id="chk1" name="chk1" value="enrgMotDePasse">
				<label for="chk1"> Se souvenir de moi</label><br>

				<p>
					<a href="#"> Mot de passe oublié </a>
				</p>
			</div>
			<a href="<%= request.getContextPath() %>/inscription"><button type="button" class="btn btn-success">Creer un compte</button></a>
		</form>
	</div>
</div>

	<footer>
		<%@ include file="/WEB-INF/parts/footer.jsp"%>
	</footer>
</body>
</html>