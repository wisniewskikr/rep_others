function loadMap() {
	var latlng = new google.maps.LatLng(53.3669049, 14.603458);
	var myOptions = {
	  zoom: 17,
	  center: latlng,
	  mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
 
    var marker = new google.maps.Marker({
      position: latlng, 
      map: map, 
      title:"Google Map!"
    }); 
 
  }