package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertData {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Capital cp1 = new Capital(1, "New Delhi");
		
		Country co1 = new Country(1, "India", cp1);
		
		Capital cp2 = new Capital(2, "Tokyo");
		
		Country co2 = new Country(2, "Japan", cp2);
		
		Capital cp3 = new Capital(3, "Paris");
		
		Country co3 = new Country(3, "France", cp3);
		
		Capital cp4 = new Capital(4, "London");
		
		Country co4 = new Country(4, "United Kingdom", cp4);
		
		
		et.begin();
		em.persist(cp1);
		em.persist(co1);
		em.persist(cp2);
		em.persist(co2);
		em.persist(cp3);
		em.persist(co3);
		em.persist(cp4);
		em.persist(co4);
		et.commit();
		
		System.out.println("Data Saved");
		
				
	}
}
