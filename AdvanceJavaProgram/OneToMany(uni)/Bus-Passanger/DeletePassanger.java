package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeletePassanger {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bus  b  = em.find(Bus.class, "TN01AD1234");
		
		Passanger p  = em.find(Passanger.class,3);
		
		b.removePassanger(p);
		
		et.begin();
		em.merge(b);
		em.remove(p);
		et.commit();
		System.out.println("Data deletd");
	}
}
