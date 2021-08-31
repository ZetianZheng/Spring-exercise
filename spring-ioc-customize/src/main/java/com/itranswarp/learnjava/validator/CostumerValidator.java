package com.itranswarp.learnjava.validator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class CostumerValidator implements Validator{
    @Override
    public void validate(String email, String password, String name) {
        System.out.println("you pass!");
    }

}
