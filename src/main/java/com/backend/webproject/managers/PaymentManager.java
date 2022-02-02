package com.backend.webproject.managers;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.dao.PaymentDAO;
import com.backend.webproject.entity.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PaymentManager {

	@Autowired
	private PaymentDAO paymentJDBC;

	@Autowired
	private Payment payment;

	public Payment searchByID(@PathVariable("id") int id) {
		Payment pay = paymentJDBC.searchPaymentByID(id);

		return pay;
	}

	public Payment searchByCartID(@PathVariable("id") int id) {
		Payment pay = paymentJDBC.searchPaymentByCartID(id);

		return pay;
	}

	public int processPayment(HttpServletRequest req) {
		// int openCoupon = Integer.parseInt(req.getParameter("openCoupon"));
		// int shoppingAmount = Integer.parseInt(req.getParameter("shoppingAmount"));
		// String paymentStatus = req.getParameter("paymentStatus");
		// int shoppingCartID = Integer.parseInt(req.getParameter("shoppingCartID"));

		if (paymentJDBC.processPayment(payment) == 1) {
			// Create shopping cart
			return 1;
		}
		return 0;
	}
}