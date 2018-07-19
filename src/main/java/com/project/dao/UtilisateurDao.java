package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.types.EtatCompte;
import com.project.entities.Utilisateur;


/*creer une fonction de criptage de mot de passe puis utiliser 
 dans l'ajout et l'update de l'utilisater*/

@SuppressWarnings({ "deprecation", "rawtypes","unchecked" })
public class UtilisateurDao {
	
	/*****************************Ajout d'un utilisateur***********************/
	public void addUtilisateur(Utilisateur user){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	/******************************Authentification********************/
	public Utilisateur Connexion(String login, String pwd){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Utilisateur where pwd= :pwd and login= :login");
        query.setParameter("pwd",pwd);
        query.setParameter("login", login);
		List<Utilisateur>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
        return list.get(0);        
	}
	
	
	
	/********************************Deconnexion*******************/
	public void deconnexion(Utilisateur user){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
        user.setEtatUser(EtatCompte.Deconnecte);	
        session.getTransaction().commit();
        session.close();
	}
	/*******************************Modification d'un utilisateur****/
	public void UpdateUtilisateur(Utilisateur user){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		Utilisateur myUser=session.get(Utilisateur.class, user.getIdUtilisateur());
		myUser.setLogin(user.getLogin());
		myUser.setPwd(user.getPwd());
		myUser.setRole(user.getRole());
		session.getTransaction().commit();
		session.close();
	}
	/*********************************Suppression d'un utilisateur**************/
	public void DeleteUtilisateur(Utilisateur user){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}
	
	/**********************************Get ALL********************************/
	public List<Utilisateur> getall() {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Utilisateur where role='Patient'");
		List<Utilisateur>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
       // Collection<Utilisateur> collection; 
		
        return list;        
	 	
	}

}
