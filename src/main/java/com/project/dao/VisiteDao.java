package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entities.Visite;

@SuppressWarnings({ "deprecation", "rawtypes","unchecked" })
public class VisiteDao {
	/************************ ADD Visite*********************/
	public void addVisite(Visite visite) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Visite.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(visite);
		session.getTransaction().commit();
		session.close();
	}
	/************************ Display all Visite for patient*********************/
	public Visite displayVisite(Long id) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Visite.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Visite where idUtilisateur= :id");
        query.setParameter("id",id);
		List<Visite>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
        return list.get(0);        
      	}
	/********search by id************/
	public Visite getone(Long id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Visite.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Visite where idVisite= :id");
        query.setParameter("id",id);
		List<Visite>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
        return list.get(0);        
	}
	/***************DELETE**************/
	public void DeleteVisite(Visite visite){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Visite.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		session.delete(visite);
		session.getTransaction().commit();
		session.close();
	}
	/*******************************Modification d'une Visite****/
	public void UpdateVisite(Visite visite){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Visite.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		Visite myvisite=session.get(Visite.class, visite.getIdVisite());
		myvisite.setDateVisite(visite.getDateVisite());
		myvisite.setHeureVisite(visite.getHeureVisite());
		myvisite.setMotifVisite(visite.getMotifVisite());
		myvisite.setPatient(visite.getPatient());
		session.getTransaction().commit();
		session.close();
	}

}
