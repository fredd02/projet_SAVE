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

<sf:form method="POST" class="well form-horizontal" modelAttribute="responsible" action="add">
<legend class="text-center"><h2><b><s:message code="addResponsibleVictim"/>: <c:out value="${victim.firstname} ${victim.lastname}" /></b></h2></legend>

	<sf:errors path="*" element="div" cssClass="alert alert-danger" />
	
	<s:bind path="firstname">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="firstname" class="col-md-4 control-label"><s:message code="Firstname" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<sf:input path="firstname" id="firstname" class="form-control" placeholder="firstname" />
				<sf:errors path="firstname" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="lastname">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="lastname" class="col-md-4 control-label"><s:message code="Lastname" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<sf:input path="lastname" id="lastname" class="form-control" placeholder="lastname" />
				<sf:errors path="lastname" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="postCode">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="postCode" class="col-md-4 control-label"><s:message code="postCode" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<sf:input path="postCode" id="postCode" class="form-control" placeholder="postCode" />
				<sf:errors path="postCode" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="city">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="city" class="col-md-4 control-label"><s:message code="city" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<sf:input path="city" id="city" class="form-control" placeholder="city" />
				<sf:errors path="city" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="street">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="street" class="col-md-4 control-label"><s:message code="street" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<sf:input path="street" id="street" class="form-control" placeholder="street" />
				<sf:errors path="street" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="number">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="number" class="col-md-4 control-label"><s:message code="number" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
				<sf:input path="number" id="number" class="form-control" placeholder="number" />
				<sf:errors path="number" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="email">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="email" class="col-md-4 control-label"><s:message code="mail" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
				<sf:input path="email" id="number" class="form-control" placeholder="email" />
				<sf:errors path="email" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="phone">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="phone" class="col-md-4 control-label"><s:message code="phone" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
				<sf:input path="phone" id="phone" class="form-control" placeholder="phone" />
				<sf:errors path="phone" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<s:bind path="connection">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="connection" class="col-md-4 control-label"><s:message code="victimConnection" /></sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<sf:input path="connection" id="connection" class="form-control" placeholder="connection" />
				<sf:errors path="connection" class="control-label" />
			</div>
			</div>
			</div>
	</s:bind>
	
	<div class="form-group">
		<label class="col-md-4 control-label"></label>
			<div class=" col-md-4">
				<button type="submit" class="btn btn-primary">
							<s:message code="add" /> <span class="glyphicon glyphicon-save"></span>
				</button>
			</div>
		</div>
</sf:form>

</div>

<jsp:include page="../fragments/footer.jsp" />
</html>