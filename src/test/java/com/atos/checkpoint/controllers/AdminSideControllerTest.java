package com.atos.checkpoint.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//----------------------------------------------------------

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AdminSideControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerRoutingTest() throws Exception {
        this.mockMvc.perform(get("/admin-side/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/admin.jsp"));
    }
    
    @Test
    public void couponRoutingTest() throws Exception {
        this.mockMvc.perform(get("/admin-side/coupons"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/coupons.jsp"));
        
//        this.mockMvc.perform(get("/admin-side/updateCoupon/1"))
//	        .andExpect(status().is(200))
//	        .andExpect(redirectedUrl("/WEB-INF/jsp/updateCouponDataForm.jsp"));

        this.mockMvc.perform(get("/admin-side/insertCoupon"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/admin-side/coupons"));
        
        this.mockMvc.perform(get("/admin-side/updateCouponData/1"))
	        .andExpect(status().is(302))
	        .andExpect(redirectedUrl("/admin-side/coupons"));
        
        this.mockMvc.perform(get("/admin-side/deleteCoupon/1"))
	        .andExpect(status().is(302))
	        .andExpect(redirectedUrl("/admin-side/coupons"));
    }
    
    @Test
    public void eventsRoutingTest() throws Exception {
        this.mockMvc.perform(get("/admin-side/events"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/events.jsp"));
        
        this.mockMvc.perform(get("/admin-side/updateEvents/1"))
	        .andExpect(status().isOk())
	        .andExpect(forwardedUrl("/WEB-INF/jsp/updateEventsData.jsp"));
        

        this.mockMvc.perform(get("/admin-side/insertEvent"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/admin-side/events"));
        
        this.mockMvc.perform(get("/admin-side/updateEventsData/1"))
	        .andExpect(status().is(302))
	        .andExpect(redirectedUrl("/admin-side/events"));
        
//        this.mockMvc.perform(get("/admin-side/deleteEvents/1"))
//	        .andExpect(status().is(302))
//	        .andExpect(redirectedUrl("/admin-side/events"));
    }
}
