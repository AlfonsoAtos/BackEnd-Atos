package com.backend.webproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.backend.webproject.jtemp.PaymentJDBC;
import com.backend.webproject.jtemp.Payment;

@Controller
public class PaymentController {
    @Autowired
	PaymentJDBC PaymentJDBC;
    
    @RequestMapping("/products")
	public Payment showHomePage(Model model) {
		Payment pay = PaymentJDBC.searchPaymentByID(1);
		
		return pay;
	}
}
