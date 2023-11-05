package br.com.alura.tests;

import br.com.alura.dao.CategoryDao;
import br.com.alura.dao.ProductDao;
import br.com.alura.models.Category;
import br.com.alura.models.Product;
import br.com.alura.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistration {
    public static void main(String[] args) {
        Category cellPhones = new Category("cell-phones");
        Product cellPhone = new Product("Xiaomi 14t Pro", "Incredible phone", new BigDecimal("3981"), cellPhones);

        EntityManager em = JPAUtil.getEntityManager();
        ProductDao daoP = new ProductDao(em);
        CategoryDao daoC = new CategoryDao(em);

        em.getTransaction().begin();

        daoC.register(cellPhones);
        daoP.register(cellPhone);

        em.getTransaction().commit();
        em.close();
    }
}
