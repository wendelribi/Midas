<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Usuario</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand">MIDAS</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<li class="active"><a href="inicio.html">
						<button type="button" class="btn btn-primary"
							aria-label="Left Align">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
							${usuario.nome}
						</button> <span class="sr-only">(current)</span>
				</a></li>
				<li class="dropdown"><a href="controle.html"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false"><button
							type="button" class="btn btn-primary" aria-label="Left Align">
							<span class="glyphicon glyphicon-align-justify"
								aria-hidden="true"></span> Menu <span class="caret"></span>
						</button></a>
					<ul class="dropdown-menu">
						<li><a href="favoritos.html">Favoritos</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="historico.html">Historico</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="imagemProc.html">Imagens processadas salvas</a></li>
					</ul></li>
			</ul>

			<form action="submit.html" method="post"
				class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Procurar"
						name="search">
				</div>
				<button type="submit" class="btn btn-primary">Pesquisar</button>
			</form>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><button type="button"
							class="btn btn-primary" aria-label="Left Align">
							<span class="glyphicon glyphicon-question-sign"
								aria-hidden="true"></span> Ajuda <span class="caret"></span>
						</button> </a>
					<ul class="dropdown-menu">
						<li><a href="../../info/controller.html">Sobre nos</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="../../info/controle.html">Suporte</a></li>
					</ul></li>
				<li class="active"><a href="./controller.html">
						<button type="button" class="btn btn-primary"
							aria-label="Left Align">
							<span class="glyphicon glyphicon-off" aria-hidden="true"></span>
							Sair da Conta
						</button> <span class="sr-only">(current)</span>
				</a></li>
			</ul>
		</div>


		<c:forEach items="${mammogramId}" var="mammogramId">
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img
							src="${pageContext.request.contextPath}/imagens?id=${mammogramId}"
							class="img-thumbnail"
							alt="${pageContext.request.contextPath}/images?id=${mammogramId}"
							width="304" height="236">
						<div class="caption">
							<h3>Mamograma ${mammogramId} </h3>
							<p></p>
							<li><a href="imagem.html?mammogramId=${mammogramId}">
									<button type="button" class="btn btn-primary btn-lg">
										<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>Expandir
									</button>
							</a></li>
						</div>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
</nav>

<%if(request.getAttribute("mammogramVazio")!= null && request.getAttribute("mammogramVazio").equals("true")){ %>
    	<div class="alert alert-info" role="alert">
  			Sem mamogramas para mostrar
		</div>
<%} %>