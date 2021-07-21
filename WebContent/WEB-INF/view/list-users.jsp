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
  			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
</head>
<body background="${pageContext.request.contextPath}/resources/images/icon/sfondologo.png">

	<div id="wrapper">
		<div class="row" id="header">
			<jsp:include page="header.jsp"></jsp:include>
		</div>
	</div>
	
		
		<input type="button" value="Aggiungi Utente"
                   onclick="window.location.href='showFormAddUser'; return false;"
                   class="btn btn-success" style="margin: 0px;margin-top: 20px;margin-left: 20px;"/>
		<br>
		
		<div class="BoxInterventiLista">

		<div class="row barraBlu">
				
				<div class="col-1">Nome/Cognome</div>
				
				<div class="col-2">Ragione Sociale</div>
				
	            <div class="col-2">Codice Fiscale/Indirizzo</div>

				<div class="col-2">Telefono/Email</div>
				
				<div class="col-2">Pec</div>
				
				<div class="col-1">Password</div>
				
				<div class="col-1">TipoUtente/Regione</div>
					
				<div class="col-1">Edit/Delete</div>

			</div> 
		
				<c:forEach var="tempUser" items="${users}">
				
					<c:url var="updateLink" value="/user/showFormUpdateUser">
						<c:param name="idUtente" value="${tempUser.idUtente}" />
					</c:url>
										
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="idUtente" value="${tempUser.idUtente}" />
					</c:url>		
					
					      <div class="row tabella"> 
					                                                
                     		<div class="col-1">
                    			<c:out value="${tempUser.nome}"></c:out>
                    			<hr>
                    			<c:out value="${tempUser.cognome}"></c:out>
                    		</div>
                     		
                    		<div class="col-2">
                    			<c:out value="${tempUser.ragioneSociale}"></c:out>
                    		</div>
                    		<div class="col-2">
                    			<c:out value="${tempUser.codFiscPIva}"></c:out>
                    			<hr>
                    			<c:out value="${tempUser.indirizzo}"></c:out>
                   			</div>      
                    		
                    		<div class="col-2">
                    			<c:out value="${tempUser.telefono}"></c:out>
                    			<hr>
                    			<c:out value="${tempUser.email}"></c:out>
                    		</div>
                    	  
                    		<div class="col-2">
                    			<c:out value="${tempUser.pec}"></c:out>
                    		</div>
                    		<div class="col-1">
                    			<c:out value="${tempUser.password}"></c:out>
                    		</div>
                    		
                    		<div class="col-1">
                    			<c:out value="${tempUser.tipoUtente.descrizione}"></c:out>
                    			<hr>
                    			<c:out value="${tempUser.regione.nomeRegione}"></c:out>
                    			
                    		</div>
                    		
                     		<div class="col-1">
                    			<a href="${updateLink}">
                    			<span class="fa fa-pencil"
								style='margin-right:15px;font-size: 24px; color: #0c4a7a'></span>
								</a>
								
                        		<a href="${deleteLink}"
                               		onclick="if (!(confirm('Sei sicuro di voler eliminare questo utente?'))) return false">
                               		<span class="fa fa-close" style='font-size: 24px; color: red'></span>
                               		</a>
                    		
                    		<!-- Modal -->
							<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content modaleEdit">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Eliminazione Utente</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							        Sei <b>Sicuro</b> di voler <b>Eliminare</b> questo Utente?
							      </div>
							      <div class="modal-footer">
							        <a href="<%=request.getContextPath()%>/user?function=deleteUser&idUtente=${user.idUtente}">
										<button type="button" class="btnUserListYes">SI</button>
									</a>
									 <button type="button" class="btnUserListAnnulla" data-dismiss="modal">Annulla</button>
							      </div>
							    </div>
							  </div>
							</div>
                    		
                    		</div>       
                    	</div>
                </c:forEach>
			</div>	     
       		
       		<br>
			
		<div id="footer">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>
</html>