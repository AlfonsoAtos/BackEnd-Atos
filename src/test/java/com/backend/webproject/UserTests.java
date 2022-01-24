package com.backend.webproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.backend.webproject.controller.UserController;

@SpringBootTest
@AutoConfigureMockMvc
class UserTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserController userController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}
	
	@Test
	public void loginPage() throws Exception {
		this.mockMvc.perform(get("/user/login")).andExpect(status().isOk());
	}
	
	@Test
	public void signupPage() throws Exception {
		this.mockMvc.perform(get("/user/sign_up")).andExpect(status().isOk());
	}

}
