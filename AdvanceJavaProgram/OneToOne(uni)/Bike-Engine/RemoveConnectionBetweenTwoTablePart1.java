package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RemoveConnectionBetweenTwoTablePart1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Bike b = em.find(Bike.class, "TN05AA0001");
		b.setEngine(null);
		
		et.begin();
		em.merge(b);
		et.commit();
		
		System.out.println("Data Saved");
	}

}
