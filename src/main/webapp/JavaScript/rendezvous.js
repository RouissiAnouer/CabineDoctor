/**
 * 
 */

$.getScript('JavaScript/moment.js', function() {
	  
});




var getone = function(){
	 var date=document.getElementById("date").value;
	  var time=document.getElementById("time").value;
	  var lien = document.location.href,
	    params = lien.split('?')[1],
	    data = {}, tmp;
	   id=params.slice(3,10);
	 
	var url = "webapi/patient/getone?id="+id;
	$.ajax({
	    type: "GET",
	    url: url,
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	   
	      success: function (patient) {
	    	 
	    		  $(document).ready(save(patient,date,time));
	      
	    }
		
	})	
}	



var save = function(patient,date,time){
	
	var lien = document.location.href,
    params = lien.split('?')[1],
    data = {}, tmp;
   id=params.slice(3,10);
   
	var url="webapi/rendezvous/add";
	$.ajax({
		type:"POST",
		url:url,
		data:JSON.stringify({
			"dateRdv":moment(date,"YYYY-MM-DD"),
			"heureRdv":moment(time,"HH:mm:ss"),
			"patient":patient
		}),
		error: function(e) {
		    console.log(e);
		  },
		dataType: "json",
		contentType: "application/json",
		success: function(data){
			document.location.href="http://localhost:8080/GestionCabinet/profil_patient.html?id="+id;
			}
	})
}