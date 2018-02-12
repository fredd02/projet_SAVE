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
<h2>Modifier la localisation de la victime <c:out value="${victim.firstname} ${victim.lastname}" /></h2>

<br>


<sf:form id="form" method="POST" class="form-horizontal" modelAttribute="location" action="update">

	<sf:errors path="*" element="div" cssClass="alert alert-danger" />
	
	
	
	<s:bind path="postCode">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="postCode" class="col-sm-2 control-label">postCode</sf:label>
			<div class="col-sm-10">
				<sf:input path="postCode" id="postCode" class="form-control" placeholder="postCode" />
				<sf:errors path="postCode" class="control-label" />
			</div>
			</div>
	</s:bind>
	
	<s:bind path="city">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="city" class="col-sm-2 control-label">city</sf:label>
			<div class="col-sm-10">
				<sf:input path="city" id="city" class="form-control" placeholder="city" />
				<sf:errors path="city" class="control-label" />
			</div>
			</div>
	</s:bind>
	
	<s:bind path="street">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="street" class="col-sm-2 control-label">street</sf:label>
			<div class="col-sm-10">
				<sf:input path="street" id="street" class="form-control" placeholder="street" />
				<sf:errors path="street" class="control-label" />
			</div>
			</div>
	</s:bind>
	
	<s:bind path="number">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="number" class="col-sm-2 control-label">number</sf:label>
			<div class="col-sm-10">
				<sf:input path="number" id="number" class="form-control" placeholder="number" />
				<sf:errors path="number" class="control-label" />
			</div>
			</div>
	</s:bind>
	
	<s:bind path="latitude">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="latitude" class="col-sm-2 control-label">latitude</sf:label>
			<div class="col-sm-10">
				<sf:input path="latitude" id="latitude" class="form-control" placeholder="latitude" />
				<sf:errors path="latitude" class="control-label" />
			</div>
		</div>
	</s:bind>
	
	<s:bind path="longitude">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="longitude" class="col-sm-2 control-label">longitude</sf:label>
			<div class="col-sm-10">
				<sf:input path="longitude" id="city" class="form-control" placeholder="longitude" />
				<sf:errors path="longitude" class="control-label" />
			</div>
		</div>
	</s:bind>
	
	<input type="hidden" name="toMaps" id="maps" value="test">
	
	<div class="form-group">
		<div class="col-sm-2"></div>
		<div class="col-sm-10">
		<input type="button" class="btn btn-warning" id="button" value="select on maps">
		</div>
	</div>
	
	<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">
							<s:message code="update"/>
				</button>
			</div>
		</div>







</sf:form>




</div>
<script>
	$(function(){
		$("#button").click(function(){
			$("#maps").val('ok');
			$("#form").submit();
		});
		
	});

</script>

<jsp:include page="../fragments/footer.jsp" />
</html>