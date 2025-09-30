package com.example;

import jakarta.persistence.*;

public class UpdateProduct {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            Long id = 1L;
            tx.begin();
            Product p = em.find(Product.class, id);
            if (p != null) {
                p.setPrice(55000.0);
                p.setQuantity(12);
                // changes automatically tracked; no need to call merge if entity is managed
                System.out.println("Updated: " + p);
            } else {
                System.out.println("Product not found!");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
