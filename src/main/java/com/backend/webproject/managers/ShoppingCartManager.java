package com.backend.webproject.managers;

import java.util.List;

import com.backend.webproject.dao.ShoppingCartDAO;
import com.backend.webproject.entity.ShoppingCart;

public class ShoppingCartManager {

    public List<ShoppingCart> getAllCompletedCarts(int userID){
        ShoppingCartDAO dao = new ShoppingCartDAO();
        return dao.getAllCompletedCarts(userID);
        
    }

    public ShoppingCart getInSessionCart(int userID){
        ShoppingCartDAO dao = new ShoppingCartDAO();
        return dao.getInSessionCart(userID);
    }

    public int createNewCart(int userID){
        ShoppingCartDAO dao = new ShoppingCartDAO();
        return dao.createNewCart(userID);
    }

    public int completeCart(int cartID){
        ShoppingCartDAO dao = new ShoppingCartDAO();
        return dao.completeCart(cartID);
    }
    
}
