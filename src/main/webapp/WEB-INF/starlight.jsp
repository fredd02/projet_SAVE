<!DOCTYPE html>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<html>
<jsp:include page="fragments/header.jsp">
	<jsp:param name="titre" value="SAVE" />
</jsp:include>



<div class="container">
<div id="map" style="height:600px; width:100%"></div>
</div>

<script>

	window.onload = function(){
		loadMap();
	};
	
	function loadMap(){
		var mapOptions = {
				center: new google.maps.LatLng(50.672750, 5.076440),
				zoom: 8,
				mapTypeId: 'roadmap',
				mapTypeControl: false,
				styles: nightStyle
				
				
		};
		
		var map = new google.maps.Map(document.getElementById('map'), mapOptions);
		
		
		
		var iconBase = 'https://sites.google.com/site/savekml02/';
		var icons = {
				etoile: {
					icon: iconBase + 'star_icone03.png'
				},
				library: {
					icon: iconBase + 'library_maps.png'
				},
				info: {
					icon: iconBase + 'info-i_maps.png'
				}
		};
		
		
		
		var infowindow = new google.maps.InfoWindow();
		
		
		var stars = ${stars};
		
		for(i=0;i < stars.length;i++){
            
            var age;
            switch (stars[i].language){
                case "DEUTSCH":
                    age = "Jahre alt";
                    break;
                case "FRANCAIS":
                    age= "ans";
                    break;
                case "VLAAMS":
                    age = "jaar oud";
                    break;
                default:
                    age = "years old";
                    
            }
            
            if(stars[i].virtualPanel !== 1){
            var sContent="<h4>" + stars[i].lastname + "</h4>"
                        +"<p>"+ stars[i].age +" " + age + "</p>";
            } else {
                var sContent="<div class='virtual'><i><h4>" + stars[i].lastname + "</h4>"
                        +"<p>"+ stars[i].age +" " + age + "</p></i></div>";
                
            }
                

             var latLng = new google.maps.LatLng(stars[i].latitude, stars[i].longitude);
                    var marker = new google.maps.Marker({
                        position: latLng,
                        title: stars[i].firstname,
                        icon:icons.etoile.icon,
                        content: sContent ,
                        infoWindow: infowindow,
                        map:map

                    });
                    
            
            
            google.maps.event.addListener(marker, 'click',function(){
                infowindow.close();
                infowindow.setContent(this.content);
                infowindow.open(map, this);
      });   
    }
		
	}


</script>
<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC3qaQ7Q58wlP20w-A2LCA-t596j2ODbuk&callback=initMap">
</script>
<jsp:include page="./fragments/footer.jsp" />
</html>