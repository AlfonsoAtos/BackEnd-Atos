package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.Map;

import com.backend.webproject.entity.Payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class PaymentDAOTest {

    @InjectMocks
    private PaymentDAO paymentDAO;

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    void processPaymentTest(){
        Payment payment = new Payment();
        payment.setOpenCoupon(1);
        payment.setPaymentStatus("Completed");
        payment.setShoppingCartID(1);
        payment.setShoppingFinalAmount(400);
        String query = "insert into payment (paymentID, openCoupon, shoppingFinalAmount, paymentStatus, shoppingCartID) values((select max(paymentID)+1 from payment), :openCoupon, :shoppingAmount, :paymentStatus, :shoppingCartID)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("openCoupon", payment.getOpenCoupon());
        paramMap.put("shoppingAmount", payment.getShoppingFinalAmount());
        paramMap.put("paymentStatus", payment.getPaymentStatus());
        paramMap.put("shoppingCartID", payment.getShoppingCartID());
        given(jdbcTemplate.update(query, paramMap)).willReturn(1);
        int result = paymentDAO.processPayment(payment);
        assertEquals(1, result);
    }

    @Test
    void searchPaymentByIDTest(){
        Payment pay = paymentDAO.searchPaymentByID(1);
        assertEquals(pay.getPaymentID(), 1);
    }

    @Test
    void noPaymentOfShoppingCartTest(){
        Payment pay = null;
        Payment pay2 = paymentDAO.searchPaymentByCartID(100);
        assertEquals(pay, pay2);
    }
    
}
