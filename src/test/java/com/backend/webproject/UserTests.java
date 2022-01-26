package com.backend.webproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.mockito.Mockito.*;

import com.backend.webproject.controller.UserAPI;
import com.backend.webproject.controller.UserController;
import com.backend.webproject.entity.UserEntity;
import com.backend.webproject.jtemp.UserDAO;
import com.google.gson.Gson;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@AutoConfigureMockMvc
class UserTests {
	
	@Autowired
	private MockMvc mockMvc;

//	@Autowired
//	private UserController userController;
//	
//	@MockBean 
//	private UserCRUD userCRUD;
	
//	@Test
//	void contextLoads() throws Exception {
//		assertThat(userController).isNotNull();
//	}
	
	@MockBean 
	private UserDAO userDB;
	
	@Test
	public void testingControllerRoutes() throws Exception {
		this.mockMvc.perform(get("/user/login"))
	     .andExpect(status().isOk())
	     .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"));
		
		this.mockMvc.perform(get("/user/sign_up"))
	     .andExpect(status().isOk())
	     .andExpect(forwardedUrl("/WEB-INF/jsp/sign_up.jsp"));
	}
	
	@Test
	public void loginUser() throws Exception {
		UserEntity user = new UserEntity(1, "al@gmail.com", "pass123", "Alberto", "8110", 1);
//		MockHttpServletRequest request = new MockHttpServletRequest();
//		request.addParameter("email", "al@gmail.com");
//		request.addParameter("password", "pass123");
		
		given(userDB.getUser("al@gmail.com")).willReturn(user);
//		when((userDB.getUser("al@gmail.com")).thenReturn(user));
		
		Gson gson = new Gson();
		
//		String json = gson.toJson(user);
		String json = "{ \"email\": \"al@gmail.com\", \"password\": \"pass123\" }";
		
		System.out.println("json string: " + json);
		
//		mockMvc.perform(get("/users/1/mobile")
//		        .accept(MediaType.APPLICATION_JSON))
//		        .andExpect(status().isOk())
//		        .andDo(print())
//		        .andExpect(content().string("iPhone"))
		
//		String response = 
				mockMvc.perform(
					post("/api/user/login")
					.content(json)
					.accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(jsonPath("email", is(user.getEmail())));
//					.andReturn().getResponse().getContentAsString();
		
//		UserEntity userData = gson.fromJson(response, UserEntity.class);
//		System.out.println("response string: " + response);
//		System.out.println("response object: " + userData);
		// MvcResult result =
//		mockMvc.perform(post("/api/user/login")
//				.contentType(MediaType.APPLICATION_JSON)
//              //  .content("{ username: " + user.getUsername() + ", password: " + user.getPassword() + " }") 
//				)
//				.andExpect(status().isOk())
//				// .andExpect(jsonPath("password", is(user.getPassword())))
//				// .andExpect(jsonPath("$.username", is(user.getUsername())));
//				.andReturn();
		// result.getResponse().equals(user);
		// String userResponse = result.getResponse().getContentAsString();
		// System.out.println(result.getResponse().equals(user));
	}
	
	@Test
	public void signupPage() throws Exception {
		this.mockMvc.perform(get("/user/sign_up")).andExpect(status().isOk());
	}

}
