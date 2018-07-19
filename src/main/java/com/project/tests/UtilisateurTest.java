package com.project.tests;



import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entities.Utilisateur;
import com.project.types.Roles;






public class UtilisateurTest {

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
			session.save(user);
			session.getTransaction().commit();
			System.out.println("Done!!!");
			//ffafaffafaff
		}
		finally{
			session.close();
			factory.close();
		}


	}

}
