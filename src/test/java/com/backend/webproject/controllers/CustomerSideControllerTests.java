package com.backend.webproject.controllers;

import com.backend.webproject.managers.CustomerSideManager;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.backend.webproject.entity.User;
import com.backend.webproject.managers.UserManager;
import com.google.gson.Gson;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerSideControllerTests {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private CustomerSideManager customerSideManager;
	@Mock
	private Model model;
	
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
		int uID = 1;
		int numProductsInCart = 5;
		given(customerSideManager.getNumProductsInCartService(uID, model)).willReturn(2);
		
		mockMvc.perform(
			post("/numproductsincart/" + uID))
			.andDo(print());
	}

	
    
}
