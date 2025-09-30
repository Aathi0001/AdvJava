package com.example;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Passanger p1 = new Passanger();
		p1.setName("vasanth");
		p1.setGender("male");
		p1.setPhone(765432345l);
		p1.setAge(22);
		p1.setBoarding("Arakkonam");
		p1.setDestination("vadapalani");

		Passanger p2 = new Passanger();
		p2.setName("sanjai");
		p2.setGender("male");
		p2.setPhone(765434567l);
		p2.setAge(21);
		p2.setBoarding("thiruvallur");
		p2.setDestination("vadapalani");

		Passanger p3 = new Passanger();
		p3.setName("Abdulla");
		p3.setGender("male");
		p3.setPhone(8765456323l);
		p3.setAge(35);
		p3.setBoarding("Avadi");
		p3.setDestination("vadapalani");

		ArrayList<Passanger> al = new ArrayList<Passanger>();
		al.add(p1);
		al.add(p2);
		al.add(p3);

		Bus b = new Bus();
		b.setBusNo("TN01AD1234");
		b.setName("sundra travels");
		b.setNoOfSeats(40);
		b.setType("AC Sleeper");
		b.setPrice(500);
		b.setPassangers(al);

		et.begin();
		em.persist(b);
		et.commit();
		
		System.out.println("Data saved");
	}
}
