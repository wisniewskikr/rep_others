GOOGLE MAP

This application displays Google Map with some specified address. It consists of two pages:
- input page: user type address;
- output page: map with address is displayed.



USAGE
To use Google Map Api by Java Script developer has to:

1. Add Google Map Java Script file 
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

2. Create his own Java Script
function loadMap(address) {
	
	var myOptions = {
	  zoom: 17,
	  mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("map_container"), myOptions);
 
	var geocoder = new google.maps.Geocoder();
	  geocoder.geocode( { 'address': address}, function(results, status) {
	    if (status == google.maps.GeocoderStatus.OK) {
	      map.setCenter(results[0].geometry.location);
	      var marker = new google.maps.Marker({
	          map: map,
	          position: results[0].geometry.location
	      });
	    } else {
	      alert('Geocode was not successful for the following reason: ' + status);
	    } 
	  });
  
 }



WEBSITE WITH GEOLOCATION
Web site with latitude and longtitude:

http://www.findlatitudeandlongitude.com/