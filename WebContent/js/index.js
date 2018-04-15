$(document).ready(function(){
    $("#loginSubmit").click(function(){
    	var postData = {};
    	xhrPost("rest/user/authenticate", postData,  function(result) {
    		alert(result);
    	}, function(error, status) {
    		alert(error + status);
    	});
    });
});