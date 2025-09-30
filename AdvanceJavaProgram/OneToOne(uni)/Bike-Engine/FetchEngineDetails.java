package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchEngineDetails {

		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();
			
			Engine e = em.find(Engine.class, "SK920348SD32990");
			
			System.out.println(e);
			
			
		}

	}
