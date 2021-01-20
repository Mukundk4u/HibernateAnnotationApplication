package com.csi.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {
	
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//saveProductData();
		deleteProdcutData(3);
		getProductData();
		//updateProductData(4);
	}

	
	public static void saveProductData() {
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product p1 = new Product();
		p1.setProdcutName("HP Laptop");
		p1.setProductPrice(2142471.24);
		
		session.save(p1);
		transaction.commit();
		
	}
	
	public static void getProductData() {
		Session session = factory.openSession();
		
		List<Product> productList = session.createQuery("from Product").list();
		productList.forEach(System.out::println);
		
	}
	
	public static void updateProductData(int productId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List<Product> pList = session.createQuery("from Product").list();
		
		for(Product product : pList) {
			if(product.getProductId() == productId)
			{
				product.setProdcutName("Lenvo Laptop");
				product.setProductPrice(89978678.99);
			
				session.update(product);
				transaction.commit();
			}
		}	
	}
	
	public static void deleteProdcutData(int productId) {
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List<Product> pList = session.createQuery("from Product").list();
		
		for(Product product : pList) {
			if(product.getProductId() == productId)
			{
				session.delete(product);
				transaction.commit();
			}
		}
		
	}
}
