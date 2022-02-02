package com.atos.checkpoint.managers;

import com.atos.checkpoint.dao.PaymentDAO;
import com.atos.checkpoint.entity.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentManager {
  @Autowired
  PaymentDAO dao;

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
