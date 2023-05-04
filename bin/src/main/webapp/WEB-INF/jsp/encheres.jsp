<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/parts/meta.jsp"%>
<title>Accueil</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row">
			<%@ include file="/WEB-INF/parts/header-accueil.jsp"%>
		</header>

		<main class="row mt-5">
			<div class="row text-center">
				<h1>Liste des enchères</h1>
			</div>

			<div class="col-3 ">Filtres :</div>
				<div class="row form-group">
					<label for="search" class="form-label mt-3">Catégories :</label>
					<select class="form-select" id="search">
						<option>Faire une boucle sur les catégories</option>
					</select>
  					<button class="btn btn-lg btn-primary" type="submit">Rechercher</button>
			</div>
			<div>
				Liste ENCHERES 6 MAX par page
			</div>

	

		</main>

		<footer>
			<%@ include file="/WEB-INF/parts/footer.jsp"%>
		</footer>
	</div>
</body>
</html>