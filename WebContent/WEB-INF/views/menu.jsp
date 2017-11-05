<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Algoritmos Grafos</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

</head>
<body>
	<div class="topo container">
		<div class="col-md-8 col-md-offset-2">
			<br />
			<h1 class="title">Grafos > Algoritmos</h1>
			<br />
		</div>
	</div>
	
	<br />
	
	<div class="container">
		<div class="col-md-8 col-md-offset-2" align="center">
			<form class="form-inline" action="criaMatriz">
				<div class="form-group">
    				<label for="size">Tamanho da Matriz</label>
    				<input type="text" class="dimensao form-control" id="size" name="size" 
    					placeholder="Ex: Digite 4 para gerar uma matriz 4x4">
  				</div>
  				<button type="submit" class="btn btn-menu">Gerar</button>
  			</form>
		</div>	
	</div>


	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>