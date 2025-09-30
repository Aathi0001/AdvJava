package com.example;

import jakarta.persistence.*;
import java.util.List;

public class SearchByCategory {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            List<Product> products = em.createQuery(
                "SELECT p FROM Product p WHERE p.category = :cat", Product.class)
                .setParameter("cat", "Electronics")
                .getResultList();

            products.forEach(p -> System.out.println(p));

        } finally {
            em.close();
            emf.close();
        }
    }
}
