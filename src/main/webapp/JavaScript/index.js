/**
 * 
 * $(document).ready(getall());
function getall(){
    var url ="webapi/utilisateur/getall";
    $.ajax({
    	type:"GET",
    	url:url,
    	contentType:"application/json; charset=utf-8",
	    dataType: "json",
	    success: function (data) {
	    	$('#CIN').text(data.cin)
	    }
    })
    
}
 */









var authentifier = function(login,pwd){
	var loginin=document.getElementById("loginin").value;
	var pwdin=document.getElementById("pwdin").value;
	
	var url = "webapi/utilisateur/connexion?login="+loginin+"&pwd="+pwdin;
	$.ajax({
	    type: "GET",
	    url: url,
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	   
	      success: function (data) {
	    	  if(data == null){
	    		  alert("enregistrer vous!!!")
	    		  
	    	  }else{
	    		  if(data.role=="Patient")
	    			  document.location.href="http://localhost:8080/GestionCabinet/profil_patient.html?id="+data.idUtilisateur;
	    		  else if(data.role=="Docteur")
	    			  document.location.href="http://localhost:8080/GestionCabinet/profil_docteur.html";
	    		  else
	    			  document.location.href="http://localhost:8080/GestionCabinet/profil_secretaire.html";
	    }}
		
	})
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
			
			}

		})
}