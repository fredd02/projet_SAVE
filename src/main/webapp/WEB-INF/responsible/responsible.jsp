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
<div class="col-md-8 col-md-offset-2 text-center"><h2><b><s:message code="responsible.infos"/></b></h2></div>

<ul class="well list-group col-md-6 col-md-offset-3">
  <li class="list-group-item"><b><s:message code="Firstname" />: </b><c:out value="${responsible.firstname}" /></li>
  <li class="list-group-item"><b><s:message code="Lastname" />: </b><c:out value="${responsible.lastname}" /></li>
  <li class="list-group-item"><b><s:message code="postCode" />: </b><c:out value="${responsible.postCode}" /></li>
  <li class="list-group-item"><b><s:message code="city" />: </b><c:out value="${responsible.city}" /></li>
  <li class="list-group-item"><b><s:message code="street" />: </b><c:out value="${responsible.street}" /></li>
  <li class="list-group-item"><b><s:message code="number" />: </b><c:out value="${responsible.number}" /></li>
  <li class="list-group-item"><b><s:message code="mail" />: </b><c:out value="${responsible.email}" /></li>
  <li class="list-group-item"><b><s:message code="phone" />: </b><c:out value="${responsible.phone}" /></li>
  <li class="list-group-item"><b><s:message code="victimConnection" />: </b><c:out value="${responsible.connection}" /></li>
  <li class="list-group-item text-center">
  	<button type="button" class="btn btn-primary" onclick="location.href='../responsible/${responsible.id}/update'"><s:message code="updateResponsible"/></button>
  </li>
 
</ul>

</div>

<jsp:include page="../fragments/footer.jsp" />
</html>