package br.com.alura.tests;

import br.com.alura.dao.ProductDao;
import br.com.alura.models.Product;
import br.com.alura.utils.JPAUtil;

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

        EntityManager em = JPAUtil.getEntityManager();
        ProductDao dao = new ProductDao(em);
        
        em.getTransaction().begin();
        dao.register(cellPhone);
        em.getTransaction().commit();
        em.close();
    }
}
