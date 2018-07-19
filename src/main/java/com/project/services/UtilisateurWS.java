package com.project.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.project.dao.UtilisateurDao;
import com.project.entities.Utilisateur;

@Path("utilisateur")
public class UtilisateurWS {
	private UtilisateurDao user = new UtilisateurDao();
	
	/**********************************web service connexion**************/
	@Path("connexion")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Utilisateur connexionws(@QueryParam("login") String login,@QueryParam("pwd") String pwd){
		return user.Connexion(login, pwd);
	} 
	/**********************************web service deconnexion************/
	@Path("deconnexion")
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deconnexionws(Utilisateur utilisateur){
		user.deconnexion(utilisateur);
	}
	/************************************web service Ajout utilisateur*************/
	@Path("addUser")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void AddUtilisateurws(Utilisateur utilisateur){
		user.addUtilisateur(utilisateur);
		
	}
	/***********************************web service update utilisateur***********/
	@Path("updateUser")
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void UpdateUtilisateurws(Utilisateur utilisateur){
		user.UpdateUtilisateur(utilisateur);
	}
	/**************************************web service delete utilisateur***********/
	@Path("deleteUser")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void DeleteUtilisateurws(Utilisateur utilisateur){
		user.DeleteUtilisateur(utilisateur);
	}
	
	@Path("getall")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Utilisateur> getuserws(){
		return user.getall();
	} 
	

}
