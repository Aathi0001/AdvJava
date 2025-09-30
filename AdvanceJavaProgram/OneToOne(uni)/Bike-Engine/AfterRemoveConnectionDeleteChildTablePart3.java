package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AfterRemoveConnectionDeleteChildTablePart3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Engine e = em.find(Engine.class, "SK920348SD32990");

		et.begin();
		em.remove(e);
		et.commit();
		
		System.out.println("Data Saved");
	}
}
