package com.backend.webproject.managers;

import java.util.List;

import com.backend.webproject.dao.ShoppingCartDAO;
import com.backend.webproject.entity.ShoppingCart;

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
        return dao.createNewCart(userID);
    }

    public int completeCart(int cartID){
        return dao.completeCart(cartID);
    }
    
}
