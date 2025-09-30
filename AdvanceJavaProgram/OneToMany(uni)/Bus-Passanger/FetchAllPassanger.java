package com.example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class FetchAllPassanger {
		public static void main(String[] args) {
			

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
			EntityManager em = emf.createEntityManager();

			Query q =	em.createQuery("select p from Passanger p");
			
			List<Passanger> list =	q.getResultList();
			
			for(Passanger p : list) {
				System.out.println(p);
			}
			
			
		}

	}

