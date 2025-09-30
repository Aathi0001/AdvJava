package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdatePassanger {
	public static void main(String[] args) {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Passanger  p  = em.find(Passanger.class, 3);
		
		p.setPhone(5433456543l);
		p.setAge(35);
		
		et.begin();
		em.merge(p);
		et.commit();
		
		
		
	}

}
