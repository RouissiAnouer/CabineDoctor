package com.project.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entities.Patient;
import com.project.entities.Utilisateur;
@SuppressWarnings({ "deprecation", "rawtypes","unchecked" })
public class TestExtending {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();		
		Query query=session.createQuery("from Patient");
		List<Patient>list=query.list();
		list.get(0);
		System.out.println(list.get(0).getCin());
        session.getTransaction().commit();
        session.close();

	}

}
