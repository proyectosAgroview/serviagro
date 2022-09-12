function initMap() {
	
	var url = document.getElementById("formDialog:tabMapa:url").value;
	var estado_kml = document.getElementById("formDialog:tabMapa:estado").value;

	if(estado_kml == "A" ){
		
		var map = new google.maps.Map(document.getElementById("formDialog:tabMapa:gmap"), { 
			
		});
		
		var kmlLayer = new google.maps.KmlLayer(
					  {
						url : url,
						map : map
					  });
	}
	

}

function initMapAnalisisEnfermedad(){
	
	
	//var url = args.kml;
	//var estado_kml = args.estado;
	
	var url = document.getElementById("frm:url").value;
	var estado_kml = document.getElementById("frm:estado").value;
	

	if(estado_kml == "A" ){
		
		var map = new google.maps.Map(document.getElementById("frm:tabMapa:gmap"), { 
			
		});
		
		var kmlLayer = new google.maps.KmlLayer(
					  {
						url : url,
						map : map
					  });
	}
	
	
}