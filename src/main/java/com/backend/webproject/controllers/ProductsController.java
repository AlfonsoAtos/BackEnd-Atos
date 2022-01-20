package com.backend.webproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.backend.webproject.jtemp.JdbcTemplateProducts;
import com.backend.webproject.jtemp.ProductsModel;

@Controller
public class ProductsController {
    @Autowired
    JdbcTemplateProducts jdbcTemplateProducts;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        List<ProductsModel> newProducts = jdbcTemplateProducts.getNewProducts();
        model.addAttribute("newProducts", newProducts);
        return "home";
    }
}
