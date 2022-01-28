package com.backend.webproject.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.atos.checkpoint.entity.User;
import com.atos.checkpoint.managers.UserManager;
import com.google.gson.Gson;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserManager userManager;
	
	@Test
	public void controllerRoutingTest() throws Exception {
		this.mockMvc.perform(get("/user/login"))
	     .andExpect(status().isOk())
	     .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"));
		
		this.mockMvc.perform(get("/user/sign_up"))
	     .andExpect(status().isOk())
	     .andExpect(forwardedUrl("/WEB-INF/jsp/sign_up.jsp"));
		
		this.mockMvc.perform(get("/user/list"))
	     .andExpect(status().isOk())
	     .andExpect(forwardedUrl("/WEB-INF/jsp/user_list.jsp"));
	}
	
	@Test
	public void loginUserAPITest() throws Exception {
		User user = new User(1, "al@gmail.com", "pass123", "Alberto", "8110", 1);
		
		given(userManager.loginUser("al@gmail.com", "pass123")).willReturn(user);
		
//		Gson gson = new Gson();
		
		String json = "{ \"email\": \"al@gmail.com\", \"password\": \"pass123\" }";
		
		System.out.println("json string: " + json);
		
//		String response = 
		mockMvc.perform(
			post("/user/api/login")
			.content(json)
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(jsonPath("email", is(user.getEmail())))
			.andExpect(jsonPath("password", is(user.getPassword())))
			.andExpect(jsonPath("fullname", is(user.getFullname())))
			.andExpect(jsonPath("number", is(user.getNumber())))
			.andExpect(jsonPath("id", is(user.getId())))
			.andExpect(jsonPath("role", is(user.getRole())));
//					.andReturn().getResponse().getContentAsString();
		
//		UserEntity userData = gson.fromJson(response, UserEntity.class);
//		System.out.println("response string: " + response);
//		System.out.println("response object: " + userData);
	}
	
	@Test
	public void signupUserAPITest() throws Exception {
		User user = new User(1, "al@gmail.com", "pass123", "Alberto", "8110", 1);
		
		given(userManager.signupUser("al@gmail.com", "pass123", "Alberto", "8110")).willReturn(user);
		
		Gson gson = new Gson();
		String json = gson.toJson(user);
		
		System.out.println("json string: " + json);
		
//		String response = 
		mockMvc.perform(
			post("/user/api/signup")
			.content(json)
			.accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(jsonPath("email", is(user.getEmail())))
			.andExpect(jsonPath("password", is(user.getPassword())))
			.andExpect(jsonPath("fullname", is(user.getFullname())))
			.andExpect(jsonPath("number", is(user.getNumber())))
			.andExpect(jsonPath("id", is(user.getId())))
			.andExpect(jsonPath("role", is(user.getRole())));
//					.andReturn().getResponse().getContentAsString();
		
//		UserEntity userData = gson.fromJson(response, UserEntity.class);
//		System.out.println("response string: " + response);
//		System.out.println("response object: " + userData);
	}
}
