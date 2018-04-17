$(document).ready(function(){
    $("#loginSubmit").click(function(event){
    	var postData = {userName : $('#userName').val(), password : $('#password').val()};
    	xhrPost("rest/user/authenticate", postData,  function(result) {
    		if (result) {
				$('#loginForm').hide();
				showGoogleMap();
			}
    	}, function(error, status) {
    		console.log("Staus" + status +" Error" +error );
    	});
    });
});

function showGoogleMap() {
	var locations = [
		  ['CTW Dighi Pimpri-Chinchwad, Maharashtra 411039',18.6123331, 73.85091160000002, 3],
		  ['CME Lake, Upper Lake, Bopkhel, Pimpri-Chinchwad, Maharashtra 411034', 18.606424, 73.847845,  2],
		  ['Upper Lake, Bopkhel, Pimpri-Chinchwad, Maharashtra', 18.603389, 73.841207, 1]
		  ];

	    var map = new google.maps.Map(document.getElementById('map'), {
	      zoom: 14,
	      center: new google.maps.LatLng(18.60, 73.84),
	      mapTypeId: google.maps.MapTypeId.ROADMAP
	    });
	    // By default position for map is 'relative' which makes it not visible on UI, so setting it to absolute.
	    document.getElementById('map').style.position='absolute';
	    var infowindow = new google.maps.InfoWindow();

	    var marker, i;

	    for (i = 0; i < locations.length; i++) {  
	      marker = new google.maps.Marker({
	        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
	        map: map
	      });

	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
	        return function() {
	          infowindow.setContent(locations[i][0]);
	          infowindow.open(map, marker);
	        }
	      })(marker, i));
	    }
}
function myMap() {
}