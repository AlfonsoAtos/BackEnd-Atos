package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.Map;

import com.backend.webproject.entity.Payment;
import com.backend.webproject.mappers.PaymentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentDAO {

    @Autowired
    JdbcTemplate temp;

    @Autowired
    private PaymentMapper paymentMapper;

    // int openCoupon, int shoppingAmount, String paymentStatus, int shoppingCartID
    public int processPayment(Payment payment) {
        try {
            String query = "insert into payment (paymentID, openCoupon, shoppingFinalAmount, paymentStatus, shoppingCartID) values((select max(paymentID)+1 from payment), :openCoupon, :shoppingAmount, :paymentStatus, :shoppingCartID)";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("openCoupon", payment.getOpenCoupon());
            paramMap.put("shoppingAmount", payment.getShoppingFinalAmount());
            paramMap.put("paymentStatus", payment.getPaymentStatus());
            paramMap.put("shoppingCartID", payment.getShoppingCartID());
            return temp.update(query, paramMap);
        } catch (Exception e) {
            return 0;
        }
    }

    public Payment searchPaymentByID(int paymentID) {
        String sql = "select * from payment where paymentID = ?";
        Payment pays = (Payment) temp.query(sql, new Object[] { paymentID }, paymentMapper).get(0);
        return pays;
    }

    public Payment searchPaymentByCartID(int shoppingCartID) {
        String sql = "select * from payment where shoppingCartID = ?";
        Payment pays = (Payment) temp.query(sql, new Object[] { shoppingCartID }, paymentMapper).get(0);
        return pays;
    }
}
