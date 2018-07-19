package com.project.entities;

import java.io.Serializable;

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
@Table(name="message")
public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idMsg")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMsg;
	
	@Column(name="contenuMsg")
	private String contenuMsg;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	//@JsonIgnore
	private Utilisateur utilisateur;
	
	public Message() {
	}
	
	
	public Message(int idMsg, String contenuMsg) {
		this.idMsg = idMsg;
		this.contenuMsg = contenuMsg;
	}


	public int getIdMsg() {
		return idMsg;
	}


	public void setIdMsg(int idMsg) {
		this.idMsg = idMsg;
	}


	public String getContenuMsg() {
		return contenuMsg;
	}


	public void setContenuMsg(String contenuMsg) {
		this.contenuMsg = contenuMsg;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
}
