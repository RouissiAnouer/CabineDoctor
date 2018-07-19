package com.project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.project.types.EtatRDV;

@XmlRootElement
@Entity
@Table(name="rendez_vous")
public class RendezVous implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idRdv")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRdv;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateRdv")
	private Date dateRdv;
	
	@Temporal(TemporalType.TIME)
	@Column(name="heureRdv")
	private Date heureRdv;
	
	@Enumerated(EnumType.STRING)
	@Column(name="etatRdv")
	private EtatRDV etatRdv;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	//@JsonIgnore
	private Patient patient;

	public RendezVous() {
		
	}

	public RendezVous(int idRdv, Date dateRdv, Date heureRdv, EtatRDV etatRdv) {
		super();
		this.idRdv = idRdv;
		this.dateRdv = dateRdv;
		this.heureRdv = heureRdv;
		this.etatRdv = etatRdv;
	}

	public int getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(int idRdv) {
		this.idRdv = idRdv;
	}

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public Date getHeureRdv() {
		return heureRdv;
	}

	public void setHeureRdv(Date heureRdv) {
		this.heureRdv = heureRdv;
	}

	public EtatRDV getEtatRdv() {
		return etatRdv;
	}

	public void setEtatRdv(EtatRDV etatRdv) {
		this.etatRdv = etatRdv;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	

}
