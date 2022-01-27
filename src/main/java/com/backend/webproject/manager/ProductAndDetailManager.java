package com.backend.webproject.manager;

import java.util.Arrays;
import java.util.List;

import com.backend.webproject.dao.JdbcTemplateProducts;
import com.backend.webproject.dao.JdbcTemplateShoppingProductDetails;
import com.backend.webproject.entity.Product;
import com.backend.webproject.entity.ProductAndDetails;
import com.backend.webproject.entity.ShoppingProductDetails;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductAndDetailManager {
    @Autowired
    JdbcTemplateShoppingProductDetails jdbc;
    @Autowired
    JdbcTemplateProducts jtp;

    public List<ProductAndDetails> getProductsAndDetails(int cartID) {
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
        return returnList;
    }
}
