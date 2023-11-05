package br.com.alura.dao;

import br.com.alura.models.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao {
    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public void register(Product product) {
        this.em.persist(product);
    }

    public Product searchById(Long id) {
        return this.em.find(Product.class, id);
    }

    public List<Product> listProducts() {
        String jpql = "SELECT p FROM Product p";
        return this.em.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> searchByName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.name = :name";
        return this.em.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }

    public List<Product> searchByCategory(String category) {
        String jpql = "SELECT p FROM Product p WHERE p.category.category = :category";
        return this.em.createQuery(jpql, Product.class).setParameter("category", category).getResultList();
    }
}
