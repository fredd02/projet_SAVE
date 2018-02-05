<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div class="container"
>
	<hr>
	<footer>
		<p>Projet SAVE - Frédéric Appert - Défimedia
		</p>
	</footer>
</div>


<s:url value="/resources/js/bootstrap.min.js" var="BootstrapJs" />
<s:url value="/resources/js/monApplication.js" var="MyAppJs" />

<script src="${BootstrapJs}"></script>
<script src="${MyAppJs}"></script>
</body>