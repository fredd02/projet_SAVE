<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
<!--     interdire le mode de compatibilité sur IE -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>forgotPassword</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="container">
	<img src="<s:url value="/resources/img/logo_save.svg" />" width="50" height="50"
					class="img-responsive center-block" />
	
	<form method="POST" action="${contextPath}/forgot" class="form-signin">
	<h2 class="form-signin-heading"><s:message code="password.forgot" /></h2>
	<s:message code="password.forgot.email" /><br><br>
	
		<div class="form-group">
			<label for="email"><s:message code="mail" /></label>
			<input name="email" class="form-control" id="email" autofocus placeholder="email"/>
		</div>
		
		<!--             protection contre les attaques CSRF -->
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
		
		<button type="submit" class="btn btn-primary"><s:message code="send" /></button>

	</form>
	<div class="text-center">
	<c:out value="${successMessage}" />
	</div>
	
	
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>