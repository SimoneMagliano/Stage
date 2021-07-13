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

	<div class="row" id="header">
		<jsp:include page="header.jsp">
		</jsp:include>
	</div>

	<div class="container">
		<div class="row" style="padding: 15px;">

			<div class="col-md-6 login">
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
							
							<div class="form-group">
								<label style="color: #0c4a7a;font-weight: 600;">Email</label>
								<input type="hidden" id="function" name="function" value="login" />
								<input type="text" name="email" class="form-control"
									id="email" aria-describedby="emailHelp"
									placeholder="Inserisci Email">
							</div>
							<div class="form-group">
								<label style="color: #0c4a7a;font-weight: 600;">Password</label>	
								<input type="password" name="password" id="password"
									class="form-control" aria-describedby="emailHelp"
									placeholder="Inserisci Password">
									<span id="password" onclick="showPwd()" class="fa fa-fw fa-low-vision field-icon toggle-password" style="margin-right: 5px;"></span>Mostra Password
							</div>
							<div class="form-group form-check">
								<label class="checkbox" style="color: #0c4a7a; font-weight: 600;">
	    							<input type="checkbox" class="form-check-input" value="remember-me" id="remember_me"> Remember me
								</label>
							</div>
							<div class="col-md-12 text-center ">
								<button type="submit"
									class=" btn btn-block mybtn btn-primary tx-tfm"
									style="font-weight: 600; background: #09b023; border: none;">Login</button>
							</div>
							<br>
							<div class="text-center">
								<a href="forgot-pwd.jsp" class="forgot-password">Password
									Dimenticata?</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>


			<div class="col-md-6 login2">
				<div id="second">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h2 style="color: white; font-weight: bold;">SIGNUP</h2>
								<hr>
							</div>
						</div>
						<form action="user" method="post" id="register" name="register">
							<input type="hidden" id="function" name="function" value="register">

							<div class="row">
								<div class="col">
									<div class="form-group">
										<label for="Titolo" style="color: white;">Titolo</label> <input
											type="text" id="titoloReg" name="titoloReg" class="form-control"
											aria-describedby="emailHelp" placeholder="Inserisci Titolo" required="required">
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label for="userTypeReg" style="color: white;">Tipo
											Utente</label> 
											
											<select name="userTypeReg" id="userTypeReg"
											style="text-transform: none; border: 1px solid #0c4a7a; border-radius: 30px; padding: 2px;">
											<option value="99">- - Seleziona - -</option>
											<option value="1">Admin</option>
											<option value="2">Brainlab</option>
											<option value="3">Impresa</option>
											<option value="4">Professionista</option>
											<option value="5">Amministratore Condominio</option>
									</select>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col">
									<div class="form-group">
										<label for="Nome" style="color: white;">Nome</label> <input
											type="text" id="nomeReg" name="nomeReg" class="form-control"
											aria-describedby="emailHelp" placeholder="Inserisci Nome" required="required">
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label for="Cognome" style="color: white;">Cognome</label> <input
											type="text" id="cognomeReg" name="cognomeReg"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Inserisci Cognome" required="required">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col">
									<label for="emailReg" style="color: white;">Indirizzo Email</label> 
										<input type="email" id="emailReg" name="emailReg"
										class="form-control" aria-describedby="emailHelp"
										placeholder="Inserisci Email" required="required">
								</div>
							</div>
							<div class="row">
								<div class="col">
									<div class="form-group">
										<label for="passwordReg" style="color: white;">Password</label>
										<input type="password" id="passwordReg" name="passwordReg"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Inserisci Password" required="required">
									</div>
								</div>
							</div>

							<div class="col-md-12 text-center mb-3" style="margin-top: 40px;">
								<button type="submit"
									class=" btn btn-block mybtn btn-primary tx-tfm"
									style="font-weight: 600; background: #09b023; border: none;">Registrati</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
</body>
</html>