package com.project.services;

import java.util.List;

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

import com.project.dao.RendezvousDao;
import com.project.entities.RendezVous;

@Path("rendezvous")
public class RendezVousWS {
	private RendezvousDao rendezvous = new RendezvousDao() ;
	
	/************************************ajout d'un rendez vous*******************************/
	@Path("add")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void addrendezvousws(RendezVous rendezVous){  
		rendezvous.addRendezVous(rendezVous);
	}
	/**********************************************ajout d'un rendez vous par patient******************/
	@Path("addAndroid/{date}/{heure}/{idPatient}")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void addrendezvousAndroidws(@PathParam("date")String date, 
			@PathParam("heure")String heure, @PathParam("idPatient")String idPatient){  
		rendezvous.addRendezVousAndroid(date, heure,idPatient);
	}
	/***********************************************updating rendez vous********************************/
	@Path("update")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void Updaterendezvousws(RendezVous rendezVous){
		rendezvous.UpdateRendezVous(rendezVous);
	}
	/***************************************************deleting rendez vous***************************/
	@Path("delete")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void Deleterendezvousws(int id){
		rendezvous.DeleteRendezVous(id);
	}
	/*************************************************get all rendez vous****************************/
	@Path("getall")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<RendezVous> getrendezvousws(){
		return rendezvous.getall();
	} 
	/************************************************get rendez vous list by patient************/
	@Path("getByPatient")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<RendezVous> getByPatient(@QueryParam("id")Long id){
		return rendezvous.getByPatient(id);
	} 
	/*************************************************Validate rendez vous************************/
    @Path("valider")
    @GET
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void validerws(@QueryParam("id") int id){
	rendezvous.valider(id);
    }
    /***********************************************refusing rendez vous***************************/
    @Path("refuser")
    @GET
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void refusews(@QueryParam("id") int id){
	rendezvous.refuser(id);
    }
    /**********************************************************************************************/
    
}
