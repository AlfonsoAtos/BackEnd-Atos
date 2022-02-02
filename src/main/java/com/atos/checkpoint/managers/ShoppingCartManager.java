package com.atos.checkpoint.managers;

import java.util.List;

import com.atos.checkpoint.dao.ShoppingCartDAO;
import com.atos.checkpoint.entity.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartManager {
    @Autowired
    ShoppingCartDAO dao;

    public List<ShoppingCart> getAllCompletedCarts(int userID){
        return dao.getAllCompletedCarts(userID);
    }

    public ShoppingCart getInSessionCart(int userID){
        return dao.getInSessionCart(userID);
    }

    public int createNewCart(int userID){
        System.out.println("Hello manager");
        return dao.createNewCart(userID);
    }

    public int completeCart(int cartID){
        return dao.completeCart(cartID);
    }
    
}
