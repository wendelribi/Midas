<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html">
<h:head>
	<title>Login</title>
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
			<nav class="nav navbar-nav">
			<ul class="nav nav-pills">
				<li role="presentation"><a href="../">Midas-Home</a></li>
				<li role="presentation"><a href="../cadastro/controller.html">Fazer
						Cadastro</a></li>
			</ul>
			</nav>
		</div>
	</div>
	
	<%
		if(request.getParameter("loginIncorreto") != null){	
			if(request.getParameter("loginIncorreto").equals("true")){
	%>	
		<div class="alert alert-danger" role="alert">
  			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  			<span class="sr-only">Error:</span>	Login ou senha incorreto(s)
		</div>
	<% } } %>
	
	<%
		if(request.getParameter("loginPendente") != null){	
			if(request.getParameter("loginPendente").equals("true")){
	%>	<div class="alert alert-danger" role="alert">
  			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  			<span class="sr-only">Error:</span>	Login pendente
		</div>
	<% } } %>
	
	<form action="controle.html" method="post">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Login"
				name="nome">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="Senha"
				name="senha">
		</div>

		<div class="checkbox">
			<label> <input type="checkbox"> Lembrar Login </label>
		</div>

		<button type="submit" class="btn btn-primary">Fazer Login</button>
	</form>

</h:body>
</html>