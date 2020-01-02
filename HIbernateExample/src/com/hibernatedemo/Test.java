package com.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.annotation.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration()
							.configure("resources/hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			System.out.println("begin....");
			Student st = new Student("Shailesh","Yadav","Shailesh.yadav@gmail.com");
			session.beginTransaction();
			System.out.println("Saving data");
			session.save(st);
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			sf.close();
		}

	}

}
