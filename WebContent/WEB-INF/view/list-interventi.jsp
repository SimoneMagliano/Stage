<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%=session.getAttribute("session.prop")%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Utenti</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/icon/iconaEco.png" />
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body background="${pageContext.request.contextPath}/resources/images/icon/sfondologo.png">

	<div id="wrapper">
		<div class="row" id="header">
			<jsp:include page="header.jsp"></jsp:include>
</div>
	</div>
		<div id="container" class="table">	
			<div id="content">
				<hr>      
            		<div class="BoxInterventiLista">
            	 		<div class="row barraBlu">                      
                			<div class="col-1">Id Intervento</div>
                			<div class="col-1">Cliente</div>
                			<div class="col-1">Cod. Sede</div>
                			<div class="col-1">Cod. Tipo Intervento</div>
                			<div class="col-1">Descrizione</div>
							<div class="col-1">Referente</div>
							<div class="col-1">Contatto</div>
							<div class="col-1">Inizio Lavori</div>
							<div class="col-1">Primo SAL</div>
							<div class="col-1">Secondo SAL</div>
							<div class="col-1">Fine Lavori</div>
							<div class="col-1">Regione</div>
							<div class="col-1">Modifica</div>
						</div>
		
				<c:forEach var="tempInterventi" items="${interventi}">
					<c:url var="updateLink" value="/interventi/showFormUpdateIntervento">
						<c:param name="idIntervento" value="${tempInterventi.idIntervento}" />
					</c:url>					
					<c:url var="deleteLink" value="/interventi/delete">
						<c:param name="idIntervento" value="${tempInterventi.idIntervento}" />
					</c:url>		
					
					      <div class="row tabella">                                           
                     		<div class="col-1">
                    			<c:out value="${tempInterventi.idIntervento}"></c:out>
                    		</div>
                     		<div class="col-1">
                    			<c:out value="${tempInterventi.cliente}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.sede.descrizione}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.tipoIntervento.descrizione}"></c:out>
                   			</div>      
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.descrizione}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.referente}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.contatto}"></c:out>
                    		</div>  
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.inizioLavoro.descrizione}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.primoSal.descrizione}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.secondoSal.descrizione}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.fineLavoro.descrizione}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempInterventi.regione.nomeRegione}"></c:out>
                    		</div>  
                     		<div class="col-1">
                    			<a href="${updateLink}">Aggiorna</a>
                        		<a href="${deleteLink}"
                               		onclick="if (!(confirm('Sei sicuro di voler eliminare questo intervento?'))) return false">Cancella</a>
                    		</div>       
                    	</div>
                </c:forEach>
			</div>	     
         </div>		
			<input type="button" value="Aggiungi Intervento"
                   onclick="window.location.href='showFormAddIntervento'; return false;"
                   class="btn btn-success"/>
	</div>
		<div id="footer">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>