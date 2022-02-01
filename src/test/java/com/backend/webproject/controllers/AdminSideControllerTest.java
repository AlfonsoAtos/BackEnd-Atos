package com.backend.webproject.controllers;

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

        this.mockMvc.perform(get("/admin-side/insertCoupon"))
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/admin-side/coupons"));

    }
}
