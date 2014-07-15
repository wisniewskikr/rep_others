function loadMap() {
	
	//var latlng = new google.maps.LatLng(53.3669049, 14.603458);
	var myOptions = {
	  zoom: 17,
//	  center: latlng,
	  mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("map_container"), myOptions);
 
	var address = 'Polanka 20B, Poznan';
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
