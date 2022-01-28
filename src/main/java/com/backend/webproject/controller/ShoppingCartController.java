package com.backend.webproject.controller;

import java.util.ArrayList;
import java.util.List;

import com.backend.webproject.dao.ProductDAO;
import com.backend.webproject.dao.ShoppingCartDAO;
import com.backend.webproject.dao.ShoppingProductDetailsDAO;
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

@RestController
@RequestMapping("/shoppingcart")
@CrossOrigin(origins = "*")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartDAO cartDAO;
    @Autowired
    private ProductDAO productsDAO;
    @Autowired
    private ShoppingProductDetailsDAO detailsDAO;

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
