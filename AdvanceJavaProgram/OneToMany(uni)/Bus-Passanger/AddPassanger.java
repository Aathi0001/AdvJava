package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AddPassanger {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Passanger p1 = new Passanger();
		p1.setName("Akilesh");
		p1.setGender("male");
		p1.setPhone(765434564);
		p1.setAge(21);
		p1.setBoarding("periyapalayam");
		p1.setDestination("vadapalani");

		et.begin();
		em.merge(p1);
		et.commit();
		
		

	}

}
