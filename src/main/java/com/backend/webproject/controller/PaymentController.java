package com.backend.webproject.controller;

import com.backend.webproject.entity.Payment;
import com.backend.webproject.jtemp.PaymentJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
	PaymentJDBC PaymentJDBC;
    
    @RequestMapping("/byID/{id}")
	public Payment searchByID(
		@PathVariable("id") int id
		) {
		Payment pay = PaymentJDBC.searchPaymentByID(id);
		
		return pay;
	}

	
}
