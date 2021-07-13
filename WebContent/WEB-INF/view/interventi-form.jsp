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
		<div id="container2" class="row">
			<form:form action="saveIntervento" modelAttribute="intervento" method="POST">
				<form:hidden path="idIntervento"/>			
					<div class="column">
						
						<div><label>Cliente:</label><br>
						<form:input path="cliente" /></div>
						<select id="codSede" name="codSede">
								<c:forEach var="sede" items="${sedi}">
									<option value="${sede.codSede}"
										<c:if test="${sede.codSede eq intervento.sede.codSede}"> selected</c:if>
										>${sede.descrizione}</option>
								</c:forEach>
							</select>
						<select id="codiceTipoIntervento" name="codiceTipoIntervento">
								<c:forEach var="tipoIntervento" items="${tipiIntervento}">
									<option value="${tipoIntervento.codiceTipoIntervento}"
										<c:if test="${tipoIntervento.codiceTipoIntervento eq intervento.tipoIntervento.codiceTipoIntervento}"> selected</c:if>
										>${tipoIntervento.descrizione}</option>
								</c:forEach>
							</select>
						<div><label>Descrizione:</label><br>
						<form:input path="descrizione" /></div>
						
					</div>
					<div class="column">
					<div><label>Referente:</label><br>
						<form:input path="referente" /></div>
						<div><label>Contatto:</label><br>
						<form:input path="contatto" /></div>
						<div><label>Regione:</label><br>
							<select id="idRegione" name="idRegione">
								<c:forEach var="regione" items="${regioni}">
									<option value="${regione.idRegione}"
										<c:if test="${regione.idRegione eq intervento.regione.idRegione}"> selected</c:if>
										>${regione.nomeRegione}</option>
								</c:forEach>
							</select>
						</div>			
						<div><input type="submit" value="Salva" class="btn" /></div>
						<div style="clear; both;"></div>			
					</div>
				</form:form>
			</div>
		<div id="footer">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>
