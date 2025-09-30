package com.example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class FetchAllEmployeeWithDept {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        Query query = em.createQuery(
                "SELECT e FROM Employee e JOIN FETCH e.department", Employee.class);
        
        
            List<Employee> employeesWithDepartments = query.getResultList();

            for (Employee emp : employeesWithDepartments) {
                System.out.println(emp);
            }

	}

}
