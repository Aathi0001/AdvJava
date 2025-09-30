package com.example;

import jakarta.persistence.*;
import java.util.List;

public class FilterByPriceRange {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            List<Product> products = em.createQuery(
                "SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max", Product.class)
                .setParameter("min", 26000.0)
                .setParameter("max", 80000.0)
                .getResultList();

            products.forEach(System.out::println);
        } finally {
            em.close();
            emf.close();
        }
    }
}
