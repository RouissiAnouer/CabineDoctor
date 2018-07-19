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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="bilan")
public class Bilan implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idBilan")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBilan;
	
	@Column(name="libelleBilan")
	private String libelleBilan;
	
	@Column(name="dateBilan")
	private Date dateBilan;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	//@JsonIgnore
	private Patient patient;
	
	public Bilan() {
		
	}


	public Bilan(int idBilan, String libelleBilan, Date dateBilan) {
		this.idBilan = idBilan;
		this.libelleBilan = libelleBilan;
		this.dateBilan = dateBilan;
	}


	public int getIdBilan() {
		return idBilan;
	}


	public void setIdBilan(int idBilan) {
		this.idBilan = idBilan;
	}


	public String getLibelleBilan() {
		return libelleBilan;
	}


	public void setLibelleBilan(String libelleBilan) {
		this.libelleBilan = libelleBilan;
	}


	public Date getDateBilan() {
		return dateBilan;
	}


	public void setDateBilan(Date dateBilan) {
		this.dateBilan = dateBilan;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
