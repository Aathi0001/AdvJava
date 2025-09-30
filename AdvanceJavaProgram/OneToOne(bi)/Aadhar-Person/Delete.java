package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Aadhar a = em.find(Aadhar.class, 888888888888l);
		Person p = a.getPerson();

		et.begin();
		em.remove(a);
		em.remove(p);
		et.commit();

		System.out.println("Data deleted");

	}

}
