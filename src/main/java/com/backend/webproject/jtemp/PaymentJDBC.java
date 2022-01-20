package com.backend.webproject.jtemp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentJDBC {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private PaymentMapper paymentMapper;

    public void processPayment(int pid, int openCoupon, int shoppingAmount, String paymentStatus, int shoppingCartID)
	{
        String query = "insert into payment values(:pid, :openCoupon, :shoppingAmount, :paymentStatus, :shoppingCartID)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pid", pid);
        paramMap.put("openCoupon", openCoupon);
        paramMap.put("shoppingAmount", shoppingAmount);
        paramMap.put("paymentStatus", paymentStatus);
        paramMap.put("shoppingCartID", shoppingCartID);
		jdbcTemplate.update(query,paramMap);	
	}
    
    public Payment searchPaymentByID(int pid)
	{
        String sql = "select * from payment where pid=:pid";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pid", pid);
		Payment pay = jdbcTemplate.query(sql, paramMap, paymentMapper).get(0);
		return pay;
	}
}
