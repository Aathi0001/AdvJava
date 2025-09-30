package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteDataInBothTableParentAndChild {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Country co = em.find(Country.class, 4);
		Capital cp = co.getC();
		
		et.begin();
		em.remove(co);
		em.remove(cp);
		et.commit();
	}

}
