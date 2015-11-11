<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Administrador</title>
<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script
			src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
</head>
<body>
	<h2>Usuarios</h2>
	
	<table>
		<tr>
			<th>Nome </th>
			<th>Cpf </th>
			<th>Profissao </th>
			<th>Email </th>
			<th>Sexo </th>
			<th>Nivel de Acesso</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${arrayUsuario}" var="usuario">
			<tr>
				<td>${usuario.nome}</td>
				<td>${usuario.cpf}</td>
				<td>${usuario.profissao}</td>
				<td>${usuario.email}</td>
				<td>${usuario.sexo}</td>
				<td>${usuario.nivelDeAcesso}</td>
				<td> <a href="/save.html?id=${usuario.cpf}">Salvar</a> </td>
				<td> <a href="/delete.html?id=${usuario.cpf}">Deletar</a> </td>
			</tr>
		</c:forEach>
	</table>
	
	<br/>
</body>
</html>