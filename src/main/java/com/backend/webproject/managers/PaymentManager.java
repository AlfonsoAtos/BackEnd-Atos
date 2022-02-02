package com.backend.webproject.managers;

import com.backend.webproject.dao.PaymentDAO;
import com.backend.webproject.entity.Payment;

public class PaymentManager {

    public int processPayment(int openCoupon, int shoppingFinalAmount, String paymentStatus, int shoppingCartID){
        Payment payment = new Payment();
        payment.setOpenCoupon(openCoupon);
        payment.setShoppingFinalAmount(shoppingFinalAmount);
        payment.setPaymentStatus(paymentStatus);
        payment.setShoppingCartID(shoppingCartID);
        PaymentDAO dao = new PaymentDAO();
        return dao.processPayment(payment);
    }

    public Payment searchPaymentByID(int pid){
        PaymentDAO dao = new PaymentDAO();
        return dao.searchPaymentByID(pid);
    }

    public Payment searchPaymentByCartID(int cartID){
        PaymentDAO dao = new PaymentDAO();
        return dao.searchPaymentByCartID(cartID);
    }
    
}
