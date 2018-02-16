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
<div class="text-center"><h2><b><s:message code="locationInfos"/></b></h2></div>

<ul class="well list-group col-md-4 col-md-offset-4">
  <li class="list-group-item"><b>Code Postal: </b><c:out value="${location.postCode}" /></li>
  <li class="list-group-item"><b>Ville: </b><c:out value="${location.city}" /></li>
  <li class="list-group-item"><b>Rue: </b><c:out value="${location.street}" /></li>
  <li class="list-group-item"><b>Numero: </b><c:out value="${location.number}" /></li>
  <li class="list-group-item"><b>Latitude: </b><c:out value="${location.latitude}" /></li>
  <li class="list-group-item"><b>Longitude: </b><c:out value="${location.longitude}" /></li>
  <li class="list-group-item text-center"><s:url value="/location/${location.id}/update" var="updateUrl" />
			<button class="btn btn-info" 
				onclick="location.href='${updateUrl}'"><s:message code="update" /></button>
				
		<s:url value="/location/${location.id}/delete" var="deleteUrl" />
		<button class="btn btn-danger" 
				onclick="
					if(confirm('Suppression de la localisation ?')){
						this.disabled=true;
						post('${deleteUrl}',{'${_csrf.parameterName}': '${_csrf.token}'})}                             
                                              "><s:message code="delete" /></button></li>
  
 
</ul>

	
</div>

<jsp:include page="../fragments/footer.jsp" />
</html>