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
	
	<c:if test="${not empty tam}">
		<div class="container">
			<div class="col-md-8 col-md-offset-2">
			
					<form class="form-inline" action="salvar" method="POST">
						<input type="hidden" name="size" value="${size}">
						<c:forEach var="i" items="${tam}" varStatus="row">
							<label>${row.count}</label>
							<c:forEach var="j" items="${tam}" varStatus="col" >
								<label class="indice">${col.count}</label>
								<input type="text" class="campo form-control" name="dados" 
									style="color: blue;" required="required">
							</c:forEach>
							<br />
						</c:forEach>
						<br/>
						<button type="submit" class="btn btn-info">Gerar</button>
					</form>	
			</div>
		</div>
	</c:if>
	
	

	
</body>
</html>