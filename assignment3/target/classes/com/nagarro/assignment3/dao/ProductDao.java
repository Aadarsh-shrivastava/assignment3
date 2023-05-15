package com.nagarro.assignment3.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.assignment3.Entities.Product;

public class ProductDao {
	private SessionFactory factory;

	public ProductDao(SessionFactory factory) {

		this.factory = factory;
	}

	public boolean saveProduct(Product product) {
		boolean f = false;

		try {

			Session session = this.factory.openSession();
			Transaction tx = session.beginTransaction();

			session.saveOrUpdate(product);
			f = true;

			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			f = false;
		}
		return f;

	}

	public void removeProduct(int id) {
		Session s = this.factory.openSession();
		Transaction tx = s.beginTransaction();

		// delete object with primary key
		Query theQuery = s.createQuery("delete from Product where id=" + id);

		
		theQuery.executeUpdate();
		tx.commit();
		s.close();

	}
	
	public List<Product> listAllProducts(){
		String hql="from Product";
		Session s = this.factory.openSession();
		Query query=s.createQuery(hql);
		List<Product> list=query.list();
		s.close(); 
		return list;
		
	}
	

	
}
