package com.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


//OneToMany BiDirectional
public class MainClass {
	
	public static void main(String[] args) {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	
	Batch b = new Batch();
	
	b.setBcode("abc123");
	b.setSubject("Java");
	b.setTrainer("Tabrez");
	b.setTiming("2:00");
	b.setNoofstd(200);
	
	Student s1 = new Student();
	s1.setName("Aathi");
	s1.setGender("Male");
	s1.setEmail("p.aathi@gmail.com");
	s1.setPhno(6321547895L);
	
	Student s2 = new Student();
	s2.setName("Siva");
	s2.setGender("Male");
	s2.setEmail("p.siva@gmail.com");
	s2.setPhno(6321546595L);
	
	Student s3 = new Student();
	s3.setName("Ganesh");
	s3.setGender("Male");
	s3.setEmail("p.ganesh@gmail.com");
	s3.setPhno(6321595895L);
	
	List<Student> li = new ArrayList<Student>();
	li.add(s1);
	li.add(s2);
	li.add(s3);
	b.setStudents(li);
	
	et.begin();
	em.persist(b);
	et.commit();
	
	System.out.println("Data Saved");
	
	}
}
