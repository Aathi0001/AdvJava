package com.example;

import jakarta.persistence.*;
import java.util.List;

public class ListAllProduct {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            // Very simple: get all records
            List<Product> products = em.createQuery("from Product", Product.class)
                                       .getResultList();

            for (Product p : products) {
                System.out.println(p);
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
