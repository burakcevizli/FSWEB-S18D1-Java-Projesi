package com.workintech.Burger.dao;

import com.workintech.Burger.entity.BreadType;
import com.workintech.Burger.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BurgerDaoImpl implements BurgerDao{

    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Burger> findAll() {
      TypedQuery<Burger> query = entityManager.createQuery("SELECT e FROM Burger e",Burger.class);
        return query.getResultList();
    }

    @Override
    public Burger findById(Long id) {
      return  entityManager.find(Burger.class,id);
    }

    @Override
    public List<Burger> findByPrice(int price) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT e FROM Burger e WHERE e.price > :price"
                ,Burger.class);
        query.setParameter("price" ,price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query  = entityManager.createQuery("SELECT e FROM Burger WHERE e.breadType = :breadType " +
                        "ORDER BY e.name"
        ,Burger.class);
        query.setParameter("breadType",breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT e FROM Burger WHERE e.content = :content"
        , Burger.class);
        query.setParameter("content" , content);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);

    }

    @Transactional
    @Override
    public Burger remove(Long id) {
        Burger burger = findById(id);
        entityManager.remove(burger);
        return burger;
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }
}
