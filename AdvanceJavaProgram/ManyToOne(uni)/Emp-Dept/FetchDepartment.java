package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class FetchDepartment {
	
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();
	        
	        et.begin();

	        long departmentId = 5L;
	        Department department = em.find(Department.class, departmentId);

	        if (department != null) {
	            System.out.println("Department found: " + department.getName());
	        } else {
	            System.out.println("Department with ID " + departmentId + " not found.");
	        }

	        et.commit();

		}
}
