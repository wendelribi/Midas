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
				<li><a  href="../" >
					<button type="button" class="btn btn-primary btn-lg">
						<span class="glyphicon glyphicon-home" aria-hidden="true"></span> Midas Home  
						</button>
						</a></li>
						
						<li><a href="../login/controller.html" >
						<button type="button" class="btn btn-primary btn-lg">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span> Fazer Login  
					</button>
				</a></li>
			</ul>
			</nav>
		</div>
	</div>
	
	<form action="validacao.html" method="post">
		<c:forEach items="${usuario}" var="usuario">
		
			<input type="text" hidden="true" name="erroNome" value="${erroNome}"> 
			<input type="text" hidden="true" name="erroCpf" value="${erroCpf}">
			<input type="text" hidden="true" name="erroEmail" value="${erroEmail}">
			<input type="text" hidden="true" name="erroProfissao" value="${erroProfissao}">
			<input type="text" hidden="true" name="erroGenero" value="${erroGenero}">
			<input type="text" hidden="true" name="erroData" value="${erroData}">
			<input type="text" hidden="true" name="erroSenha" value="${erroSenha}">
			<input type="text" hidden="true" name="cpfExiste" value="${cpfExiste}">
			
			<%
			if(request.getAttribute("erroNome") != null){
				if(request.getAttribute("erroNome").equals("false")){
			 %>
				<div class="form-group has-error">
		  			<label class="control-label" for="inputError1">Erro no campo nome</label>
		  			<input type="text" class="form-control" placeholder="Nome Completo" name="nome" value="${usuario.nome}">
		  		</div>
		  	<%}else{ %>
		  		<div class="form-group has-success">
		  			<label class="control-label" for="inputError1">Campo nome correto</label>
					<input type="text" class="form-control" placeholder="Nome Completo" name="nome" value="${usuario.nome}">
				</div>
			<%}}else{ %>
				<div class="form-group"> 
					<input type="text" class="form-control" placeholder="Nome Completo" name="nome" value="${usuario.nome}">
				</div>
				<%} %>
		  	
		  	<%
			if(request.getAttribute("erroCpf") != null){
				if(request.getAttribute("erroCpf").equals("false")){
			 %>
			 <div class="form-group has-error">
		  			<label class="control-label" for="inputError1">Erro no cpf</label>
				<input type="text" class="form-control" placeholder="Cpf" name="cpf" value="${usuario.cpf}">
				</div>
			<%}else{ %>
				<div class="form-group has-success">
		  			<label class="control-label" for="inputError1">Campo cpf correto</label>
					<input type="text" class="form-control" placeholder="Cpf" name="cpf" value="${usuario.cpf}">
				</div>
			<%}}else{ %>
				<div class="form-group"> 
					<input type="text" class="form-control" placeholder="Cpf" name="cpf" value="${usuario.cpf}">
				</div>
				<%} %>
			
			<%
			if(request.getAttribute("erroEmail") != null){
				if(request.getAttribute("erroEmail").equals("false")){
			 %>
				<div class="form-group has-error">
		  			<label class="control-label" for="inputError1">Erro no campo email</label>
					<input type="text" class="form-control" placeholder="Email" name="email" value="${usuario.email}">
				</div>
			<%}else{ %>
				<div class="form-group has-success">
		  			<label class="control-label" for="inputError1">Campo email correto</label>
					<input type="text" class="form-control" placeholder="Email" name="email" value="${usuario.email}">
				</div>
			<%}}else{ %>
				<div class="form-group"> 
					<input type="text" class="form-control" placeholder="Email" name="email" value="${usuario.email}">
				</div>
			<%} %>
			
			<%
			if(request.getAttribute("erroProfissao") != null){
				if(request.getAttribute("erroProfissao").equals("false")){
			 %>
				<div class="form-group has-error">
		  			<label class="control-label" for="inputError1">Erro no campo profissao</label>
					<input type="text" class="form-control" placeholder="Profissao" name="profissao" value="${usuario.profissao}">
				</div>
			<%}else{ %>
			<div class="form-group has-success">
		  			<label class="control-label" for="inputError1">Campo profissao correto</label>
					<input type="text" class="form-control" placeholder="Profissao" name="profissao" value="${usuario.profissao}">
				</div>
			<%}}else{ %>
				<div class="form-group"> 
					<input type="text" class="form-control" placeholder="Profissao" name="profissao" value="${usuario.profissao}">
				</div>
			<%} %>
			
			<%
			if(request.getAttribute("erroData") != null){
				if(request.getAttribute("erroData").equals("false")){
			 %>
				<div class="form-group has-error">
		  			<label class="control-label" for="inputError1">Erro no campo data de nascimento</label>
					<input type="text" class="form-control" placeholder="(DD/MM/AAAA)" name="dataNascimento" value="${usuario.dataNascimento}">
				</div>
			<%}else{ %>
			<div class="form-group has-success">
		  			<label class="control-label" for="inputError1">Campo data de nascimento correto</label>
					<input type="text" class="form-control" placeholder="(DD/MM/AAAA)" name="dataNascimento" value="${usuario.dataNascimento}">
				</div>
			<%}}else{ %>
				<div class="form-group"> 
					<input type="text" class="form-control" placeholder="(DD/MM/AAAA)" name="dataNascimento" value="${usuario.dataNascimento}">
				</div>
			<%} %>
			
			<%
			if(request.getAttribute("erroSenha") != null){
				if(request.getAttribute("erroSenha").equals("false")){
			 %>
				<div class="form-group has-error">
			  			<label class="control-label" for="inputError1">Erro no campo senha</label>
					<input type="password" class="form-control" placeholder="Senha"	name="senha" value="${usuario.senha}">
				</div>
			<%}else{ %>
			<div class="form-group has-success">
		  			<label class="control-label" for="inputError1">Campo senha correto</label>
					<input type="password" class="form-control" placeholder="Senha" name="senha" value="${usuario.senha}">
				</div>
			<%}}else{ %>
				<div class="form-group"> 
					<input type="password" class="form-control" placeholder="Senha" name="senha" value="${usuario.senha}">
				</div>
			<%} %>
			
			<div class="form-group">
				<input type="password" class="form-control"
					placeholder="Confirmacao da senha" name="confirmacaoSenha" value="${usuario.senha}">
			</div>
			
			<label class="radio-inline">
			  	<input type="radio" name="sexo" id="inlineRadio1" value="masculino"> Masculino
			</label>
			
			<label class="radio-inline">
			  <input type="radio" name="sexo" id="inlineRadio2" value="feminino"> Feminino
			</label>
			</br> </br>
			<%
			if(request.getAttribute("erroGenero") != null){
				if(request.getAttribute("erroGenero").equals("false")){
			 %>
				<div class="alert alert-danger" role="alert">Erro no campo genero</div>
			<%}else{ %>
				<div class="alert alert-success" role="alert">Campo genero correto</div>
			<%}} %>
			
			<% if(request.getAttribute("cpfExiste") != null){
				if(request.getAttribute("cpfExiste").equals("true")){ %>
					<script language="JavaScript" type="text/javascript">
						alert ("Erro! Cpf ja cadastrado!")
					</script>
			<%}}%>
			 
		 </c:forEach>
		<button type="submit" class="btn btn-success">Cadastrar</button>
		
		
	</form>
	
</h:body>
</html>
