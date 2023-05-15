package com.nagarro.assignment3.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.assignment3.Entities.Product;
import com.nagarro.assignment3.Entities.User;

public class UserDao {
	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		this.factory = factory;
	}

	// getuser by email and password
	public boolean saveUser(User user) {
		boolean f=false;
		try {

			Session session = this.factory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(user);
			f = true;

			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			f = false;
		}
		return f;
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;
		try {

			String query = "FROM User WHERE email=:e and password=:p";
			Session session = this.factory.openSession();
			Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			user = (User) q.uniqueResult();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;

	}
	
	public List<User> listAllUsers(){
		String hql="FROM User";
		Session s = this.factory.openSession();
		Query query=s.createQuery(hql);
		List<User> list=query.list();
		System.out.println(list);
		s.close();
		return list;
	}}
