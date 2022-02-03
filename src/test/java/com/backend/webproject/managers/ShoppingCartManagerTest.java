package com.backend.webproject.managers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<ShoppingCart> list = new ArrayList<ShoppingCart>();
        list.add(cart);
        given(dao.getInSessionCart(cart.getUserID())).willReturn(cart);
        ShoppingCart result = manager.getInSessionCart(cart.getUserID());
        assertEquals(cart, result);
    }
}
