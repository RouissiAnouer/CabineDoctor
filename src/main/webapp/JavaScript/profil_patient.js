/**
 * 
 */

$.getScript('JavaScript/moment.js', function() {
	  
});

$(function() {
    //----- OPEN
    $('[data-popup-open]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-open');
        $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);
 
        e.preventDefault();
    });
 
    //----- CLOSE
    $('[data-popup-close]').on('click', function(e)  {
        var targeted_popup_class = jQuery(this).attr('data-popup-close');
        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);
 
        e.preventDefault();
    });
});







$(document).ready(getallbyid());
function getallbyid() {
	
	 var url = document.location.href,
     params = url.split('?')[1],
     data = {}, tmp;
    id=params.slice(3,10);
    
    
	var url="webapi/rendezvous/getByPatient/?id="+id;
	$.ajax({
	type:"GET",
	url:url,
	contentType:"application/json; charset=utf-8",
    dataType: "json",
    success: function (obj) {
    	var globalCounter = 0;
    	var tbody = document.getElementById('tbody');
    	

    	for (var i = 0; i < obj.length; i++) {
    	    var tr = "<tr>";

    	    /* Verification to add the last decimal 0 */
    	    

    	    /* Must not forget the $ sign */
    	    tr += "<td>"+obj[i].dateRdv+"</td><td>"+obj[i].heureRdv+"</td><td>"+obj[i].etatRdv+"</td>"
    	    /* We add the table row to the table body */
    	    tbody.innerHTML += tr;
    	}
    }
	})
	 //window.history.pushState("", "", '/GestionCabinet/profil_patient.html');
}

/*function addrdv(){
	 var url = document.location.href,
     params = url.split('?')[1],
     data = {}, tmp;
    id=params.slice(3,10);
    document.location.href="http://localhost:8080/GestionCabinet/ajout_rdv.html?id="+id;

}*/

var addRdv = function(){
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



function myFunction() {
	  // Declare variables 
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}