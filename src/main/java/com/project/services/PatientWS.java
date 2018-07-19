package com.project.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.project.dao.PatientDao;
import com.project.entities.Patient;
@Path("patient")
public class PatientWS {
	private PatientDao nouveau = new PatientDao();
	/******************************************Service Add patient**********************/
	@Path("savepatient")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void savepatientws(Patient patient)
	{  
		nouveau.savepatient(patient);
	}
	/******************************************Service Add patient using pathParam**********************/
	@Path("addpatient/{nom}/{prenom}/{cin}/{dateNaiss}/{login}/{pwd}/{tel}/{sexe}")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void addpatientws(@PathParam("nom")String nom,@PathParam("prenom")String prenom,
			@PathParam("cin")String cin,@PathParam("dateNaiss")String dateNaiss,
			@PathParam("login")String login,@PathParam("pwd")String pwd,@PathParam("tel")String tel,
			@PathParam("sexe")String sexe)
	{  
		nouveau.addpatient(nom,prenom,cin,dateNaiss,login,pwd,tel,sexe);
	}
	/********************************************Service update patient*******************/
	@Path("updatepatient")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void updatepatientws(Patient patient)
	{  
		nouveau.UpdatePatient(patient);
	}
	/*******************************************Service get one patient by id*******************/
	@Path("getone")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Patient getonews(@QueryParam("id") Long id){
		return nouveau.getone(id);
	} 
	/***********************************************Service delete patient************************/
	@Path("delete")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deletepatientws(Patient patient)
	{  
		nouveau.DeletePatient(patient);
	}
	/*****************************************Service login*****************/
	@Path("connexion")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Long androidConnect(@QueryParam("login") String login,@QueryParam("pwd") String pwd){
		return nouveau.Connexion(login, pwd).getIdUtilisateur();
	} 
	/***************************************Service logout*********************/
	@Path("deconnexion")
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deconnexionws(Patient patient){
		nouveau.deconnexion(patient);
	}
}
