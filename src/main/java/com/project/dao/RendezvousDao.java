package com.project.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entities.Patient;
import com.project.entities.RendezVous;
import com.project.types.EtatRDV;



@SuppressWarnings({ "deprecation", "rawtypes","unchecked" })

public class RendezvousDao {
	/******************************************************adding rendez vous*********************/
		public void addRendezVous(RendezVous rendezVous) {
			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(RendezVous.class)
					.buildSessionFactory();
			Session session=factory.openSession();
			rendezVous.setEtatRdv(EtatRDV.En_Attente);
			session.beginTransaction();
			session.save(rendezVous);
			session.getTransaction().commit();
			session.close();
		}
	/***************************************************demander rendez vous ********************/	
		public void addRendezVousAndroid(String date, String heure, String idPatient) {
			RendezVous rendezVous=new RendezVous();
			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(RendezVous.class)
					.buildSessionFactory();
			Session session=factory.openSession();
			rendezVous.setEtatRdv(EtatRDV.En_Attente);
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
			DateFormat df2 = new SimpleDateFormat("hh:mm");
			Date daterdv=new Date();
			Date heurerdv=new Date();
			try {
			    daterdv = df.parse(date);
			    heurerdv=df2.parse(heure);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			Long id=Long.parseLong(idPatient, 10);
			PatientDao pd=new PatientDao();
			rendezVous.setDateRdv(daterdv);
			rendezVous.setHeureRdv(heurerdv);
			rendezVous.setPatient(pd.getone(id));
			session.beginTransaction();
			session.save(rendezVous);
			session.getTransaction().commit();
			session.close();
		}
	/**********************************************************update rendez vous************************/
		public void UpdateRendezVous(RendezVous rendezVous){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(RendezVous.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		RendezVous myrendezVous=session.get(RendezVous.class, rendezVous.getIdRdv());
		myrendezVous.setDateRdv(rendezVous.getDateRdv());
		myrendezVous.setHeureRdv(rendezVous.getHeureRdv());
		session.getTransaction().commit();
		session.close();
	}
	/********************************************************delete rendez vous**************************/
	public void DeleteRendezVous(int id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(RendezVous.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		RendezVous rendezVous=session.get(RendezVous.class, id);
		session.delete(rendezVous);
		session.getTransaction().commit();
		session.close();
	}
	/**********************************************************get all rendez vous***********************/
	public List<RendezVous> getall() {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(RendezVous.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from RendezVous");
		List<RendezVous>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }       
        return list;        
	}
	/****************************************************get rendez vous by patient******************/
	public List<RendezVous> getByPatient(Long id) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(RendezVous.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from RendezVous where idUtilisateur= :id");
		query.setParameter("id", id);
		List<RendezVous>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }       
        return list;        
	}
	/*********************************************************validate rendez vous********************/
	public void valider(int id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(RendezVous.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		RendezVous rendezVous=session.get(RendezVous.class, id);
		rendezVous.setEtatRdv(EtatRDV.Valide);	
        session.getTransaction().commit();
        session.close();
	}
	/*******************************************************refusing rendez vous******************/
	public void refuser(int id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(RendezVous.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		RendezVous rendezVous=session.get(RendezVous.class, id);
		rendezVous.setEtatRdv(EtatRDV.Refuse);	
        session.getTransaction().commit();
        session.close();
	}	
}
