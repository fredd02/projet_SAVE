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
<h1>Infos sur la localisation</h1>

<ul class="list-group">
  <li class="list-group-item"><b>Code Postal: </b><c:out value="${location.postCode}" /></li>
  <li class="list-group-item"><b>Ville: </b><c:out value="${location.city}" /></li>
  <li class="list-group-item"><b>Rue: </b><c:out value="${location.street}" /></li>
  <li class="list-group-item"><b>Numero: </b><c:out value="${location.number}" /></li>
  <li class="list-group-item"><b>Latitude: </b><c:out value="${location.latitude}" /></li>
  <li class="list-group-item"><b>Longitude: </b><c:out value="${location.longitude}" /></li>
 
</ul>




</div>

<jsp:include page="../fragments/footer.jsp" />
</html>