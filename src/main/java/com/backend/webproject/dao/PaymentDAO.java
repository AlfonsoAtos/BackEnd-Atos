package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.webproject.entity.Payment;
import com.backend.webproject.mappers.PaymentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private PaymentMapper paymentMapper;
    //int openCoupon, int shoppingAmount, String paymentStatus, int shoppingCartID
    public int processPayment(Payment payment)
	{
        try{
            String query = "insert into payment (paymentID, openCoupon, shoppingFinalAmount, paymentStatus, shoppingCartID) values((select max(paymentID)+1 from payment), :openCoupon, :shoppingAmount, :paymentStatus, :shoppingCartID)";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("openCoupon", payment.getOpenCoupon());
            paramMap.put("shoppingAmount", payment.getShoppingFinalAmount());
            paramMap.put("paymentStatus", payment.getPaymentStatus());
            paramMap.put("shoppingCartID", payment.getShoppingCartID());
		    return jdbcTemplate.update(query,paramMap);	
        } catch (Exception e){
            return 0;
        }
	}
    
    public Payment searchPaymentByID(int pid)
	{
        String sql = "select * from payment where paymentID=:pid";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pid", pid);
		List<Payment> pays = jdbcTemplate.query(sql, paramMap, paymentMapper);
        if(pays.size()>0){
            return pays.get(0);
        }
		return null;
	}

    public Payment searchPaymentByCartID(int cid)
	{
        String sql = "select * from payment whereshoppingCartID=:cid";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("cid", cid);
        List<Payment> pays = jdbcTemplate.query(sql, paramMap, paymentMapper);
		if(pays.size()>0){
            return pays.get(0);
        }
		return null;
	}
}
