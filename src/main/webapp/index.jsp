<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
<h:head>
	<title>Midas</title>
	<link  rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script
			src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	<script type="text/javascript" src="bootstrap\js\bootstrap.js"></script>
	<script type="text/javascript" src="bootstrap\js\funcoes.js"></script>
	<script type="text/javascript" src="bootstrap\js\jquery.js"></script>
	<!DOCTYPE html>
</html>
</h:head>
<h:body>
	<center>
		<h2>MIDAS</h2>
		</br>
		<h4>
		<li><a href="./login/controller.html" >
					<button type="button" class="btn btn-primary btn-lg">
						<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> LOGIN
						</button>
						</a></li>
						</br>
						<li><a href="./cadastro/controller.html" >
						<button type="button" class="btn btn-primary btn-lg">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span> REQUISITAR CADASTRO  
					</button>
				</a></li>
		  		</ul>
			</div>
		
		<% String nome = request.getParameter("cadastroSucesso"); 
		if(nome != null){	
			if(nome.equals("true")){
		%>
		<script language="JavaScript" type="text/javascript">
			alert ("Cadastro enviado com sucesso! Confirmacao pendente!")
		</script>
		</h4>
		<%}} %>
	</center>
	
	
</h:body>
</html>