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

<s:message code="age" var="age"/>
<s:message code="Firstname" var="Firstname"/>
<s:message code="Lastname" var="Lastname"/>
<s:message code="AccidentDate" var="AccidentDate"/>
<s:message code="sex" var="sex"/>
<s:message code="language" var="language"/>
<s:message code="SelectLanguage" var="selectLanguage"/>
<s:message code="selectSex" var="selectSex" />
<s:message code="virtual.panel" var ="virtualPanel" />


<sf:form method="POST" class="well form-horizontal" modelAttribute="victim" action="add">
<legend class="text-center"><h2><b><s:message code="addVictim"/></b></h2></legend>

	<sf:errors path="*" element="div" cssClass="alert alert-danger" />
	
	<s:bind path="firstname">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<sf:label path="firstname" class="col-md-4 control-label">
				${Firstname}
			</sf:label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
					<sf:input path="firstname" id="firstname" class="form-control" placeholder="${Firstname}" 
						 autofocus="autofocus"/>
					
				</div>
				<sf:errors path="firstname" class="control-label" />
			</div>
		</div>
	</s:bind>
	
	<s:bind path="lastname">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<sf:label path="lastname" class="col-md-4 control-label">
				${Lastname} *
			</sf:label>
			<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<sf:input path="lastname" id="lastname" class="form-control" placeholder="${Lastname}" required="required"/>
				
				</div>
				<sf:errors path="lastname" class="control-label" />
			</div>
		</div>
	</s:bind>
	
	<s:bind path="age">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<sf:label path="age" class="col-md-4 control-label">
					${age}
				</sf:label>
				<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					
					<sf:input path="age" id="age" class="form-control"
						placeholder="${age}" />
					
				</div>
				<sf:errors path="age" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="accidentdate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<sf:label path="accidentdate" class="col-md-4 control-label">
					${AccidentDate}
				</sf:label>
				<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					<sf:input path="accidentdate" id="accidentdate" class="form-control"
						placeholder="${AccidentDate}"/>
					
				</div>
				<sf:errors path="accidentdate" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="sex">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<sf:label path="sex" class="col-md-4 control-label">
					${sex}
				</sf:label>
				<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
					<sf:select path="sex" class="form-control">
						<sf:option value="" label="${selectSex}" />
						<sf:option value="0"><s:message code="male" /></sf:option>
						<sf:option value="1"><s:message code="female" /></sf:option>
					</sf:select>
					
				</div>
				<sf:errors path="sex" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		
		<s:bind path ="language">
			<div class="form-group">
				<sf:label path="language" class="col-md-4 control-label">
					${language}
				</sf:label>	
				<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
					
					<sf:select path="language" class="form-control">
						<sf:option value="" label="${selectLanguage}" />
						<sf:options path="${language}" />
					</sf:select>
				</div>
				</div>
			</div>
		</s:bind>
		
		<s:bind path="virtualPanel">
		
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<sf:label path="virtualPanel" class="col-md-4 control-label">
					${virtualPanel}
					
				</sf:label>
				<div class="col-md-4">
				<sf:checkbox path="virtualPanel" value="1" class="form-check-input" />
				</div>
					
					<sf:errors path="virtualPanel" class="control-label" />
				
			</div>
		</s:bind>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<div class="form-group">
			<label class="col-md-4 control-label"></label>
  			<div class="col-md-4"><br>
			
				<button type="submit" class="btn btn-primary">
							<s:message code="add"/> <span class="glyphicon glyphicon-save"></span>
				</button>
			</div>
		</div>




</sf:form>
</div>

<jsp:include page="../fragments/footer.jsp" />
<script>
	$(function(){
		$("#accidentdate").datepicker(
				{dateFormat: "dd/mm/yy"});
	});

</script>
</html>