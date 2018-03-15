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

<s:message code="postCode" var="postCode" />
<s:message code="city" var="city" />
<s:message code="postCode" var="postCode" />
<s:message code="street" var="street" />
<s:message code="number" var="number" />




<div class="container">


<sf:form id	="form" method="POST" class="well form-horizontal" modelAttribute="location" action="add">
<legend class="text-center"><h2><b><s:message code="addLocationVictim"/> <c:out value="${victim.firstname} ${victim.lastname}" /></b></h2></legend>

	<sf:errors path="*" element="div" cssClass="alert alert-danger" />
	
	
	
	<s:bind path="postCode">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="postCode" class="col-sm-4 control-label"><s:message code="postCode"/></sf:label>
			<div class="col-sm-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<sf:input path="postCode" id="postCode" class="form-control" placeholder="${postCode}" />
				<sf:errors path="postCode" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="city">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="city" class="col-sm-4 control-label"><s:message code="city"/></sf:label>
			<div class="col-sm-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<sf:input path="city" id="city" class="form-control" placeholder="${city}" />
				<sf:errors path="city" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="street">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="street" class="col-sm-4 control-label"><s:message code="street"/></sf:label>
			<div class="col-sm-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<sf:input path="street" id="street" class="form-control" placeholder="${street}" />
				<sf:errors path="street" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="number">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="number" class="col-sm-4 control-label"><s:message code="number"/></sf:label>
			<div class="col-sm-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<sf:input path="number" id="number" class="form-control" placeholder="${number}" />
				<sf:errors path="number" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="latitude">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="latitude" class="col-sm-4 control-label">latitude</sf:label>
				<div class="col-sm-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
				<sf:input path="latitude" id="latitude" class="form-control" placeholder="latitude" />
				<sf:errors path="latitude" class="control-label" />
			</div>
			</div>
		</div>
	</s:bind>
	
	<s:bind path="longitude">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="longitude" class="col-sm-4 control-label">longitude</sf:label>
			<div class="col-sm-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
				<sf:input path="longitude" id="city" class="form-control" placeholder="longitude" />
				<sf:errors path="longitude" class="control-label" />
			</div>
			</div>
		</div>
	</s:bind>
	
	<input type="hidden" name="toMaps" id="maps" value="test">
	
	<div class="form-group">
		<div class="col-md-offset-4 col-md-8">
			
		
			<input type="button" class="btn btn-warning" id="button" value="<s:message code='select.location.map'/>"/>
			
		</div>
	</div>
	
	<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<div class="input-group">
				
				<button type="submit" class="btn btn-primary pull-left">
							<s:message code="add" /> <span class="glyphicon glyphicon-save"></span>
				</button>
				</div>
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