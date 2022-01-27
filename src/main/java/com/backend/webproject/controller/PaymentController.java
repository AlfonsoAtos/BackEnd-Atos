package com.backend.webproject.controller;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.dao.PaymentDAO;
import com.backend.webproject.entity.Payment;

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
	private PaymentDAO paymentJDBC;
    
    @RequestMapping("/byID/{id}")
	public Payment searchByID(
		@PathVariable("id") int id
		) {
		Payment pay = paymentJDBC.searchPaymentByID(id);
		
		return pay;
	}

	@RequestMapping("/byCartID/{id}")
	public Payment searchByCartID(
		@PathVariable("id") int id
		) {
		Payment pay = paymentJDBC.searchPaymentByCartID(id);
		
		return pay;
	}

	@PostMapping("/pay")
	public int processPayment(HttpServletRequest req) {
		int openCoupon = Integer.parseInt(req.getParameter("openCoupon"));
		int shoppingAmount = Integer.parseInt(req.getParameter("shoppingAmount"));
		String paymentStatus = req.getParameter("paymentStatus");
		int shoppingCartID = Integer.parseInt(req.getParameter("shoppingCartID"));
		
		if (paymentJDBC.processPayment(openCoupon, shoppingAmount, paymentStatus, shoppingCartID)==1) {
			// Create shopping cart
			return 1;
		}
		return 0;
	}

	
}
