package com.example;

import jakarta.persistence.*;
import java.util.List;

public class FetchNameAndPrice {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            List<Object[]> result = em.createQuery(
                "SELECT p.name, p.price FROM Product p", Object[].class)
                .getResultList();

            for (Object[] row : result) {
                System.out.println("Name: " + row[0] + " | Price: " + row[1]);
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
