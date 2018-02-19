<!DOCTYPE html>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<html>
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="titre" value="SAVE" />
</jsp:include>
<div class="container">
<h2><s:message code="select.location.map" /></h2>
<form class="form-inline" action="${pageContext.request.contextPath}/location/${id}/${addOrUpdate}">
	<div class="form-group">
		<label for="latitude">latitude</label>
		<input type="number" step="0.000000000000001" class="form-control" id="latitude" name="latitude">
	</div>
	<div class="form-group">
		<label for="longitude">longitude</label>
		<input type="number" step="0.000000000000001" class="form-control" id="longitude" name="longitude">
	</div>
	<button type="submit" class="btn btn-default">Submit</button>
</form>
<hr>
<div id="map" style="height:600px; width:800px"></div>






</div>
<script>
      function initMap() {
        
        var hannut = {lat: 50.672750, lng: 5.076440};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
          center: hannut
        });
        google.maps.event.addListener(map,'click',function(event){
        	var lat = event.latLng.lat();
        	var lng = event.latLng.lng();
          var ok = confirm("lat= " + lat + "; long= " + lng);
          if(ok == true){
        	  document.getElementById('latitude').value = lat;
        	  document.getElementById('longitude').value=lng;
        	  
          }
      });
        map.setOptions({draggableCursor:'crosshair'});
        
      }
      
      
      
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC3qaQ7Q58wlP20w-A2LCA-t596j2ODbuk&callback=initMap">
    </script>

<jsp:include page="./fragments/footer.jsp" />
</html>