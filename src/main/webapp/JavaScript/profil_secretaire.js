/**
 * 
 */
$.getScript('JavaScript/moment.js', function() {
	  
});

/************************************recuperation des rendez-vous**************/
$(document).ready(getall());
function getall(){
    var url ="webapi/rendezvous/getall";
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
	    	    tr += "<td>" + obj[i].dateRdv + "</td><td>" + obj[i].heureRdv +
	    	    "</td><td>"+ obj[i].etatRdv +"</td><td>"+obj[i].patient.nom+" "+obj[i].patient.prenom+
	    	    "</td><td>"+
	    	    " <div style='display:inline-block;margin-left:5px;'>"+
                  "<a href='#' onclick='refuser("+obj[i].idRdv+")' >"+
                  "<span class='glyphicon glyphicon-remove' title='Refuser'></span></a></div>"+
                  " <div style='display:inline-block;'>"+
                  "<a href='#' onclick='valider("+obj[i].idRdv+")' >"+
                  "<span class='glyphicon glyphicon-ok' title='Valider'></span></a></div>"+
                  "<div style='display:inline-block;'>"+
                  "<a href='#' data-popup-open='popup-1'  onclick='modifier("+obj[i].idRdv+")'>"+
                  "<span class='glyphicon glyphicon-pencil' title='Modifier'></span></a></div>"+
                  " <div style='display:inline-block;'>"+
                  "<a href='#'  onclick='supprimer("+obj[i].idRdv+")' >"+
                  "<span class='glyphicon glyphicon-trash' title='Supprimer'></span></a></div>"
	    	    +"</td></tr>";
	    	    tbody.innerHTML += tr;
	    	}
	    }
    })  
}





var modifier = function(id){
	var modal = document.getElementById('myModal');
	// Get the button that opens the modal
	modal.style.display = "block";
	$("#date").val(date);
	$("#time").val(time);
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	// When the user clicks on the button, open the modal 
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	    modal.style.display = "none";
	}
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	        var date=document.getElementById("date").value;
	    	var time=document.getElementById("time").value;
			
	    	var url="webapi/rendezvous/update";
	    	$.ajax({
	    		type:"POST",
	    		url:url,
	    		data:JSON.stringify({
	    			"dateRdv":moment(date,"YYYY-MM-DD"),
	    			"heureRdv":moment(time,"HH:mm:ss"),
	    			"idRdv":id
	    		}),
	    		error: function(e) {
	    		    console.log(e);
	    		  },
	    		dataType: "json",
	    		contentType: "application/json",
	    		success: function(data){
	    			window.location = "./profil_secretaire.html"
	    			}
	    	})
}
	}}






var refuser = function(id){
	var url="webapi/rendezvous/refuser?id="+id;
	$.ajax({
		type:"GET",
    	url:url,
    	contentType:"application/json; charset=utf-8",
	    dataType: "json",
	    success: function(data){
	    	window.location = "./profil_secretaire.html"
		}
	})
	
}

var valider = function(id){
	var url="webapi/rendezvous/valider?id="+id;
	$.ajax({
		type:"GET",
    	url:url,
    	contentType:"application/json; charset=utf-8",
	    dataType: "json",
	    success: function(data){
	    	window.location = "./profil_secretaire.html"
		}
	})
	
}

var supprimer = function(id){
	var url="webapi/rendezvous/delete";
	$.ajax({
		type:"DELETE",
		data:JSON.stringify(id),
    	url:url,
    	contentType:"application/json; charset=utf-8",
	    dataType: "json",
	    success: function(data){
	    	window.location = "./profil_secretaire.html"
		}
	})
	
}

/*********************************************fonction de recherche******************/
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
/**********************************************ajout rendez-vous***************************/
var addRdv = function(date,heure,id){
	var date=document.getElementById("input1").value;
 	var heure=document.getElementById("input2").value;
 	var id = getUrlParameter('id');
 	var url="webapi/rendezvous/add";
		$.ajax({
		type:"POST",
		url:url,
		data:JSON.stringify({
			"idUtilisateur":id,
			"dateRdv":date,
			"heureRdv":heure,
			"etatRdv":"En_Attente"
			
		}),
		error: function(e) {
		    console.log(e);
		  },
		dataType: "json",
		contentType: "application/json",
		success: function(data){
			
			}
		})
}
/*****************************************pupup apparition function*********************/
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