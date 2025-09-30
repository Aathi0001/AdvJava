package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
	et.begin();

    // Find the employee to delete
    Employee dels = em.createQuery("SELECT e FROM Employee e WHERE e.id = 1", Employee.class)
                      .getSingleResult();

    // Remove the employee
    em.remove(dels);

    et.commit();
    System.out.println("Employee deleted successfully.");
}

}
