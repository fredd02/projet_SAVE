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
<div class="col-md-6 col-md-offset-3 text-center"><h2><b><s:message code="victimInfos"/></b></h2></div>



<ul class="well list-group col-md-6 col-md-offset-3">
  <li class="list-group-item"><b><s:message code="Firstname"/>: </b><c:out value="${victim.firstname}" /></li>
  <li class="list-group-item"><b><s:message code="Lastname"/>: </b><c:out value="${victim.lastname}" /></li>
  <li class="list-group-item"><b><s:message code="Birthdate"/>: </b><fmt:formatDate pattern="dd/MM/yyyy" value="${victim.birthdate}"/></li>
  <li class="list-group-item"><b><s:message code="AccidentDate"/>: </b><fmt:formatDate pattern="dd/MM/yyyy" value="${victim.accidentdate}"/></li>
  <li class="list-group-item"><b><s:message code="sex"/>: </b><c:out value="${victim.sex == 0 ? 'masculin' : 'feminin'}" /></li>
  <li class="list-group-item"><b><s:message code="language"/>: </b><c:out value="${victim.language}" /></li>
  <li class="list-group-item text-center"> <div class="btn-group">
   <c:choose>
   	   <c:when test="${empty victim.responsibles}">
 		<button type="button" class="btn btn-primary" onclick="location.href='../responsible/${victim.id}/add'"><s:message code="addResponsible"/></button>
 	   </c:when>
 	   <c:otherwise>
 	   		<button type="button" class="btn btn-info" onclick="location.href='../responsible/list/${victim.id}'"><s:message code="seeResponsibles"/></button>
 	   </c:otherwise>
 	</c:choose>
   <c:choose>
   	   <c:when test="${empty victim.location}">
 		<button type="button" class="btn btn-primary" onclick="location.href='../location/${victim.id}/add'"><s:message code="addLocation"/></button>
 	   </c:when>
 	   <c:otherwise>
 	   		<button type="button" class="btn btn-info" onclick="location.href='../location/${victim.location.id}'"><s:message code="seeLocation"/></button>
 	   </c:otherwise>
 	</c:choose>
  
</div> 
</li>
</ul>



</div>

<jsp:include page="../fragments/footer.jsp" />
</html>