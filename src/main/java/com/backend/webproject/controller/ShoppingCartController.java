package com.backend.webproject.controller;

import java.util.Arrays;
import java.util.List;

import com.backend.webproject.dao.JdbcTemplateProducts;
import com.backend.webproject.dao.JdbcTemplateShoppingProductDetails;
import com.backend.webproject.dao.ShoppingCartDAO;
import com.backend.webproject.entity.Product;
import com.backend.webproject.entity.ProductAndDetails;
import com.backend.webproject.entity.ShoppingCart;
import com.backend.webproject.entity.ShoppingProductDetails;

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
    @Autowired
    JdbcTemplateShoppingProductDetails jdbc;
    @Autowired
    JdbcTemplateProducts jtp;

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

    @RequestMapping("getProductsInCart/{cartID}")
    public List<ProductAndDetails> getProductsInCart(
        @PathVariable("cartID") int cartID
    ){
        List<ShoppingProductDetails> spdList = jdbc.getAllDetailsFromCart(cartID);
        ProductAndDetails p = new ProductAndDetails();
        List<ProductAndDetails> returnList = Arrays.asList(p);
        for (int i = 0; i < spdList.size(); i++) {
            ShoppingProductDetails spd = spdList.get(i);
            Product product = jtp.getProductById(spd.getProductID());
            ProductAndDetails pad = new ProductAndDetails();
            pad.setProduct(product);
            pad.setSpd(spd);
            returnList.add(pad);
        }
        returnList.remove(0);
        return returnList;
    }
}
