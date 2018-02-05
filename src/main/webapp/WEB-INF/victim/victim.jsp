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
<h1>Infos sur la victime</h1>


<ul class="list-group">
  <li class="list-group-item"><b>Nom: </b><c:out value="${victim.firstname}" /></li>
  <li class="list-group-item"><b>Prenom: </b><c:out value="${victim.lastname}" /></li>
  <li class="list-group-item"><b>Date de naissance: </b><fmt:formatDate pattern="dd/MM/yyyy" value="${victim.birthdate}"/></li>
  <li class="list-group-item"><b>Date de l'accident: </b><fmt:formatDate pattern="dd/MM/yyyy" value="${victim.accidentdate}"/></li>
  <li class="list-group-item"><b>sexe: </b><c:out value="${victim.sex == 0 ? 'masculin' : 'feminin'}" /></li>
</ul>

</div>

<jsp:include page="../fragments/footer.jsp" />
</html>