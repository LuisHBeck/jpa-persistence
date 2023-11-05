package br.com.alura.dao;

import br.com.alura.models.Category;

import javax.persistence.EntityManager;

public class CategoryDao {
    private EntityManager em;

    public CategoryDao(EntityManager em) {
        this.em = em;
    }

    public void register(Category category) {
        this.em.persist(category);
    }
}
