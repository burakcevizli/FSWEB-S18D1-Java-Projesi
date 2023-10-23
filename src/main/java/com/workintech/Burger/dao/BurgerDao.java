package com.workintech.Burger.dao;

import com.workintech.Burger.entity.BreadType;
import com.workintech.Burger.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    List<Burger> findAll();
    Burger findById(Long id);
    List<Burger> findByPrice(int price);
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove (Long id);

}
