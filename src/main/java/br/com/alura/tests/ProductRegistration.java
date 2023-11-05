package br.com.alura.tests;

import br.com.alura.dao.CategoryDao;
import br.com.alura.dao.ProductDao;
import br.com.alura.models.Category;
import br.com.alura.models.Product;
import br.com.alura.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductRegistration {
    public static void main(String[] args) {
        registerProduct();

        Long id = 1l;
        EntityManager em = JPAUtil.getEntityManager();
        ProductDao daoP = new ProductDao(em);

        Product p = daoP.searchById(id);
        System.out.println(p.getPrice());

        List<Product> list = daoP.listProducts();
        list.forEach(p2 -> System.out.println(p2.getName()));

        list = daoP.searchByName("Xiaomi 14t Pro");
        list.forEach(p2 -> System.out.println(p2.getName()));

        list = daoP.searchByCategory("cell-phones");
        list.forEach(p2 -> System.out.println(p2.getName()));
    }

    private static void registerProduct() {
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
