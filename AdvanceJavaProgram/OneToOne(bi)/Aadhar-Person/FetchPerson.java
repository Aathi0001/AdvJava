package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchPerson {
	
		public static void main(String[] args) {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();

			Person a = em.find(Person.class, 1);
			Aadhar p = a.getAadhar();

			System.out.println(a);
			System.out.println(p);

		}

}
