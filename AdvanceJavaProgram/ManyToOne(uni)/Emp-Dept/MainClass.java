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

            
            Department d1 = new Department();
            d1.setName("Engineering");
            Department d2 = new Department();
            d2.setName("Developer");


            
            Employee e1 = new Employee();
            e1.setName("Aathi");
            e1.setDepartment(d1);
            
            Employee e2 = new Employee();
            e2.setName("Siva");
            e2.setDepartment(d2);
            
            Employee e3 = new Employee();
            e3.setName("Ganesh");
            e3.setDepartment(d1);
            

            
            
            et.begin();
            em.persist(d1);
            em.persist(d2);
            em.persist(e1);
            em.persist(e2);
            em.persist(e3);
            et.commit();
            System.out.println("Data saved successfully.");
        
}
}