package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entities.Bilan;

@SuppressWarnings({ "deprecation", "rawtypes","unchecked" })
public class BilanDao {
	/************************ ADD Bilan*********************/
	public void addBilan(Bilan bilan) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Bilan.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(bilan);
		session.getTransaction().commit();
		session.close();
	}
	/********search all bilan for patient************/
	public Bilan displayBilan(Long id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Bilan.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Bilan where idUtilisateur= :id");
        query.setParameter("id",id);
		List<Bilan>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
        return list.get(0);        
	}
	/********search by id************/
	public Bilan getone(Long id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Bilan.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Bilan where idBilan= :id");
        query.setParameter("id",id);
		List<Bilan>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
        return list.get(0);        
	}
	/***************DELETE**************/
	public void DeleteBilan(Bilan bilan){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Bilan.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		session.delete(bilan);
		session.getTransaction().commit();
		session.close();
	}
	/*******************************Modification d'un bilan****/
	public void UpdateBilan(Bilan bilan){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Bilan.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		Bilan mybilan=session.get(Bilan.class, bilan.getIdBilan());
		mybilan.setLibelleBilan(bilan.getLibelleBilan());
		mybilan.setDateBilan(bilan.getDateBilan());
		mybilan.setPatient(bilan.getPatient());
		session.getTransaction().commit();
		session.close();
	}

}
