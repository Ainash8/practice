package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.annotation.Student;

public class ReadingData {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration()
							.configure("resources/hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			System.out.println("begin....");
			Student st = new Student("Vijay","vanga","vijay.vanga@gmail.com");
			session.beginTransaction();
			System.out.println("Saving data");
			System.out.println(st);
			 session.save(st);
			session.getTransaction().commit();
			Thread.sleep(5000);
			
			System.out.println("Saved record with id "+st.getId());
			
			session = sf.getCurrentSession();
			session.beginTransaction();
			System.out.println("\nGetting student record with id: "+st.getId());
			Student mystudent =session.get(Student.class,st.getId());
			System.out.println("\nRecord: "+mystudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			sf.close();
		}

	}

}
