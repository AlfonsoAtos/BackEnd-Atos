package com.backend.webproject.managers;

import com.backend.webproject.dao.PaymentDAO;
import com.backend.webproject.entity.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentManager {
    @Autowired
    PaymentDAO dao;

    public int processPayment(Payment payment){
        return dao.processPayment(payment);
    }

    public Payment searchPaymentByID(int pid){
        return dao.searchPaymentByID(pid);
    }

    public Payment searchPaymentByCartID(int cartID){
        return dao.searchPaymentByCartID(cartID);
    }
    
}