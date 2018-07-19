var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};



$(document).ready(getall());
function getall(){
	var id=getUrlParameter('id');
    var url ="webapi/patient/getone?id="+id;
    $.ajax({
    	type:"GET",
    	url:url,
    	contentType:"application/json; charset=utf-8",
	    dataType: "json",
	    success: function (obj) {
	    	var identity= document.getElementById('identity');
	    	code1="<p><span class='glyphicon glyphicon-user'></span> "+obj.prenom+" "+obj.nom+"</p>"+
	    	"<p><span class='glyphicon glyphicon-credit-card'></span> "+obj.cin+"</p>"+
			  "<p><span class='glyphicon glyphicon-earphone'></span> "+obj.tel+"</p>"+
			  "<p><span class='glyphicon glyphicon-calendar'></span> "+obj.dateNaiss+"</p>"+
	          "<p><span class='glyphicon glyphicon-info-sign'></span> "+obj.sexe+"</p>"+
	          "<p><span class='glyphicon glyphicon-folder-open'></span> "+obj.dossier+"</p>";
	    	identity.innerHTML +=code1;
	    }
    })
    
}
$(document).ready(getrdv());
function getrdv(){
	var id=getUrlParameter('id');
    var url ="webapi/rendezvous/getByPatient?id="+id;
    $.ajax({
    	type:"GET",
    	url:url,
    	contentType:"application/json; charset=utf-8",
	    dataType: "json",
	    success: function (obj) {
	        	var globalCounter = 0;
	        	var tbody = document.getElementById('tbody-2');
	        	for (var i = 0; i < obj.length; i++) {
	        	    var tr = "<tr>";
	        	    tr += "<td>"+obj[i].dateRdv+"</td><td>"+obj[i].heureRdv+"</td><td>"+obj[i].etatRdv+"</td><td>"+
	        	    "<div style='display:inline-block; margin-left:20px;'>"+
	                  "<a href='#' ><span class='glyphicon glyphicon-trash' title='Supprimer'></span></a></div>"+
	                  "<div style='display:inline-block;  margin-left:20px;'>"+
	                  "<a href='#' >"+
	                  "<span class='glyphicon glyphicon-pencil' title='Modifier'></span></a></div></td></tr>";
	        	    tbody.innerHTML += tr;
	        	}
	        }
	    	})
	    	 
	    }

$(document).ready(getbilan());
function getbilan(){
	var id=getUrlParameter('id');
    var url ="webapi/bilan/displayBilan?id="+id;
    $.ajax({
    	type:"GET",
    	url:url,
    	contentType:"application/json; charset=utf-8",
	    dataType: "json",
	    success: function (obj) {
	        	var globalCounter = 0;
	        	var tbody = document.getElementById('tbody1');
	        	for (var i = 0; i < obj.length; i++) {
	        	    var tr = "<tr>";
	        	    tr += "<td>"+obj[i].dateBilan+"</td><td>"+obj[i].libelleBilan+"</td><td>"+
	        	    "<div style='display:inline-block; margin-left:20px;'>"+
	                  "<a href='#' ><span class='glyphicon glyphicon-trash' title='Supprimer'></span></a></div>"+
	                  "<div style='display:inline-block;  margin-left:20px;'>"+
	                  "<a href='#' >"+
	                  "<span class='glyphicon glyphicon-pencil' title='Modifier'></span></a></div></td></tr>";
	        	    tbody.innerHTML += tr;
	        	}
	        }
	    	})
	    	 
	    }


$(document).ready(getvisite());
function getvisite(){
	
	var id=getUrlParameter('id');
	var url ="webapi/visite/displayVisite?id="+id;
	
    $.ajax({
    	type:"GET",
    	url:url,
    	contentType:"application/json; charset=utf-8",
	    dataType: "json",
	    success: function (data) {
	        	var globalCounter = 0;
	        	var tbody = document.getElementById('myTbody');
	        	var tr = "<tr>";
	        	for (var i = 0; i < data.length; i++) {
	        		
	        		
	        		
	        	   tr += "<td>"+data[i].dateVisite+"</td><td>"+data[i].heureVisite+"</td><td>"+data[i].motifVisite+"</td><td>"+
	        	    "<div style='display:inline-block; margin-left:20px;'>"+
	                  "<a href='#' ><span class='glyphicon glyphicon-trash' title='Supprimer'></span></a></div>"+
	                  "<div style='display:inline-block;  margin-left:20px;'>"+
	                  "<a href='#' >"+
	                  "<span class='glyphicon glyphicon-pencil' title='Modifier'></span></a></div></td></tr>";
	        	    
	        	    tbody.innerHTML += tr;
	        	}
	        }
	    	})
	    	 
	    }
/*****************************************supprimer************************/
