package com.atos.checkpoint.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.atos.checkpoint.dao.ProductDAO;
import com.atos.checkpoint.dao.ShoppingProductDetailsDAO;
import com.atos.checkpoint.entity.Product;
import com.atos.checkpoint.entity.ProductAndDetails;
import com.atos.checkpoint.entity.ShoppingCart;
import com.atos.checkpoint.entity.ShoppingProductDetails;
import com.atos.checkpoint.managers.ShoppingCartManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartManager manager;
    @Autowired
    private ProductDAO productsDAO;
    @Autowired
    private ShoppingProductDetailsDAO detailsDAO;

    @RequestMapping("completeCart/{cartID}/{userID}")
    public int completeCart(
            @PathVariable("cartID") int cartID,
            @PathVariable("userID") int userID) {
        manager.createNewCart(userID);
        return manager.completeCart(cartID);
    }

    @PostMapping("createNewCart/{userID}")
    public int createNewCart(
            @PathVariable("userID") int userID) {
        int i = manager.createNewCart(userID);
        if (i > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping("getInsessionCart/{userID}")
    @ResponseBody
    public ShoppingCart getInsessionCart(
            @PathVariable("userID") int userID) {
        ShoppingCart sc = manager.getInSessionCart(userID);

        return sc;
    }

    @RequestMapping("getAllCarts/{userID}")
    public List<ShoppingCart> getAllCarts(
            @PathVariable("userID") int userID) {
        return manager.getAllCompletedCarts(userID);
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

    @PostMapping("removeProductFromCart/{shoppingproductdetailsID}")
    public int removeFromCart(
            @PathVariable("shoppingproductdetailsID") int shoppingproductdetailsID) {
        return detailsDAO.removeFromCart(shoppingproductdetailsID);
    }

    // shop & item
    @PostMapping("removeProductFromCart2/{cartID}/{shoppingproductdetailsID}")
    public int removeItemFromCart(
            @PathVariable("cartID") int cartID,
            @PathVariable("shoppingproductdetailsID") int shoppingproductdetailsID) {
        return detailsDAO.removeFromCart2(cartID, shoppingproductdetailsID);
    }

    @Autowired
    ShoppingProductDetailsDAO shoppingProductDetailsDAO;

    @PostMapping("addProductToCart/{cartID}/{shoppingproductdetailsID}")
    public int addProductToCart(
            @PathVariable("cartID") int cartID,
            @PathVariable("shoppingproductdetailsID") int shoppingproductdetailsID) {
        return shoppingProductDetailsDAO.addToCart2(cartID, shoppingproductdetailsID);
    }

    @PostMapping("/finalizeShoppingProductDetails")
    public int updateShoppingProductDetails(HttpServletRequest req) {
        ShoppingProductDetails spd = new ShoppingProductDetails();
        spd.setCostAfterApplyingCoupon(Integer.parseInt(req.getParameter("costAfterApplyingCoupon")));
        spd.setShoppingProductDetailsID(Integer.parseInt(req.getParameter("shoppingProductDetailsID")));
        spd.setShoppingCost(Integer.parseInt(req.getParameter("shoppingCost")));

        return detailsDAO.finalizeShoppingProductDetail(spd);
    }
}
