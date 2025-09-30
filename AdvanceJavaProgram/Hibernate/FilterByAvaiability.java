package com.example;

import jakarta.persistence.*;
import java.util.List;

public class FilterByAvaiability {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            List<Product> products = em.createQuery(
                "SELECT p FROM Product p WHERE p.available = true", Product.class)
                .getResultList();

            products.forEach(System.out::println);
        } finally {
            em.close();
            emf.close();
        }
    }
}
