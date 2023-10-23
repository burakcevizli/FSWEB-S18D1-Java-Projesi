package com.workintech.Burger.util;

import com.workintech.Burger.entity.Burger;
import com.workintech.Burger.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkBurgerCredentials(Burger burger){
        if(burger.getName() == null || burger.getName().isEmpty() || burger.getPrice() <= 0){
            throw new BurgerException("Burger credentials are not valid", HttpStatus.BAD_REQUEST);
        }
    }
}
