<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/icon/iconaEco.png" />
<head>
	<title>Gestione utenti</title>
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/main.css" type="text/css">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
	<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/frameworks/jquery-3.6.0.min.js"></script>
	<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body background="${pageContext.request.contextPath}/resources/images/icon/sfondologo.png">
	<div id="wrapper">
		<div id="header">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
	</div>
	
	<h4>Inserisci Nuovo Utente</h4>
	
		<div id="container2">
		<div class="row" style="padding: 15px;">
		
			<form:form action="saveUser" modelAttribute="user" method="POST">
				<form:hidden path="idUtente" />	
				<div class="row">
					<div class="col">
						<div class="form-group">
						<label>Nome:</label>
						<br>
						<form:input path="nome" />
						</div>
					</div>
						
					<div class="col">	
					<div class="form-group">
						<label>Telefono:</label>
						<br>
						<form:input path="telefono" />
					</div>
					</div>
					
					<div class="col">
						<div class="form-group">
						<label>Indirizzo:</label>
						<br>
						<form:input path="indirizzo" />
						</div>
					</div>
						
					<div class="col">	
					<div class="form-group">
						<label>Cognome:</label>
						<br>
						<form:input path="cognome" />
					</div>
					</div>
					
					<div class="col">
						<div class="form-group">
						<label>Ragione Sociale:</label>
						<br>
						<form:input path="ragioneSociale" />
						</div>
					</div>
				</div>
				
				<div class="row">
					
					<div class="col">	
					<div class="form-group">
						<label>Codice fiscale:</label>
						<br>
						<form:input path="codFiscPIva" />
					</div>
					</div>
					
					<div class="col">	
					<div class="form-group">
						<label>Email:</label>
						<br>
						<form:input path="email" />
					</div>
					</div>
					
					<div class="col">	
					<div class="form-group">
						<label>Pec:</label>
						<br>
						<form:input path="pec" />
					</div>
					</div>
					
					<div class="col">	
					<div class="form-group">
						<label>Password:</label>
						<br>
						<form:input path="password" />
					</div>
					</div>
					
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
				
				</form:form>
				</div>
				
				</div>
				
				<div class="buttonSave">
				<input type="submit" value="Salva" class="btnSave" />
				</div>
				
	<div id="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>

</html>
