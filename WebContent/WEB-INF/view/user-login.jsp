<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title>Login</title>
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
	
	<div id="container" >
		<div class="row" style="padding-left: 24%;padding-right: 15%;padding-top: 20px;padding-bottom: 20px;">

			<div class="col-md-6 login" style="margin-top: 0px;height: 100%;">
				<div id="first">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h2 style="color: #0c4a7a; font-weight: bold;">LOGIN</h2>
								<hr>
							</div>
						</div>

			
		<form:form action="saveUser" modelAttribute="user" method="POST">	
		
			<form:hidden path="idUtente" />
			 action="<c:url value='/j_spring_security_check' />" method='POST'>
  				<div class="form-group">
    				<label for="exampleInputEmail1">Email</label>
    				<form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Inserisci Email"/>
			  </div>
  				<div class="form-group">
    			<label for="exampleInputPassword1">Password</label>
    			<form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Inserisci Password"/>
  			</div>
  			<div class="form-group form-check">
				<label class="checkbox" style="color: #0c4a7a; font-weight: 600;">
	    			<input type="checkbox" class="form-check-input" value="remember-me" id="remember_me"> Remember me
				</label>
			</div>
  				<button type="submit" class="buttonLogin">Login</button>
			
			<br>
							<div class="text-center">
								<a href="forgot-pwd.jsp" class="forgot-password">Password
									Dimenticata?</a>
							</div>				
		</form:form>
		</div>
				</div>
			</div>
					
			<div class="col-md-6 login2" style="margin-top: 0px;height: 100%;">
				<div id="second">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h2 style="color: white; font-weight: bold;">SIGNUP</h2>
								<hr>
							</div>
						</div>
			
				<form:form action="saveUser" modelAttribute="user" method="POST">
					<form:hidden path="idUtente" />
				
						<div class="row">
							<div class="col">
								<div class="form-group">
							<label>Tipo Utente:</label>
							<br>
							<select id="idTipoUtente" name="idTipoUtente">
								<c:forEach var="tipoUtente" items="${tipiUtente}">
									<option value="${tipoUtente.idTipoUtente}"
										<c:if test="${tipoUtente.idTipoUtente eq user.tipoUtente.idTipoUtente}"> selected</c:if>
										>${tipoUtente.descrizione}</option>
								</c:forEach>
							</select>
								</div>
							</div>
							
							<div class="col">
								<div class="form-group">
							<label>Regione:</label>
							<br>
							<select id="idRegione" name="idRegione">
								<c:forEach var="regione" items="${regioni}">
									<option value="${regione.idRegione}"
										<c:if test="${regione.idRegione eq user.regione.idRegione}"> selected</c:if>
										>${regione.nomeRegione}</option>
								</c:forEach>
							</select>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col">
							<div class="form-group">
								<label>Nome:</label>
								<br>
								<form:input path="nome" class="input"/>
							</div>
							</div>
							
							<div class="col">
							<div class="form-group">
								<label>Cognome:</label>
								<br>
								<form:input path="cognome" class="input"/>
							</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col">
							<div class="form-group">
							<label>Password:</label>
							<br>
							<form:input path="password" class="input"/>
							
						</div>
						</div>
						
						<div class="col">
							<div class="form-group">
						<label>Email:</label>
						<br>
						<form:input path="email" class="input"/>
						</div>
						</div>
						</div>
						
						<label>Ragione Sociale:</label>
						<br>
						<form:input path="ragioneSociale" class="input"/>
						
						<div class="col-md-12 text-center mb-3" style="margin-top: 40px;">
							<input type="submit" value="Registrati" class="save" />
						</div>
				</form:form>
				</div>
				</div>
			</div>
		</div>
		</div>

</body>
</html>