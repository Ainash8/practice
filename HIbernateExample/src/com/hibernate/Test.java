package com.hibernate;

import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		cfg.buildSessionFactory();
	}

}
