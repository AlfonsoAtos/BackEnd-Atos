package com.backend.webproject.managers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.backend.webproject.dao.PaymentDAO;
import com.backend.webproject.entity.Payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PaymentManagerTest {
    @Autowired 
    PaymentManager paymentManager;
    @MockBean
    private PaymentDAO dao;

    @Test
    void processPaymentTest(){
        Payment payment = new Payment();
        payment.setOpenCoupon(1);
        payment.setPaymentStatus("Completed");
        payment.setShoppingCartID(1);
        payment.setShoppingFinalAmount(400);
        int i = paymentManager.processPayment(payment.getOpenCoupon(), payment.getShoppingFinalAmount(), payment.getPaymentStatus(), payment.getShoppingCartID());
        assertEquals(1, i);
    }

    @Test
    void searchPaymentByIDTest(){
        assertEquals(1, paymentManager.searchPaymentByID(1).getPaymentID());
        
    }

    @Test
    void searchPaymentByIDNotFoundTest(){
        assertEquals(null, paymentManager.searchPaymentByID(100));
    }
}
