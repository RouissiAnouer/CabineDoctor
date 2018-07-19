$(document).ready(getall());
function getall(){
    var url ="webapi/utilisateur/getall";
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

	    	    tr += "<td>" + obj[i].nom + "</td><td>" + obj[i].prenom +
	    	    "</td><td>"+ obj[i].sexe + "</td><td>" + obj[i].tel + 
	    	    "</td>" + "<td>" + obj[i].dateNaiss + "<td>" + obj[i].cin + 
	    	    "</td>" + "<td>" + obj[i].dossier +"</td><td>" + 
	    	    "<div style='display:inline-block;'>"+
                "<a href='#' onclick='update("+obj[i].idUtilisateur+",\""+obj[i].tel+"\",\""+obj[i].dateNaiss+"\",\""+obj[i].dossier+"\",\""+obj[i].cin+"\",\""+obj[i].nom+"\",\""+obj[i].prenom+"\",\""+obj[i].sexe+"\")'><span class='glyphicon glyphicon-pencil' title='Modifier'></span></a></div><div style='display:inline-block;'><a href='#' onclick='suprime("+obj[i].idUtilisateur+")'><span class='glyphicon glyphicon-trash' title='Supprimer'></span></a></div><div style='display:inline-block;'><a href='#'  onclick='detail("+obj[i].idUtilisateur+")'><span class='glyphicon glyphicon-info-sign' title='Details'></span></a></div></td></tr>";
	    	    tbody.innerHTML += tr;
	    	}
	    	
	    }
    })
    
}
/*****************************************supprimer************************/
var suprime = function(id){
	var url = "webapi/patient/getone?id="+id;
	$.ajax({
	    type: "GET",
	    url: url,
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	   
	      success: function (data) {
	    	
	    		  $(document).ready(supp(data));
	      
	    }
		
	})	
}	

var supp = function(data){
	var url ="webapi/patient/delete";
    $.ajax({
		type:"DELETE",
		url:url,
		data:JSON.stringify(data),
		dataType: "json",
		contentType: "application/json",
		success: function(data){
			window.location = "./list_patient.html"
			}

		})
}
	
	
/**********************************************update***************************/
var update = function(id,tel,date,dossier,cin,nom,prenom,sexe){
	var modal = document.getElementById('myModal');
	// Get the button that opens the modal
	modal.style.display = "block";
	$("#input1").val(nom);
	$("#input2").val(prenom);
	$("#input3").val(cin);
	$("#input4").val(sexe);
	$("#input5").val(date);
	$("#input6").val(tel);
	$("#input7").val(dossier);
	
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
	        var nom=document.getElementById("input1").value;
	    	var prenom=document.getElementById("input2").value;
	    	var sexe=document.getElementById("input4").value;
	    	var cin=document.getElementById("input3").value;
	    	var tel=document.getElementById("input6").value;
	    	var dossier=document.getElementById("input7").value;
	    	var dateNaiss=document.getElementById("input5").value;
	    	var url="webapi/patient/updatepatient";
	    	$.ajax({
	    		type:"POST",
	    		url:url,
	    		data:JSON.stringify({
	    			"idUtilisateur":id,
	    			"nom":nom,
	    			"prenom":prenom,
	    			"sexe":sexe,
	    			"cin":cin,
	    			"tel":tel,
	    			"dossier":dossier,
	    			"dateNaiss":dateNaiss
	    		}),
	    		contentType:"application/json;charset=utf-8",
	    		dataType:"json",
	    		
	    		success: function () {
	    			var modal = document.getElementById('myModal');
	    			modal.style.display = "none";
	    			location.reload();
	      }
	    		
	    	})
	    }
	}	
}
/****************************************************detail de patient********************/
var detail = function(id){
	var url = "webapi/patient/getone?id="+id;
	$.ajax({
	    type: "GET",
	    url: url,
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	   
	      success: function (data) {
	    	
	    	  document.location.href="http://localhost:8080/GestionCabinet/details_patient.html?id="+id;
	      
	    }
		
	})	
}	
/************************************************recherche*************************************/
function myFunction() {
	  // Declare variables 
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}

var saveuser = function(nom,prenom,sexe,cin,tel,date,login,pwd){
	var nom=document.getElementById("nom").value;
	var prenom=document.getElementById("prenom").value;
	var sexe=document.getElementById("sexe").value;
	var cin=document.getElementById("cin").value;
	var tel=document.getElementById("tel").value;
	var dateNaiss=document.getElementById("date").value;
	var login=document.getElementById("login").value;
	var pwd=document.getElementById("pwd").value;
	var url="webapi/patient/savepatient";
		$.ajax({
		type:"POST",
		url:url,
		data:JSON.stringify({
			"nom":nom,
			"prenom":prenom,
			"sexe":sexe,
			"cin":cin,
			"tel":tel,
			"dateNaiss":dateNaiss,
			"login":login,
			"pwd":pwd
			
		}),
		error: function(e) {
		    console.log(e);
		  },
		dataType: "json",
		contentType: "application/json",
		success: function(data){
			window.location="./list_patient.html"
			
			}

		})
}


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

