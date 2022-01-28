package com.atos.checkpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atos.checkpoint.dao.JdbcTemplateProducts;
import com.atos.checkpoint.dao.JdbcTemplateShoppingProductDetails;
import com.atos.checkpoint.dao.ShoppingCartDAO;
import com.atos.checkpoint.entity.Product;
import com.atos.checkpoint.entity.ProductAndDetails;
import com.atos.checkpoint.entity.ShoppingCart;
import com.atos.checkpoint.entity.ShoppingProductDetails;

@RestController
@RequestMapping("/shoppingcart")
@CrossOrigin(origins = "*")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartDAO cartDAO;
    @Autowired
    private JdbcTemplateProducts productsDAO;
    @Autowired
    private JdbcTemplateShoppingProductDetails detailsDAO;

    @RequestMapping("completeCart/{cartID}/{userID}")
    public int completeCart(
            @PathVariable("cartID") int cartID,
            @PathVariable("userID") int userID) {
        cartDAO.createNewCart(userID);
        return cartDAO.completeCart(cartID);
    }

    @PostMapping("createNewCart/{userID}")
    public int createNewCart(
            @PathVariable("userID") int userID) {
        int i = cartDAO.createNewCart(userID);
        if (i > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping("getInsessionCart/{userID}")
    @ResponseBody
    public ShoppingCart getInsessionCart(
            @PathVariable("userID") int userID) {
        ShoppingCart sc = cartDAO.getInSessionCart(userID);

        return sc;
    }

    @RequestMapping("getAllCarts/{userID}")
    public List<ShoppingCart> getAllCarts(
            @PathVariable("userID") int userID) {
        return cartDAO.getAllCompletedCarts(userID);
    }

    @RequestMapping("getProductsInCart/{cartID}")
    public List<ProductAndDetails> getProductsInCart(
            @PathVariable("cartID") int cartID) {
        List<ShoppingProductDetails> spdList = detailsDAO.getAllDetailsFromCart(cartID);
        List<ProductAndDetails> returnList = new ArrayList<ProductAndDetails>();
        for (int i = 0; i < spdList.size(); i++) {
            ShoppingProductDetails aux = spdList.get(i);
            Product product = productsDAO.getProductById(aux.getProductID());
            ProductAndDetails pad = new ProductAndDetails();
            pad.setProduct(product);
            pad.setSpd(aux);
            returnList.add(pad);
        }
        return returnList;
    }
}
