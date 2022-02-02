package com.atos.checkpoint.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.atos.checkpoint.entity.ShoppingCart;
import com.atos.checkpoint.mappers.ShoppingCartMapper;

@SpringBootTest
class ShoppingCartDAOTests {
	@InjectMocks
	private ShoppingCartDAO shoppingCartDAO;
	
	@Mock
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Mock
    private ShoppingCartMapper scm;
	
	private ShoppingCart getShoppingCart() {
		return new ShoppingCart(1, new Date(), "", 1);
	}

	@Test
	void getAllCompletedCartsTest() {
		ShoppingCart cart = getShoppingCart();
		
		List<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
		cartList.add(cart);
		
		given(jdbcTemplate.query(
			"select * from shoppingCart where cartStatus='Complete' and userID=:userID",
			new HashMap<String, Object>() {{
				put("userID", cart.getUserID());
			}},
			scm))
			.willReturn(cartList);
		
		assertEquals(cartList, shoppingCartDAO.getAllCompletedCarts(1));
	}
	
	@Test
	void getAllCompletedCartsEmptyTest() {
		
		List<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
		
		given(jdbcTemplate.query(
			"select * from shoppingCart where cartStatus='Complete' and userID=:userID",
			new HashMap<String, Object>() {{
				put("userID", 1);
			}},
			scm))
			.willReturn(cartList);
		
		assertEquals(null, shoppingCartDAO.getAllCompletedCarts(1));
	}
	
	@Test
	void getInSessionCartTest() {
		ShoppingCart cart = getShoppingCart();
		
		List<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
		cartList.add(cart);
		
		given(jdbcTemplate.query(
			"select shoppingCartID, creationDate, cartStatus, userID from shoppingCart where cartStatus='Insession' and userID=:userID",
			new HashMap<String, Object>() {{
				put("userID", cart.getUserID());
			}},
			scm))
			.willReturn(cartList);
		
		assertEquals(cart, shoppingCartDAO.getInSessionCart(1));
	}

	@Test
	void createNewCartTest() {		
		given(jdbcTemplate.update(
			"insert into shoppingCart values ((select COALESCE(MAX(shoppingCartID) + 1, 1) from shoppingCart), (SELECT SYSDATE FROM DUAL), 'Insession', :userID)",
			new HashMap<String, Object>() {{
				put("userID", 1);
			}}))
			.willReturn(1);
		
		assertEquals(1, shoppingCartDAO.createNewCart(1));
	}

	@Test
	void completeCartTest() {		
		given(jdbcTemplate.update(
			"update shoppingCart set cartStatus='Complete' where shoppingCartID=:cartID",
			new HashMap<String, Object>() {{
				put("cartID", 3);
			}}))
			.willReturn(1);
		
		assertEquals(1, shoppingCartDAO.completeCart(3));
	}
}
