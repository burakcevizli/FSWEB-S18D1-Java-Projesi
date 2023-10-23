package com.workintech.Burger.util;

import com.workintech.Burger.dto.BurgerResponse;
import com.workintech.Burger.entity.Burger;
import com.workintech.Burger.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.ArrayList;

public class BurgerResponseEntity {
    public static List<BurgerResponse> burgerToBurgerResponse(List<Burger> burgers){
        List<BurgerResponse> responses = new ArrayList<>();
        if(burgers.isEmpty()){
            throw new BurgerException("Burger List is empty", HttpStatus.NOT_FOUND);
        }
        for(Burger burger: burgers){
            responses.add(new BurgerResponse(burger.getName(), burger.getPrice()));
        }
        return responses;
    }
}
