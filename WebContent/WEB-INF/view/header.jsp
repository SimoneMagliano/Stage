<%-- <%@ page import="net.ecobonus.dto.UserDto"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
// 	UserDto userDto = (UserDto)request.getSession().getAttribute("userDto");
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<img class="logo" alt="icona_logo" src="${pageContext.request.contextPath}/resources/images/icon/logo.png" width="14%">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav ml-auto">
      <a class="navlink" href="${pageContext.request.contextPath}/user/home">Home</a>
      <a class="navlink" href="${pageContext.request.contextPath}/user/login">Login</a>
      <a class="navlink" href="${pageContext.request.contextPath}/user/showFormAddUser">Gestione Utenti</a>
      <a class="navlink" href="${pageContext.request.contextPath}/user/list">Lista Utenti</a>
      <a class="navlink" href="${pageContext.request.contextPath}/interventi/showFormAddIntervento">Nuovo Intervento</a>
      <a class="navlink" href="${pageContext.request.contextPath}/interventi/list">Lista Interventi</a>
    </div>
  </div>

</nav>