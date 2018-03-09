<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container"
>
	<hr>
	locale: <c:out value="${pageContext.response.locale}" />
	<footer>
		<p>Projet SAVE - Frédéric Appert - Défimedia
		</p>
	</footer>
</div>


<s:url value="/resources/js/bootstrap.min.js" var="BootstrapJs" />
<s:url value="/resources/js/monApplication.js" var="MyAppJs" />
<s:url value="/resources/js/map_style.js" var="mapStyle" />

<script src="${BootstrapJs}"></script>
<script src="${MyAppJs}"></script>
<script src="${mapStyle}"></script>

</body>