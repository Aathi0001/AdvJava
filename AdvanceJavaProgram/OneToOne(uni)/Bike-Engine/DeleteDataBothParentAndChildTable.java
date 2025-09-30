package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteDataBothParentAndChildTable {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Bike b = em.find(Bike.class, "TN05AA0001");
		Engine e = b.getEngine();
		
		et.begin();
		em.remove(b);
		em.remove(e);
		et.commit();
	}

}
