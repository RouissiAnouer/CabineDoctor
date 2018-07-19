package com.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.project.types.EtatCompte;
import com.project.types.Roles;


@XmlRootElement
@Entity
@Table(name="patient")
public class Patient extends Utilisateur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUtilisateur")
	private  Long idUtilisateur;
	
	@Column(name="login")
	private String login;
	
	@Column(name="pwd")
	private String pwd;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Roles role;
	
	@Enumerated(EnumType.STRING)
	@Column(name="etatUser")
	private EtatCompte etatUser;
	
	@Column(name="cin")
	private int cin;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="sexe")
	private String sexe;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateNaiss")
	private Date dateNaiss;
	
	@Column(name="tel")
	private int tel;
	
	@Column(name="dossier")
	private String dossier;
	
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="Patient_Bilan",joinColumns=@JoinColumn(name="idUtilisateur"),
	inverseJoinColumns=@JoinColumn(name="idBilan"))
	private List<Bilan>bilans=new ArrayList<Bilan>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="Patient_RendezVous",joinColumns=@JoinColumn(name="idUtilisateur"),
	inverseJoinColumns=@JoinColumn(name="idRdv"))
	private List<RendezVous>RDVs=new ArrayList<RendezVous>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="Patient_Visite",joinColumns=@JoinColumn(name="idUtilisateur"),
	inverseJoinColumns=@JoinColumn(name="idVisite"))
	private List<Visite>visites=new ArrayList<Visite>();
	
	public Patient() {
		super();
		
	}
	public Patient(int cin, String nom, String prenom, String sexe, Date dateNaiss, int tel, String dossier,
			Long idUtilisateur,String login, String pwd, Roles role, EtatCompte etatUser) {
		super(idUtilisateur,login,pwd,role,etatUser);
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaiss = dateNaiss;
		this.tel = tel;
		this.dossier = dossier;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getDossier() {
		return dossier;
	}
	public void setDossier(String dossier) {
		this.dossier = dossier;
	}
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public EtatCompte getEtatUser() {
		return etatUser;
	}
	public void setEtatUser(EtatCompte etatUser) {
		this.etatUser = etatUser;
	}
	public List<Bilan> getBilans() {
		return bilans;
	}
	public void setBilans(List<Bilan> bilans) {
		this.bilans = bilans;
	}
	public List<RendezVous> getRDVs() {
		return RDVs;
	}
	public void setRDVs(List<RendezVous> rDVs) {
		RDVs = rDVs;
	}
	public List<Visite> getVisites() {
		return visites;
	}
	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}
	
	

}
