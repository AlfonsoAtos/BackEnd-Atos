package com.backend.webproject.managers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import com.backend.webproject.dao.ShoppingCartDAO;
import com.backend.webproject.entity.ShoppingCart;
import com.backend.webproject.mappers.ShoppingCartMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ShoppingCartManagerTest {
    @Autowired 
    ShoppingCartManager manager;
    @MockBean
    private ShoppingCartDAO dao;
    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Mock
    private ShoppingCartMapper mapper;

    private ShoppingCart getShoppingCart() {
		return new ShoppingCart(1, new Date(), "", 1);
	}

    @Test
    void searchInSessionCartTest(){
        ShoppingCart cart = getShoppingCart();
        given(dao.getInSessionCart(cart.getUserID())).willReturn(cart);
        ShoppingCart result = manager.getInSessionCart(cart.getUserID());
        assertEquals(cart, result);
    }

    @Test
    void completeCartTest(){
        given(dao.completeCart(2)).willReturn(1);
        int result = manager.completeCart(2);
        assertEquals(1, result);
    }

    @Test
    void createNewCartTest(){
        given(dao.createNewCart(2)).willReturn(1);
        int result = manager.createNewCart(2);
        assertEquals(1, result);
    }

}
