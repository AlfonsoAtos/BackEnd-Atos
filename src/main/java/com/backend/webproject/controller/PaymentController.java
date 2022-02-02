package com.backend.webproject.controller;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.entity.Payment;
import com.backend.webproject.managers.PaymentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

  	@Autowired
	PaymentManager paymentManager;
    
  	@RequestMapping("/byID/{id}")
	public Payment searchByID(@PathVariable("id") int id) {
		return paymentManager.searchByID(id);
	}

	@RequestMapping("/byCartID/{id}")
	public Payment searchByCartID(@PathVariable("id") int id) {
		return paymentManager.searchByCartID(id);
	}

	@PostMapping("/pay")
	public int processPayment(HttpServletRequest req) {
		return paymentManager.processPayment(req);
	}

	
}
