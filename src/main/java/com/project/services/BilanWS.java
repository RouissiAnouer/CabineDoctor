package com.project.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.project.dao.BilanDao;
import com.project.entities.Bilan;

@Path("bilan")
public class BilanWS {

private BilanDao nouveau = new BilanDao();
	
	@Path("savebilan")
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void addbilanws(Bilan bilan)
	{  
		nouveau.addBilan(bilan);
		}
	
	@Path("displayBilan")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Bilan displayBilanws(@QueryParam("id") Long id){
		return nouveau.displayBilan(id);
	} 
	
	
	@Path("getone")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Bilan getonews(@QueryParam("id") Long id){
		return nouveau.getone(id);
	} 
	
	@Path("delete")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void deletebilanws(Bilan bilan)
	{  
		nouveau.DeleteBilan(bilan);
		}
	
}
