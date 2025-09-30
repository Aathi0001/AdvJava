package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AddProduct {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // create products
            Product p1 = new Product("Laptop", 60000.0, "Electronics", 10, true);
            Product p2 = new Product("Mobile", 25000.0, "Electronics", 20, true);

            // persist
            em.persist(p1);
            em.persist(p2);

            tx.commit();

            System.out.println("Saved: " + p1);
            System.out.println("Saved: " + p2);
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
