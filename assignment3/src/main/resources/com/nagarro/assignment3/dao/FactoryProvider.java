package com.nagarro.assignment3.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.assignment3.Entities.Product;
import com.nagarro.assignment3.Entities.User;

public class FactoryProvider {
	private static SessionFactory userfactory;
	private static SessionFactory productfactory;

	public static SessionFactory Productfactory() {
		try {
			if (productfactory == null) {
				productfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
						.buildSessionFactory();
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productfactory;

	}

	public static SessionFactory Userfactory() {
		try {
			if (userfactory == null) {
				userfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
						.buildSessionFactory();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return userfactory;

	}
}
