package com.example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SortByPriceHighToLow {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            List<Product> products = em.createQuery(
                "SELECT p FROM Product p ORDER BY p.price DESC", Product.class)
                .getResultList();

            products.forEach(System.out::println);
        } finally {
            em.close();
            emf.close();
        }
    }
}
