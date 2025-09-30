package com.example;

import jakarta.persistence.*;


public class SearchByName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            Product product = em.createQuery(
                    "select p from Product p where p.name = :name", Product.class)
                    .setParameter("name", "Laptop")
                    .getSingleResult();

            System.out.println(product);

        } catch (NoResultException e) {
            System.out.println("No product found with name ");
        } finally {
            em.close();
            emf.close();
        }
    }
}


/*
package com.example;

import jakarta.persistence.*;
import java.util.List;

public class SearchByName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("productPU");
        EntityManager em = emf.createEntityManager();

        try {
            String name = "Laptop"; // search value

            List<Product> products = em.createQuery("from Product p where p.name = :name", Product.class)
                                       .setParameter("name", name)
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
*/




/*
package com.example;

import jakarta.persistence.*;


public class SearchByName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
            Query q = em.createQuery(
                    "select p from Product p where p.name = :name")
                    .setParameter("name", "Laptop");
                    
            Object o = q.getSingleResult();
            Product p = (Product)o;
            System.out.println(p);

        } catch (NoResultException e) {
            System.out.println("No product found with name ");
        } catch (NonUniqueResultException e) {
            System.out.println("More than one product found with name Laptop");
        } finally {
            em.close();
            emf.close();
        }
    }
}
*/



/*
package com.example;

import jakarta.persistence.*;


public class SearchByName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();

        try {
        
        	TypedQuery<Product> q = em.createQuery(
			    "select p from Product p where p.name = :name", Product.class);
			
			q.setParameter("name", "Laptop");
			
			Product p = q.getSingleResult();  // directly returns Product
			System.out.println(p);

        } catch (NoResultException e) {
            System.out.println("No product found with name ");
        } catch (NonUniqueResultException e) {
            System.out.println("More than one product found with name Laptop");
        } finally {
            em.close();
            emf.close();
        }
    }
}
*/