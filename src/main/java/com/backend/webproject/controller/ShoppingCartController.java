package com.backend.webproject.controller;

import com.backend.webproject.jtemp.ShoppingCartJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//historial de carritos no activos
    //traer carrito activo
    //crear carrito activo
    //convertir carrito de activo a no activo >


@RestController
@RequestMapping("/shoppingcart")
@CrossOrigin(origins = "*")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartJDBC scj;

    @RequestMapping("completeCart/{cartID}/{userID}")
    public int completeCart(
        @PathVariable("cartID") int cartID,
        @PathVariable("userID") int userID
    ){
        return scj.completeCart(cartID, userID);
    }
}
