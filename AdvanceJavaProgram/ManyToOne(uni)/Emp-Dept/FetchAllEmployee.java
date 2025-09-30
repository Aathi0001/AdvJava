package com.example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class FetchAllEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        
        et.begin();

        
        Query employeeQuery = em.createQuery("SELECT e FROM Employee e");
        List<Employee> allEmployees = employeeQuery.getResultList();

        System.out.println("--- All Employees ---");
        for (Employee emp : allEmployees) {
            System.out.println("Employee: " + emp.getName());
        }

        et.commit();
	}

}
