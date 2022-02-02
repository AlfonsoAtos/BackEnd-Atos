package com.backend.webproject.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.webproject.dao.PaymentDAO;
import com.backend.webproject.entity.Payment;

@Component
public class PaymentManager {
  @Autowired
  private PaymentDAO dao;

  public int processPayment(int openCoupon, int shoppingFinalAmount, String paymentStatus, int shoppingCartID){
    Payment payment = new Payment();
    payment.setOpenCoupon(openCoupon);
    payment.setShoppingFinalAmount(shoppingFinalAmount);
    payment.setPaymentStatus(paymentStatus);
    payment.setShoppingCartID(shoppingCartID);
    return dao.processPayment(payment);
  }

  public Payment searchPaymentByID(int pid){
    return dao.searchPaymentByID(pid);
  }

  public Payment searchPaymentByCartID(int cartID){
    return dao.searchPaymentByCartID(cartID);
  }
}
