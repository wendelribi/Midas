<h:head>
	<title>Imagem</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
</h:head>


<a href="filtroBordas.html?mammogramId=${mammogramId}">
	<button type="button" class="btn btn-primary btn-lg" name="botao1"
		value="1">
		<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
		Bordas Comum
	</button>
</a>

<a href="filtroPrewitt.html?mammogramId=${mammogramId}">
	<button type="button" class="btn btn-primary btn-lg" name="botao2"
		value="2">
		<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
		Prewitt
	</button>
</a>

<a href="filtroRoberts.html?mammogramId=${mammogramId}">
	<button type="button" class="btn btn-primary btn-lg" name="botao3">
		<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
		Roberts
	</button>
</a>

<a href="filtroSobel.html?mammogramId=${mammogramId}">
	<button type="button" class="btn btn-primary  btn-lg">
		<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
		Sobel
	</button>
</a>

<a href="filtroNegativo.html?mammogramId=${mammogramId}">
	<button type="button" class="btn btn-primary btn-lg">
		<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
		Negativo
	</button>
</a>

	<%if(request.getAttribute("processar") != null){
			if( request.getAttribute("processar").equals("false")){ %>
	<a href="favoritar.html?mammogramId=${mammogramId}">
		<button type="button" class="btn btn-primary btn-lg">
			<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			Favoritar
		</button>
	</a>
	<%}else{ %>
	<a href="salvar.html?mammogramId=${mammogramId}">
		<button type="button" class="btn btn-primary btn-lg">
			<span class="glyphicon glyphicon-floppy-saved" aria-hidden="true"></span>
			Salvar
		</button>
	</a>	
	<%}}%>

<a href="inicio.html">
	<button type="button" class="btn btn-primary btn-lg">
		<span class="glyphicon glyphicon-hand-left" aria-hidden="true"></span>
		Voltar
	</button>
	
	
	
	<%if(request.getAttribute("processar").equals("false")){ %>
	<div class="container-fluid">
		<img
			src="${pageContext.request.contextPath}/imagens?id=${mammogramId}"
			class="img-thumbnail"
			alt="${pageContext.request.contextPath}/images?id=${mammogramId}"
			width="1000" height="600">
	</div>
	<%} else { %>
	<div class="container-fluid">
		<img
			src="${pageContext.request.contextPath}/processamento?id=${imageId}"
			class="img-thumbnail"
			alt="${pageContext.request.contextPath}/processamento?id=${imageId}"
			width="1000" height="600">
	</div>
	<%} %>
</a>