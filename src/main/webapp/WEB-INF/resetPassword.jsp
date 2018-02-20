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
	
		<form method="POST" action="${contextPath}/reset" onsubmit="return pwValidate()" class="form-signin">
			<h4 class="form-heading text-center"> <s:message code="password.new" /></h4>
        	<br>
			<div class="form-group">
				<label for="password"><s:message code="Password" />:</label>
				<input name="password" type="password" class="form-control" id="password">
			</div>
			
			<div class="form-group">
				<label for="passwordConfirm"><s:message code="password.confirm" />:</label>
				<input name="passwordConfirm" type="password" class="form-control" id="passwordConfirm">
			</div>
			
			
			
		<!--             protection contre les attaques CSRF -->
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
            
            <input type="hidden" name="token" value="${resetToken}" />
		<button type="submit" class="btn btn-primary"><s:message code="send" /></button>

	</form>
	
	</div>
<script>
	function pwValidate(){
		var password = document.getElementById("password").value;
		var passwordConfirm = document.getElementById("passwordConfirm").value;
		var ok =true;
		if(password != passwordConfirm){
			document.getElementById("password").style.borderColor = "#E34234";
			document.getElementById("passwordConfirm").style.borderColor = "#E34234";
			//confirmPassword.setCustomValidity("Passwords don't match");
			ok=false;
		}
		return ok;
	}

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>