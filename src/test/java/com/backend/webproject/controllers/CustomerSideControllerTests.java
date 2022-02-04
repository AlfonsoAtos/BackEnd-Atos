package com.backend.webproject.controllers;

import com.backend.webproject.managers.CustomerSideManager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerSideControllerTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CustomerSideManager customerSideManager;
	
    @Test
	public void controllerRoutingTest() throws Exception {	
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"));
		
		this.mockMvc.perform(get("/search"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/jsp/products.jsp"));
	}

	@Test
	public void getNumProductsInCartServiceTest() throws Exception {
		given(customerSideManager.getNumProductsInCartService(1)).willReturn(2);
		
		MvcResult mvcResult = mockMvc.perform(
			post("/numproductsincart/1"))
//			.andDo(print())
			.andExpect(status().isOk())
			.andReturn();
		
		mvcResult.equals(2);
	}
	
	@Test
	public void addToCartServiceTest() throws Exception {
		given(customerSideManager.addToCartService(2, 4)).willReturn(1);
		
		this.mockMvc.perform(post("/addtocart/2/4"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"));
	}
}
