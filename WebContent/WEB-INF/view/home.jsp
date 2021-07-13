<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<title>Home</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/icon/iconaEco.png" />
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
		   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>

<body background="${pageContext.request.contextPath}/resources/images/icon/sfondologo.png">
	
	<div id="wrapper">
		<div id="header">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
	</div>
	<div class="background">
  	<div class="transbox">
    		<p>Benvenuti nel Nuovo Portale Dedicato al</p>
    		<p>Progetto Ecobonus 110%</p>
			<br>
    		<a href="${pageContext.request.contextPath}/user/login">Effettua la Login</a>
  	</div>
  		
</div>
	<div id="footer">
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>