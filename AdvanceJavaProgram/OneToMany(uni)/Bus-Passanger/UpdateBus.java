package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateBus{
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bus  b  = em.find(Bus.class, "TN01AD1234");
		
		b.setPrice(1500);
		
		et.begin();
		em.merge(b);
		et.commit();
		
		
		
	}

}
