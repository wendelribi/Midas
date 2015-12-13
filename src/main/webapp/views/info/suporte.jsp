<h:head>
	<title>INFO</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
</h:head>


<h:body>

	<div class="container">
		<div class="row">
			<nav class="navbar-form navbar-left">
				<ul class="nav nav-pills">
					<li><a href="javascript:history.go(-1)">
							<button type="button" class="btn btn-primary btn-lg">
								<span class="glyphicon glyphicon-hand-left" aria-hidden="true"></span>
								Voltar
							</button>
					</a></li>
		</div>
		<div class="jumbotron">
			<center>
				<h1>MIDAS</h1>
			</center>
			</br>
			<center>
				<p>Fale conosco:</p>
				<p>
				<form action="contato.html" method="post">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Email"
							name="email">
					</div>
					<div class="form-group">
						<textarea class="form-control" rows="3" placeholder="Mensagem"
							name="mensagem"> </textarea>
					</div>

					<% if (request.getAttribute("emailInvalido") != null && request.getAttribute("emailInvalido").equals(false)) { %>
					
						<% if (request.getAttribute("emailEnviado") != null && request.getAttribute("emailEnviado").equals(false)) { %>
							<script language="JavaScript" type="text/javascript">
								alert("Erro ao enviar o e-mail (TIMEOUT)")
							</script>
						<% } %>
					<% } else { %>
						<% if (request.getAttribute("emailInvalido") != null && request.getAttribute("emailInvalido").equals(true)) { %>
							<script language="JavaScript" type="text/javascript">
								alert("E-mail invalido")
							</script>
						<% } %>
					<% } %>



					<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					Enviar mensagem</button>
				</form>
				</p>
			</center>
		</div>
</h:body>
</html>