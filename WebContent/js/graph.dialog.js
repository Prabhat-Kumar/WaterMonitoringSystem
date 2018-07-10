function openGraph (titleText, graphData) {
	var $dialog = $("#graphDialogBox").dialog({
		title: titleText,
		autoOpen: false,
		modal: true,
		draggable: true,
		resizable: false,
		dialogClass: "graphClass",
	}).load("Pages/graph.container.html", function() {
		$dialog.find(".graphCloseButton").on("click", function(e) {
			$().dialog("destroy");
			$dialog.dialog("close");
			$dialog.dialog("destroy");
		});
		$dialog.dialog("open");
		$('.graphClass').css({'position': 'absolute', 'background-color': 'white', 'height': '100%', 'width': '100%', 'top': '0px', 'left': '0px'});
		loadGraph (graphData);
	});
}

function loadGraph (graphData) {

		var objctx = document.getElementById('canvas').getContext('2d');
        objctx.beginPath();
        for (i = 0; i < graphData.length; i++) {
        	if (i == 0) {
        		 objctx.moveTo(parseInt(graphData[i].time), graphData[i].pH);
			} else {
				objctx.lineTo(parseInt(graphData[i].time), graphData[i].pH);				
			}
		}
        objctx.closePath();
        objctx.stroke();
}