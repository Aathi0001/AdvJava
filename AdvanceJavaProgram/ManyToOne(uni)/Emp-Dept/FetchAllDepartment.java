package com.example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class FetchAllDepartment {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
	
	et.begin();

    // Fetch all departments
    Query departmentQuery = em.createQuery("SELECT d FROM Department d");
    List<Department> allDepartments = departmentQuery.getResultList();

    System.out.println("--- All Departments ---");
    for (Department dept : allDepartments) {
        //System.out.println("Department: " + dept.getName());
    	System.out.print(dept);
    }

    et.commit();
}

}
