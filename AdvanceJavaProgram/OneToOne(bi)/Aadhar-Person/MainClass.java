package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainClass {
	
	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Person p = new Person();
	p.setName("Aathi");
	p.setGender("Male");
	p.setEmail("p.aathi@gmail.com");
	p.setPhoneno(9140470820L);
	
	Aadhar a = new Aadhar();
	a.setAadhar_no(888888888888l);
	a.setAddress("no:484, Siva Sakthi Nagar, 9th Street , kolathur, chennai 99");
	a.setDob("13/11/2003");
	a.setFathar_name("Pachai Perumal");
	a.setPerson(p);
	
	p.setAadhar(a);
	
	et.begin();
	em.persist(p);
	em.persist(a);
	et.commit();
	
	System.out.println("data Saved");
	
	}

}
