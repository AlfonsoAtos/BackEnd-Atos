package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.Map;

import com.backend.webproject.entity.Payment;
import com.backend.webproject.mappers.PaymentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentJDBC {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private PaymentMapper paymentMapper;

    public int processPayment(int openCoupon, int shoppingAmount, String paymentStatus, int shoppingCartID) {
        try {
            String query = "insert into payment (paymentID, openCoupon, shoppingFinalAmount, paymentStatus, shoppingCartID) values((select max(paymentID)+1 from payment), :openCoupon, :shoppingAmount, :paymentStatus, :shoppingCartID)";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("openCoupon", openCoupon);
            paramMap.put("shoppingAmount", shoppingAmount);
            paramMap.put("paymentStatus", paymentStatus);
            paramMap.put("shoppingCartID", shoppingCartID);
            return jdbcTemplate.update(query, paramMap);
        } catch (Exception e) {
            return 0;
        }
    }

    public Payment searchPaymentByID(int pid) {
        String sql = "select * from payment where paymentID=:pid";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pid", pid);
        Payment pay = jdbcTemplate.query(sql, paramMap, paymentMapper).get(0);
        return pay;
    }

    public Payment searchPaymentByCartID(int cid) {
        String sql = "select * from payment whereshoppingCartID=:cid";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("cid", cid);
        Payment pay = jdbcTemplate.query(sql, paramMap, paymentMapper).get(0);
        return pay;
    }
}
