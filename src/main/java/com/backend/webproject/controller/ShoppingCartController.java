package com.backend.webproject.controller;

import java.util.List;

import com.backend.webproject.entity.ShoppingCart;
import com.backend.webproject.jtemp.ShoppingCartDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//historial de carritos no activos
//traer carrito activo >
//crear carrito activo >
//convertir carrito de activo a no activo >

@RestController
@RequestMapping("/shoppingcart")
@CrossOrigin(origins = "*")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartDAO scj;

    @RequestMapping("completeCart/{cartID}/{userID}")
    public int completeCart(
            @PathVariable("cartID") int cartID,
            @PathVariable("userID") int userID) {
        scj.createNewCart(userID);
        return scj.completeCart(cartID);
    }

    @PostMapping("createNewCart/{userID}")
    public int createNewCart(
            @PathVariable("userID") int userID) {
        int i = scj.createNewCart(userID);
        if (i > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping("getInsessionCart/{userID}")
    @ResponseBody
    public ShoppingCart getInsessionCart(
            @PathVariable("userID") int userID) {
        ShoppingCart sc = scj.getInSessionCart(userID);

        return sc;
    }

    @RequestMapping("getAllCarts/{userID}")
    public List<ShoppingCart> getAllCarts(
            @PathVariable("userID") int userID) {
        return scj.getAllCompletedCarts(userID);
    }
/*
    @RequestMapping("getProductsInCart/{cartID}")
    public List<Product> getProductsInCart(
        @PathVariable("cartID") int cartID
    ){
        List<Product> products = new ArrayList<Product>();
        for(int i=0; i<10;i++){
            CustomerSideController csc = new CustomerSideController();
            products.add(csc.getProductByID(i));
        }
        return products;
    }*/
}
