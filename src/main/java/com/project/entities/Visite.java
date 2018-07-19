package com.project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="visite")
public class Visite implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idVisite")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVisite;
	
	@Column(name="motifVisite")
	private String motifVisite;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateVisite")
	private Date dateVisite;
	
	@Temporal(TemporalType.TIME)
	@Column(name="heureVisite")
	private Date heureVisite;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	//@JsonIgnore
	private Patient patient;
	

	public Visite() {
		
	}
	


	public Visite(int idVisite, String motifVisite, Date dateVisite, Date heureVisite) {
		this.idVisite = idVisite;
		this.motifVisite = motifVisite;
		this.dateVisite = dateVisite;
		this.heureVisite = heureVisite;
	}





	public int getIdVisite() {
		return idVisite;
	}


	public void setIdVisite(int idVisite) {
		this.idVisite = idVisite;
	}


	public String getMotifVisite() {
		return motifVisite;
	}


	public void setMotifVisite(String motifVisite) {
		this.motifVisite = motifVisite;
	}



	public Date getDateVisite() {
		return dateVisite;
	}



	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}



	public Date getHeureVisite() {
		return heureVisite;
	}



	public void setHeureVisite(Date heureVisite) {
		this.heureVisite = heureVisite;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	

	
	
	
	

}
