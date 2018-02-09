<!DOCTYPE html>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<html>
<jsp:include page="../fragments/header.jsp">
	<jsp:param name="titre" value="SAVE" />
</jsp:include>
<div class="container">
<h1>Infos sur le responsable</h1>

<ul class="list-group">
  <li class="list-group-item"><b>Nom: </b><c:out value="${responsible.firstname}" /></li>
  <li class="list-group-item"><b>Prenom: </b><c:out value="${responsible.lastname}" /></li>
  <li class="list-group-item"><b>Code Postal: </b><c:out value="${responsible.postCode}" /></li>
  <li class="list-group-item"><b>Ville: </b><c:out value="${responsible.city}" /></li>
  <li class="list-group-item"><b>Rue: </b><c:out value="${responsible.street}" /></li>
  <li class="list-group-item"><b>Numero: </b><c:out value="${responsible.number}" /></li>
  <li class="list-group-item"><b>email: </b><c:out value="${responsible.email}" /></li>
  <li class="list-group-item"><b>telephone: </b><c:out value="${responsible.phone}" /></li>
 
</ul>

</div>

<jsp:include page="../fragments/footer.jsp" />
</html>