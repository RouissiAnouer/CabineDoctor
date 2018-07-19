package com.project.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.project.dao.VisiteDao;
import com.project.entities.Visite;

@Path("visite")
public class VisiteWS {
	
	private VisiteDao nouveau=new VisiteDao();
	@Path("savevisite")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void addvisitews(Visite visite)
	{  
		nouveau.addVisite(visite);
		}
	@Path("displayVisite")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Visite displayVisitews(@QueryParam("id") Long id){
		return nouveau.displayVisite(id);
	} 
	
	
	@Path("getone")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Visite getonews(@QueryParam("id") Long id){
		return nouveau.getone(id);
	} 
	
	@Path("delete")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deletevisitews(Visite visite)
	{  
		nouveau.DeleteVisite(visite);
		}
	

}
