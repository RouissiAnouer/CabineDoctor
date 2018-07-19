package com.project.tests;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entities.Message;
import com.project.entities.Patient;
import com.project.entities.RendezVous;
import com.project.entities.Utilisateur;
import com.project.types.EtatRDV;
import com.project.types.Roles;






public class HibernateTest {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		//create session factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try{
			//create  object
			System.out.println("creating a new Compte object...");
			//start a transaction
			session.beginTransaction();
			Utilisateur user=new Utilisateur();
			user.setLogin("admin");
			user.setPwd("admin");
			user.setRole(Roles.Docteur);
			Patient patient=new Patient();
			patient.setCin(12604330);
			Message msg1=new Message();
			msg1.setContenuMsg("content1");
			msg1.setUtilisateur(user);
			Message msg2=new Message();
			msg2.setUtilisateur(user);
			msg2.setContenuMsg("content2");
			RendezVous rdv1=new RendezVous();
			RendezVous rdv2=new RendezVous();
			rdv1.setEtatRdv(EtatRDV.En_Attente);
			rdv1.setPatient(patient);
			rdv2.setEtatRdv(EtatRDV.En_Attente);
			rdv2.setPatient(patient);
			//List messages=(List) new ArrayList<Message>();
			//messages.add(msg1);
			//messages.add(msg2);
			
			//patient.setMessages(messages);
			session.save(user);
			session.save(patient);
			session.save(rdv1);
			session.save(rdv2);
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}
		finally{
			session.close();
			factory.close();
		}


	}

}
