package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e =  new Engine();
		e.setEngine_no("SK920348SD32990");
		e.setCC(350);
		e.setStroke(4);
		e.setType("Petrol");
		
		
		Bike b = new Bike();
		b.setNo("TN05AA0001");
		b.setColor("Red");
		b.setPrice(200000);
		b.setBrand("RE");
		b.setModel("Classic 350");
		b.setEngine(e);
		
		et.begin();
		em.persist(b);
		em.persist(e);
		et.commit();
		
		System.out.println("Data Saved");
		
		
	}
}
