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
<h1>Ajouter une victime</h1>

<sf:form method="POST" class="form-horizontal" modelAttribute="victim" action="add">

	<sf:errors path="*" element="div" cssClass="alert alert-danger" />
	
	<s:bind path="firstname">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="firstname" class="col-sm-2 control-label">
				First name
			</sf:label>
			<div class="col-sm-10">
				<sf:input path="firstname" id="firstname" class="form-control" placeholder="firstname" />
				<sf:errors path="firstname" class="control-label" />
			</div>
		</div>
	</s:bind>
	
	<s:bind path="lastname">
		<div class="form-group ${status.error ? has-error : ''}">
			<sf:label path="lastname" class="col-sm-2 control-label">
				Last name
			</sf:label>
			<div class="col-sm-10">
				<sf:input path="lastname" id="lastname" class="form-control" placeholder="lastname" />
				<sf:errors path="lastname" class="control-label" />
			</div>
		</div>
	</s:bind>
	
	<s:bind path="birthdate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<sf:label path="birthdate" class="col-sm-2 control-label">
					Birth date
				</sf:label>
				<div class="col-sm-10">
					<sf:input path="birthdate" id="birthdate" class="form-control"
						placeholder="birthdate" />
					<sf:errors path="birthdate" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="accidentdate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<sf:label path="accidentdate" class="col-sm-2 control-label">
					Accident date
				</sf:label>
				<div class="col-sm-10">
					<sf:input path="accidentdate" id="accidentdate" class="form-control"
						placeholder="accidentdate" />
					<sf:errors path="accidentdate" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="sex">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<sf:label path="sex" class="col-sm-2 control-label">
					Sex
				</sf:label>
				<div class="col-sm-10">
					<sf:input path="sex" id="sex" class="form-control"
						placeholder="sex" />
					<sf:errors path="sex" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">
							ajouter
				</button>
			</div>
		</div>




</sf:form>

</div>

<jsp:include page="../fragments/footer.jsp" />
</html>