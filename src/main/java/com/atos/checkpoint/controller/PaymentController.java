package com.atos.checkpoint.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.checkpoint.dao.PaymentDAO;
import com.atos.checkpoint.entity.Payment;
import com.atos.checkpoint.managers.PaymentManager;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {
	@Autowired
	private PaymentManager manager;
    
  @RequestMapping("/byID/{id}")
	public Payment searchByID(
		@PathVariable("id") int id
		) {
		Payment pay = manager.searchPaymentByID(id);
		
		return pay;
	}

	@RequestMapping("/byCartID/{id}")
	public Payment searchByCartID(
		@PathVariable("id") int id
		) {
		Payment pay = manager.searchPaymentByCartID(id);
		
		return pay;
	}

	@PostMapping("/pay")
	public int processPayment(HttpServletRequest req) {
		int openCoupon = Integer.parseInt(req.getParameter("openCoupon"));
		int shoppingAmount = Integer.parseInt(req.getParameter("shoppingAmount"));
		String paymentStatus = req.getParameter("paymentStatus");
		int shoppingCartID = Integer.parseInt(req.getParameter("shoppingCartID"));
		
		if (manager.processPayment(openCoupon, shoppingAmount, paymentStatus, shoppingCartID)==1) {
			// Create shopping cart
			return 1;
		}
		return 0;
	}

	
}
