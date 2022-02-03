package com.backend.webproject.controllers;

import com.backend.webproject.managers.PaymentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PaymentManager manager;

    
}
