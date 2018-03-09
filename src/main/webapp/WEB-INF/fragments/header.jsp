<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
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
<%-- <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>  --%>
<script src="../resources/js/moment.js"></script>
<script src="../resources/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/fixedheader/3.1.3/js/dataTables.fixedHeader.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.1/js/responsive.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.16/sorting/datetime-moment.js"></script>

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.1.3/css/fixedHeader.bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.1/css/responsive.bootstrap.min.css"/>

<s:url value="/login" var="loginUrl" />
<s:url value="/logout" var="logoutUrl" />


</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<img src="<s:url value="/resources/img/logo_save.svg"/>" width="50" height="50"
					class="d-inline-block align-top-left" /> <a href="https://www.pevr.be" target="blank">SAVE</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<s:url value="/"/>">Home</a></li>
				<li><a href="${contextPath}/victim/add"><s:message code="victimEncode"/></a></li>
				<li><a href="${contextPath}/victim/list"><s:message code="victimListSee"/></a></li>
				
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><s:message code="menu.langue" /><span class="caret"></span></a>
					<ul class="dropdown-menu">
							<li><a href="?lang=fr">fr</a></li>
							<li><a href="?lang=en">en</a></li>
						</ul>
			</li>
				
			</ul>
			
			
			
			<ul class="nav navbar-nav navbar-right">
			 <sec:authorize access="isAuthenticated()">
				<li><a
					href="" onclick="post('${logoutUrl}',{'${_csrf.parameterName}': '${_csrf.token}'})" >
					<span class="glyphicon glyphicon-log-out"></span>
						Logout <sec:authentication property="principal.username" /></a>
				</li>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<li><a
					href="${loginUrl}"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</sec:authorize>
			</ul>
		
		
		
		
		
		</div>
	
	
	
	
	
	
	</nav>