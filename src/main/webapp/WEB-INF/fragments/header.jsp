<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%-- <%@ taglib prefix="sec" --%>
<%-- 	uri="http://www.springframework.org/security/tags"%> --%>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>${param.titre}</title>
<!-- Required meta tags for bootstrap-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- chargement des styles avec bootstrap first -->
<s:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" var="bootstrapCss" />
<%-- <s:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" /> --%>
<s:url value="/resources/css/style.css" var="styleCss" />
<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${styleCss}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<img src="<s:url value="/resources/img/logo_save.svg"/>" width="50" height="50"
					class="d-inline-block align-top-left" /> <a href="https://www.pevr.be" target="blank">SAVE</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<s:url value="/"/>">Home</a></li>
				<li><a href="/SAVE-02/victim/add"><s:message code="victimEncode"/></a></li>
				<li><a href="/SAVE-02/victim/list"><s:message code="victimListSee"/></a></li>
				
			</ul>
		
		
		
		
		
		</div>
	
	
	
	
	
	
	</nav>