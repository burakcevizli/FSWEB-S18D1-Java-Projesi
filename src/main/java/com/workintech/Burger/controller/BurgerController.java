package com.workintech.Burger.controller;

import com.workintech.Burger.dao.BurgerDao;
import com.workintech.Burger.entity.BreadType;
import com.workintech.Burger.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping("/burgers")
    public Burger save(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @GetMapping("/burgers")
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/burgers/{id}")
    public Burger findById(@PathVariable Long id) {
        return burgerDao.findById(id);
    }

    @PutMapping("/burgers/{id}")
    public Burger update(@RequestBody Burger burger) {
        burgerDao.update(burger);
        return burger;
    }

    @DeleteMapping("/burgers/{id}")
    public Burger delete(@PathVariable Long id){
        return burgerDao.remove(id);
    }

    @GetMapping("/burgers/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@RequestBody String breadType){
        BreadType breadTypeEnum = BreadType.valueOf(breadType);
       return burgerDao.findByBreadType(breadTypeEnum);
    }
    @GetMapping("/burgers/findByPrice/{price}")
    public List<Burger> findByPrice(@RequestBody int price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/burgers/findByContent/{content}")
    public List<Burger> findByContent(@RequestBody String  content){
        return burgerDao.findByContent(content);
    }


}
