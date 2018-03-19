<!DOCTYPE html>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<jsp:include page="fragments/header.jsp">
	<jsp:param name="titre" value="Home page Projet SAVE" />
</jsp:include>

<div class="container">
<div class="jumbotron">
<h1>PEVR</h1>
<p>Interface de gestion pour l'association PEVR</p>
</div>




</div>

<jsp:include page="fragments/footer.jsp" />
</html>