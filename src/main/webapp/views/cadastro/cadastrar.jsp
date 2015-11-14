<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html">

<h:head>
	<title>Cadastro</title>
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
				<li role="presentation"><a href="../login/controller.html">Fazer
						Login   </a></li> 
			</ul>
			</nav>
		</div>
	</div>
	<form action="validacao.html" method="post">
		<div class="form-group"> <br/>
			<input type="text" class="form-control" placeholder="Nome"
				name="nome" aria-describedby="sizing-addon3">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Sobrenome"
				name="sobrenome">
		</div>

		<div class="form-group">
			<input type="text" class="form-control" placeholder="Cpf" name="cpf">
		</div>

		<div class="form-group">
			<input type="text" class="form-control" placeholder="Email"
				name="email">
		</div>

		<div class="form-group">
			<input type="text" class="form-control" placeholder="Profissao"
				name="profissao">
		</div>
	
		<div class="form-group">
			<input type="text" class="form-control" placeholder="(DD/MM/AAAA)"
				name="dataNascimento">
		</div>

		<div class="form-group">
			<input type="password" class="form-control" placeholder="Senha"
				name="senha">
		</div>

		<div class="form-group">
			<input type="password" class="form-control"
				placeholder="Confirmacao da senha" name="confirmacaoSenha">
		</div>
		
		<label class="radio-inline">
		  <input type="radio" name="sexo" id="inlineRadio1" value="masculino"> Masculino
		</label>
		
		<label class="radio-inline">
		  <input type="radio" name="sexo" id="inlineRadio2" value="feminino"> Feminino
		</label>
		 </br> </br>
		 
		<button type="submit" class="btn btn-success">Cadastrar</button>
	</form>
</h:body>
</html>
