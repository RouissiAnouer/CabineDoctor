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
import com.project.types.EtatCompte;
import com.project.types.Roles;


@SuppressWarnings({ "deprecation", "rawtypes","unchecked" })
public class PatientDao {
/************************ ADD Patient*********************/
	public void savepatient(Patient patient) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		patient.setRole(Roles.Patient);
		patient.setEtatUser(EtatCompte.Deconnecte);
		session.beginTransaction();
		session.save(patient);
		session.getTransaction().commit();
		session.close();
	}
	/************************ ADD Patient*********************/
	public void addpatient(String nom,String prenom,String cin,String dateNaiss,String login,
			String pwd,String tel,String sexe) {
		Patient patient=new Patient();
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		patient.setNom(nom);
		patient.setPrenom(prenom);
		patient.setCin(Integer.parseInt(cin));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        try {
            date = df.parse(dateNaiss);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		patient.setDateNaiss(date);
		patient.setLogin(login);
		patient.setPwd(pwd);
		patient.setTel(Integer.parseInt(tel));
		patient.setSexe(sexe);
		patient.setRole(Roles.Patient);
		patient.setEtatUser(EtatCompte.Deconnecte);
		session.beginTransaction();
		session.save(patient);
		session.getTransaction().commit();
		session.close();
	}
	/********************************************get patient  by id************/
	public Patient getone(Long id){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Utilisateur where idUtilisateur= :id");
        query.setParameter("id",id);
		List<Patient>list=query.list();
        session.getTransaction().commit();
        session.close();
        if(list.isEmpty()){
        	return null;
	    }
        return list.get(0);        
	}
	/***************DELETE patient **********************************************/
	public void DeletePatient(Patient patient){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		session.delete(patient);
		session.getTransaction().commit();
		session.close();
	}
	
	/*****************Update patient*************************************************************/
	public void UpdatePatient(Patient patient){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();	
		Patient myPatient=session.get(Patient.class, patient.getIdUtilisateur());
		myPatient.setCin(patient.getCin());
		myPatient.setDateNaiss(patient.getDateNaiss());
		myPatient.setDossier(patient.getDossier());
		
	
		myPatient.setNom(patient.getNom());
		myPatient.setPrenom(patient.getPrenom());
		
		myPatient.setSexe(patient.getSexe());
		myPatient.setTel(patient.getTel());
		session.getTransaction().commit();
		session.close();
	}
	
	/******************************Authentification********************/
	public Patient Connexion(String login, String pwd){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Patient where pwd= :pwd and login= :login");
        query.setParameter("pwd",pwd);
        query.setParameter("login", login);
		List<Patient>list=query.list();
        if(!(list.isEmpty())){
        	list.get(0).setEtatUser(EtatCompte.Connecte);
        	session.getTransaction().commit();
        	session.close();
        	return list.get(0); 
        	
	    }
        session.getTransaction().commit();
    	session.close();
        return null;       
	}	
	/********************************Deconnexion*******************/
	public void deconnexion(Patient patient){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
        patient.setEtatUser(EtatCompte.Deconnecte);	
        session.getTransaction().commit();
        session.close();
	}
}
