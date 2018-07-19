/**
 * 
 */
$(document).ready(getall());
function getall(){
    var url ="webapi/Bilan/getone";
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
	    	    tr += "<td>" + obj[i].datebilan + "</td><td>" + obj[i].libelleBilan + "</td><td>" + obj[i].patient + "</td>"+ "<td><input type='button' class='btn btn-sm btn-danger' value='Supprimé' onclick='suprime("+obj[i].idBilan+")'></td></tr>";
	    	    
	    	    /* We add the table row to the table body */
	    	    tbody.innerHTML += tr;
	    	}
	    }
    })
    
}

function myFunctionBilan() {
	  // Declare variables 
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTableBilan");
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

var update = function(id){
	alert(id)
}


var suprime = function(id){
	var url = "webapi/bilan/getone?id="+id;
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
	var url ="webapi/bilan/delete";
    $.ajax({
		type:"DELETE",
		url:url,
		data:JSON.stringify(data),
		dataType: "json",
		contentType: "application/json",
		success: function(data){
			window.location = "./bilan.html"
			}

		})
}
	
