package com.backend.webproject.managers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.backend.webproject.dao.PaymentDAO;
import com.backend.webproject.entity.Payment;
import com.backend.webproject.mappers.PaymentMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class PaymentManagerTest {
    @Autowired 
    PaymentManager paymentManager;
    @MockBean
    private PaymentDAO dao;
    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Mock
    private PaymentMapper paymentMapper;

    private Payment createPayment() {
        return new Payment(1, 1, 1, "InNegotiation", 1);
    }

    @Test
    void processPaymentTest(){
        Payment payment = new Payment();
        payment.setOpenCoupon(1);
        payment.setPaymentStatus("Completed");
        payment.setShoppingCartID(1);
        payment.setShoppingFinalAmount(400);
        given(dao.processPayment(payment)).willReturn(1);
        int result = paymentManager.processPayment(payment);
        assertEquals(1, result);
    }

    @Test
    void searchPaymentByIDTest(){
        Payment payment = createPayment();
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(payment);
        given(dao.searchPaymentByID(payment.getPaymentID())).willReturn(payment);
        Payment resultPayment = paymentManager.searchPaymentByID(payment.getPaymentID());
        assertEquals(payment, resultPayment);
    }

    @Test
    void searchPaymentByIDNotFoundTest(){
        assertEquals(null, paymentManager.searchPaymentByID(100));
    }

    @Test
    void searchPaymentByCartIDTest(){
        Payment payment = createPayment();
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(payment);
        given(dao.searchPaymentByCartID(payment.getShoppingCartID())).willReturn(payment);
        Payment resultPayment = paymentManager.searchPaymentByCartID(payment.getShoppingCartID());
        assertEquals(payment, resultPayment);
    }


}
