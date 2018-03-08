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
<div class="text-center"><h2><b><s:message code="locationInfos"/></b></h2></div>
<br>

<div class="row">
	<div class="col-sm-4">

		<ul class="well list-group">
		  <li class="list-group-item"><b>Code Postal: </b><c:out value="${location.postCode}" /></li>
		  <li class="list-group-item"><b>Ville: </b><c:out value="${location.city}" /></li>
		  <li class="list-group-item"><b>Rue: </b><c:out value="${location.street}" /></li>
		  <li class="list-group-item"><b>Numero: </b><c:out value="${location.number}" /></li>
		  <li class="list-group-item" ><b>Latitude: </b><c:out value="${location.latitude}" /></li>
		  <li class="list-group-item" id="longitude"><b>Longitude: </b><c:out value="${location.longitude}" /></li>
		  <li class="list-group-item text-center"><s:url value="/location/${location.id}/update" var="updateUrl" />
					<button class="btn btn-info" 
						onclick="location.href='${updateUrl}'"><s:message code="update" /></button>
						
				<s:url value="/location/${location.id}/delete" var="deleteUrl" />
				<button class="btn btn-danger" 
						onclick="
							if(confirm('Suppression de la localisation ?')){
								this.disabled=true;
								post('${deleteUrl}',{'${_csrf.parameterName}': '${_csrf.token}'})}                             
		                                              "><s:message code="delete" /></button></li>
		  
		</ul>
	</div>
	<div class="col-sm-8" id="map" style="height:400px; width:60%">
	</div>
</div>

	
</div>
<script>
      function initMap() {
        
        var hannut = {lat: 50.672750, lng: 5.076440};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
          center: hannut
        });
        
        var latitude = ${location.latitude};
        var longitude = ${location.longitude};
        
        var loc = {lat:latitude, lng: longitude};
        
        var marker = new google.maps.Marker({
        	position: loc,
        	map: map
        });
        
        
      }
      
      
      
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC3qaQ7Q58wlP20w-A2LCA-t596j2ODbuk&callback=initMap">
    </script>

<jsp:include page="../fragments/footer.jsp" />
</html>