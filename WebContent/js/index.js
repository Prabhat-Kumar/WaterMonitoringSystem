$(document).ready(function(){
	$("#message").hide();
	$("#demo").hide();
    $("#loginSubmit").click(function(event){
    	var postData = {userName : $('#userName').val(), password : $('#password').val()};
    	xhrPost("rest/user/authenticate", postData,  function(result) {
    		if (result) {
				$('#loginForm').hide();
				$("#message").hide();
				$("#demo").show();
				showGoogleMap();
			}else{
				$('#userName').val("");
				$('#password').val("");
				$("#message").show();
				$("#message").css("color", "red");
			}
    	}, function(error, status) {
    		console.log("Staus" + status +" Error" +error );
    	});
    });
    
    $("#demo").click(function(event){
    	xhrGet("rest/waterDemo/datas", function(waterDatas) {
    		openGraphDemo("Live Demo from temprature and PH", waterDatas);
    	});
    });
});

function showGoogleMap() {
	xhrGet("rest/water/datas", function(waterDatas) {
		if (waterDatas) {
			var map = new google.maps.Map(document.getElementById('map'), {
			      zoom: 12,
			      center: new google.maps.LatLng(18.62, 73.65),
			      mapTypeId: google.maps.MapTypeId.ROADMAP
			    });
			    // By default position for map is 'relative' which makes it not visible on UI, so setting it to absolute.
			    document.getElementById('map').style.position='absolute';
			    var infowindow = new google.maps.InfoWindow();

			    var marker, i;

			    for (i = 0; i < waterDatas.length; i++) {  
			      marker = new google.maps.Marker({
			        position: new google.maps.LatLng(waterDatas[i].latitude, waterDatas[i].longitude),
			        map: map
			      });

			      google.maps.event.addListener(marker, 'click', (function(marker, i) {
			        return function() {
			          openGraph (waterDatas[i].location, waterDatas[i].records);
			        }
			      })(marker, i));
			    }
		}
	}, function(error, status) {
		console.log("Staus" + status +" Error" +error );
	});
}
function myMap() {
}