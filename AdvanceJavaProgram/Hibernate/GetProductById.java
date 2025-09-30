package com.example;

import jakarta.persistence.*;

public class GetProductById {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            Long id = 1L; // change as needed
            Product p = em.find(Product.class, id);
            if (p != null) {
                System.out.println("Found: " + p);
            } else {
                System.out.println("Product not found with id " + id);
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
