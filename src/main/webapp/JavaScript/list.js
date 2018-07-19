/**
 * 
 */
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

	    	    /* Verification to add the last decimal 0 */
	    	    

	    	    /* Must not forget the $ sign */
	    	    tr += "<td>" + obj[i].nom + "</td><td>" + obj[i].prenom + "</td><td>"+ obj[i].sexe + "</td><td>" + obj[i].login + "</td>" + "<td>" + obj[i].pwd + "</td>" + "<td>" + obj[i].tel + "</td>" + "<td>" + obj[i].dateNaiss + "<td>" + obj[i].cin + "</td>" + "<td>" + obj[i].dossier + "</td>" + "<td>" + obj[i].etatUser + "</td>" + "<td><input type='button'  value='Supprimé' onclick='suprime("+obj[i].idUtilisateur+")'></td>" + "<td><input type='button' value='Modifié' onclick='update("+obj[i].idUtilisateur+",\""+ obj[i].login + "\",\""+ obj[i].pwd + "\",\""+obj[i].tel+"\",\""+obj[i].dateNaiss+"\",\""+obj[i].dossier+"\",\""+obj[i].cin+"\",\""+obj[i].nom+"\",\""+obj[i].prenom+"\",\""+obj[i].etatUser+"\",\""+obj[i].sexe+"\")'></td></tr>";
	    	    
	    	    /* We add the table row to the table body */
	    	    tbody.innerHTML += tr;
	    	}
	    	/*$(function () {
	    	    //Loop through all Labels with class 'editable'.
	    	    $(".editable").each(function () {
	    	        //Reference the Label.
	    	        var label = $(this);
	    	 
	    	        //Add a TextBox next to the Label.
	    	        label.after("<input type = 'text' style = 'display:none' />");
	    	        
	    	       
	    	        //Reference the TextBox.
	    	        var textbox = $(this).next();
	    	        
	    	        //Set the name attribute of the TextBox.
	    	        textbox[0].name = this.id.replace("lbl", "txt");
	    	 
	    	        //Assign the value of Label to TextBox.
	    	        textbox.val(label.html());
	    	 
	    	        //When Label is clicked, hide Label and show TextBox.
	    	        label.click(function () {
	    	            $(this).hide();
	    	            $(this).next().show();
	    	        });
	    	 
	    	        //When focus is lost from TextBox, hide TextBox and show Label.
	    	        textbox.focusout(function () {
	    	        	
	    	            $(this).hide();
	    	            $(this).prev().html($(this).val());
	    	            $(this).prev().show();
	    	          //  $(document).ready(update($(this).val()));
	    	           
	    	        });
	    	        
	    	    });
	    	    
	    	});*/
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

var update = function(id,login,pwd,tel,date,dossier,cin,nom,prenom,etat,sexe){
	var modal = document.getElementById('myModal');

	// Get the button that opens the modal
	
	modal.style.display = "block";
	$("#input1").val(id);
	$("#input2").val(login);
	$("#input3").val(pwd);
	$("#input4").val(tel);
	$("#input5").val(dossier);
	$("#input6").val(cin);
	$("#input7").val(nom);
	$("#input8").val(prenom);
	$("#input11").val(sexe);
	$("#input9").val(etat);
	$("#input10").val(date);
	
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
	        var nom=document.getElementById("input7").value;
	    	var prenom=document.getElementById("input8").value;
	    	var sexe=document.getElementById("input11").value;
	    	var cin=document.getElementById("input6").value;
	    	var tel=document.getElementById("input4").value;
	    	var dossier=document.getElementById("input5").value;
	    	var dateNaiss=document.getElementById("input10").value;
	    	var login=document.getElementById("input2").value;
	    	var pwd=document.getElementById("input3").value;
	    	var id=document.getElementById("input1").value;
	    	var etatUser=document.getElementById("input9").value;
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
	    			"dateNaiss":dateNaiss,
	    			"login":login,
	    			"pwd":pwd,
	    			"etatUser":etatUser
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

/*var modifier = function(id,nom,prenom,sexe,cin,tel,dossier,date,login,pwd,role){
	var nom=document.getElementById("input7").value;
	var prenom=document.getElementById("input8").value;
	var sexe=document.getElementById("input11").value;
	var cin=document.getElementById("input6").value;
	var tel=document.getElementById("input4").value;
	var dossier=document.getElementById("input5").value;
	var dateNaiss=document.getElementById("input10").value;
	var login=document.getElementById("input2").value;
	var pwd=document.getElementById("input3").value;
	var id=document.getElementById("input1").value;
	var etatUser=document.getElementById("input9").value;
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
			"dateNaiss":dateNaiss,
			"login":login,
			"pwd":pwd,
			"etatUser":etatUser
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
*/
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
	
	
	
	
	
	
	
	
	
	
