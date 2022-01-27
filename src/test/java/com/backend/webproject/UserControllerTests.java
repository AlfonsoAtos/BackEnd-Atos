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

import com.backend.webproject.entity.User;
import com.backend.webproject.managers.UserManager;
import com.backend.webproject.dao.UserDAO;
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
			.andExpect(jsonPath("email", is(user.getEmail())));
//					.andReturn().getResponse().getContentAsString();
		
//		UserEntity userData = gson.fromJson(response, UserEntity.class);
//		System.out.println("response string: " + response);
//		System.out.println("response object: " + userData);
	}
}
