<!DOCTYPE html>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<jsp:include page="../fragments/header.jsp">
	<jsp:param name="titre" value="SAVE" />
</jsp:include>
<div class="container">
<h1>Liste des victimes</h1>
<c:if test="${fn:length(victimsList) == 0}">
	<h4>Liste Vide</h4>
</c:if>
<h4>La liste contient: ${fn:length(victimsList)} victimes.</h4>

<table class="table table-striped">
<thead>
	<tr>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>Birth date</th>
		<th>Accident date</th>
		<th>Sex</th>
		<th>Location</th>
		<th></th>
		<th></th>
		</tr>
</thead>
<tbody>
	<c:forEach items="${victimsList}" var="victim">
		<tr>
			<td><c:out value="${victim.firstname}" /></td>
			<td><c:out value="${victim.lastname}" /></td>
			<td><fmt:formatDate value="${victim.birthdate}" pattern="dd-MM-yyyy" /></td>
			<td><fmt:formatDate value="${victim.accidentdate}" pattern="dd-MM-yyyy" /></td>
			<td><c:choose>
				<c:when test="${victim.sex ==0}">M
				</c:when>
				<c:otherwise>F</c:otherwise>
				
			</c:choose></td>
			<td>
				<c:if test="${!empty victim.location}">
					<span class="glyphicon glyphicon-ok"></span>
				</c:if>
			</td>
			
			<td><s:url value="/victim/${victim.id}" var="infoUrl" />
			<button class="btn btn-primary" 
				onclick="location.href='${infoUrl}'">Infos</button>
			</td>
			<td>
			<s:url value="/victim/${victim.id}/delete" var="deleteUrl" />
			<button class="btn btn-danger"
				onclick="
				if (confirm('Suppression de la victime  ?')) {
				 this.disabled=true;
                 post('${deleteUrl}',{'${_csrf.parameterName}': '${_csrf.token}'})}                             
                                              ">Delete</button>
			
			
			
			</td>
		</tr>
	</c:forEach>
</tbody>

</table>

</div>

<jsp:include page="../fragments/footer.jsp" />
</html>