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
<h1>Liste des responsables  de <c:out value="${victim.firstname} ${victim.lastname}" /></h1>

<table class="table table-stripped">
	<thead>
	<tr>
		<th>Firstname</th>
		<th>Lastname</th>
		<th>Email</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${listResponsibles}" var="responsible">
			<tr>
				<td><c:out value="${responsible.firstname}" /></td>
				<td><c:out value="${responsible.lastname}" /></td>
				<td><c:out value="${responsible.email}" /></td>
			
			</tr>
		</c:forEach>
	
	</tbody>
	
</table>

</div>

<jsp:include page="../fragments/footer.jsp" />
</html>