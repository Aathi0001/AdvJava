package com.example;

import jakarta.persistence.*;

public class DeleteProduct {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            Long id = 2L;
            tx.begin();
            Product p = em.find(Product.class, id);
            if (p != null) {
                em.remove(p);
                System.out.println("Deleted: " + p);
            } else {
                System.out.println("Product not found to delete");
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
