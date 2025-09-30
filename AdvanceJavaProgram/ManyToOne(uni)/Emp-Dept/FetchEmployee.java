package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class FetchEmployee {
		
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();
	        
	        et.begin();

	        long employeeId = 1L;
	        Employee employee = em.find(Employee.class, employeeId);

	        if (employee != null) {
	            System.out.println("Employee found: " + employee.getName());
	        } else {
	            System.out.println("Employee with ID " + employeeId + " not found.");
	        }

	        et.commit();
		}
}
