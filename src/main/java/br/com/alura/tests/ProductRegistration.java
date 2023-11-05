package br.com.alura.tests;

import br.com.alura.models.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProductRegistration {
    public static void main(String[] args) {
        Product cellPhone = new Product();
        cellPhone.setName("Xiaomi 14t Pro");
        cellPhone.setDescription("Incredible phone");
        cellPhone.setPrice(new BigDecimal("3981"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(cellPhone);
        em.getTransaction().commit();
        em.close();
    }
}
