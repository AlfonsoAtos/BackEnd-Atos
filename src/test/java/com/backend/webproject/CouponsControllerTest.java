package com.backend.webproject;

import org.junit.Test;
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
class CouponsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerRoutingTest() throws Exception {
        this.mockMvc.perform(get("/admin-side/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/admin.jsp"));

        this.mockMvc.perform(get("/admin-side/coupons"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/coupons.jsp"));

        this.mockMvc.perform(get("/admin-side/insertCoupon"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/coupons.jsp"));

    }
}
