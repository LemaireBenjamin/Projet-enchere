<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="<%=request.getContextPath()%>">ENI - Enchères</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="<%= request.getContextPath() %>">Enchères</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Vendre un article</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<%=request.getContextPath()%>/profil/${utilisateur.noUtilisateur}">Mon profil</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Déconnexion</a>
			</li>
		</ul>
	</div>
</nav>
