package com.workintech.Burger.dao;

import com.workintech.Burger.entity.BreadType;
import com.workintech.Burger.entity.Burger;
import com.workintech.Burger.entity.Content;

import java.util.List;
import java.util.Set;

public interface BurgerDao {
    List<Burger> findAll();
    Burger findById(Long id);
    List<Burger> findByPrice(int price);
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove (Long id);
    Burger save(Burger burger);

}
