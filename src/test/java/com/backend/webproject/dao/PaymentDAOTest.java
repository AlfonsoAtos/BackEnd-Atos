package com.backend.webproject.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.webproject.entity.Payment;
import com.backend.webproject.mappers.PaymentMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class PaymentDAOTest {

    @InjectMocks
    PaymentDAO paymentDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private PaymentMapper paymentMapper;

    private Payment createPayment() {
        return new Payment(1, 1, 1, "InNegotiation", 1);
    }

    @Test
    void processPaymentTest() {
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
    public void searchPaymentByIDTest() {
        Payment payment = createPayment();
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(payment);
        given(jdbcTemplate.query(
                "select * from payment where paymentID = ?",
                new Object[] { payment.getPaymentID() },
                paymentMapper))
                        .willReturn(paymentList);

        Payment result = paymentDAO.searchPaymentByID(payment.getPaymentID());
        assertEquals(payment, result);
    }

    @Test
    void noPaymentOfShoppingCartTest() {
        Payment payment = createPayment();
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(payment);
        given(jdbcTemplate.query(
                "select * from payment where shoppingCartID = ?",
                new Object[] { payment.getShoppingCartID() },
                paymentMapper))
                        .willReturn(paymentList);

        Payment result = paymentDAO.searchPaymentByCartID(payment.getShoppingCartID());
        assertEquals(payment, result);
    }

}
