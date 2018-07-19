package com.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.project.types.EtatCompte;
import com.project.types.Roles;
@XmlRootElement
@Entity
@Table(name="utilisateur")
public class Utilisateur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@Column(name="idUser")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long idUtilisateur;
	
	@Column(name="login")
	protected String login;
	
	@Column(name="pwd")
	protected String pwd;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	protected Roles role;
	
	@Enumerated(EnumType.STRING)
	@Column(name="etatUser")
	protected EtatCompte etatUser;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="Utilisateur_Message",joinColumns=@JoinColumn(name="idUtilisateur"),
	inverseJoinColumns=@JoinColumn(name="idMsg"))
	private List <Message>messages=new ArrayList<Message>();
	
	public Utilisateur() {
		
	}
	public Utilisateur(Long idUtilisateur, String login, String pwd, Roles role, EtatCompte etatUser) {
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.pwd = pwd;
		this.role = role;
		this.etatUser=etatUser;
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
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	

}
