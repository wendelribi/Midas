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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</h:head>

<h:body>
	<nav class="navbar navbar-primary">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">MIDAS</a>
    </div>

      </ul>
      <form class="navbar-form navbar-left" >
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Pesquisar">
        </div>
        <button type="submit" class="btn btn-primary btn">
        <span class ="glyphicon glyphicon-search" aria-hidden="true"></span>
        </button>
        
   
      </form>
      
      <ul class="nav navbar-nav navbar-right">
		 	<div class="btn-group">
	 			<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Opcoes <span class="caret"></span>
	 			</button>
		  		<ul class="dropdown-menu">
		    		<li><a href="#">
		    			  <button type="submit" class="btn btn-default ">
		        			<span class ="glyphicon glyphicon-cog" aria-hidden="true"></span> Configuracoes
		       			 </button>
		    		</a></li>
		    		<li role="separator" class="divider"></li>
		    		<li><a href="./controller.html">
		    			 <button type="submit" class="btn btn-default ">
		        			<span class ="glyphicon glyphicon-off" aria-hidden="true"></span> Sair da Conta
		       			 </button>	
		    		 </a></li>
		  		</ul>
			</div>
		</ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
		<img src="C:\Users\Victor\Pictures\Exemplo.jpg" width = "800" height = "600"/>

</h:body>
</html>
