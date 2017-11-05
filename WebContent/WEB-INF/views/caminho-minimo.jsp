<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Criação da Matriz</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<br />
	
	<c:if test="${not empty m}">
		<div class="container">
			<div class="col-md-8 col-md-offset-2">
					
					<c:if test="${not empty success}">
						<div class="alert alert-success fade in">
    							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    							<strong>${success}</strong>
  						</div>
  					</c:if>
  							  					
					<form class="form-inline">
						<input type="hidden" name="size" value="${size}">
						<c:forEach var="i" items="${m}" varStatus="row">
							<label>${row.count}</label>
							<c:forEach var="j" items="${m}" varStatus="col" >
								<label class="indice">${col.count}</label>
								<input type="text" class="campo form-control" name="dados" id="dados"
									style="color: blue;" value="${m[row.index][col.index]}" readonly="readonly">
							</c:forEach>
							<br />
						</c:forEach>
					
						<br/>
						
						<c:if test="${empty teste}">
							<label for="sel1">Do vértice</label>
  							<select class="form-control" name="x" id="x">
  								<c:forEach var="i" items="${m}" varStatus="row">
    								<option>${row.count}</option>
    							</c:forEach>
  							</select>
  						
  							<label for="sel1">até o vértice</label>
  							<select class="form-control" name="y" id="y">
  								<c:forEach var="i" items="${m}" varStatus="row">
    								<option>${row.count}</option>
    							</c:forEach>
  							</select>
  						
  							<button type="submit" class="btn my-btn" onclick="form.action='minimo'">Executar!</button>
  						</c:if>
  						<c:if test="${not empty teste}">
  							<button type="submit" class="btn my-btn" onclick="form.action='salvar'">Gerar a mesma matriz?</button>
  						</c:if>
  					</form>
			</div>
		</div>
	</c:if>

	
</body>
</html>