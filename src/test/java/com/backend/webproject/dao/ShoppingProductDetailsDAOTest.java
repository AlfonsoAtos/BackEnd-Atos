package com.backend.webproject.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.backend.webproject.entity.ShoppingProductDetails;
import com.backend.webproject.mappers.ShoppingProductDetailsMapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class ShoppingProductDetailsDAOTest {

    @InjectMocks
    ShoppingProductDetailsDAO shoppingProductDetailsDAO;

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Mock
    private ShoppingProductDetailsMapper shoppingProductDetailsMapper;

    private ShoppingProductDetails createShoppingProductDetails() {
        return new ShoppingProductDetails(1, 1, 30, 25, 1, 1);
    }

    // @Test
    // void addToCartTest() {
    //
    // ShoppingProductDetails details = createShoppingProductDetails();
    //
    // List<ShoppingProductDetails> detailsList = new
    // ArrayList<ShoppingProductDetails>();
    // detailsList.add(details);
    //
    // given(jdbcTemplate.query(
    // "SELECT COUNT(productID) FROM ShoppingProductDetails WHERE shoppingCartId =
    // :scID AND productID = :pID",
    // new HashMap<String, Object>() {
    // {
    // put("scID", details.getShoppingCartID());
    // put("pID", details.getProductID());
    // }
    // }, shoppingProductDetailsMapper))
    // .willReturn(detailsList);
    //
    // assertEquals(detailsList, shoppingProductDetailsDAO.addToCart(1, 1));
    // }

    @Test
    void getAllDetailsFromCartTest() {

        ShoppingProductDetails details = createShoppingProductDetails();

        List<ShoppingProductDetails> detailsList = new ArrayList<ShoppingProductDetails>();
        detailsList.add(details);

        given(jdbcTemplate.query(
                "select * from shoppingproductdetails where shoppingCartID=:cartID",
                new HashMap<String, Object>() {
                    {
                        put("cartID", details.getShoppingCartID());
                    }
                }, shoppingProductDetailsMapper))
                        .willReturn(detailsList);

        assertEquals(detailsList, shoppingProductDetailsDAO.getAllDetailsFromCart(1));
    }

    // @Test
    // void getNumProductsInCartTest() {
    //
    // }
    //
    // @Test
    // void removeFromCartTest() {
    //
    // }
    //
    // @Test
    // void removeFromCart2Test() {
    //
    // }
    //
    // @Test
    // void addToCart2Test() {
    //
    // }
    //
    // @Test
    // void finalizeShoppingProductDetailTest() {
    //
    // ShoppingProductDetails details = createShoppingProductDetails();
    //
    // List<ShoppingProductDetails> detailsList = new
    // ArrayList<ShoppingProductDetails>();
    // detailsList.add(details);
    //
    // given(jdbcTemplate.query(
    // "UPDATE shoppingproductdetails SET shoppingcost=:shoppingcost,
    // costafterapplyingcoupon=:costafterapplyingcoupon WHERE
    // shoppingProductDetailsID=:id",
    // new HashMap<String, Object>() {
    // {
    // put("shoppingcost", 1);
    // }
    // }, shoppingProductDetailsMapper))
    // .willReturn(detailsList);
    //
    // assertEquals(detailsList,
    // shoppingProductDetailsDAO.finalizeShoppingProductDetail(1));
    // }
    //
    // @Test
    // void savePriceAfterCouponTest() {
    //
    // ShoppingProductDetails details = createShoppingProductDetails();
    //
    // List<ShoppingProductDetails> detailsList = new
    // ArrayList<ShoppingProductDetails>();
    // detailsList.add(details);
    //
    // given(jdbcTemplate.query(
    // "UPDATE shoppingproductdetails SET
    // costafterapplyingcoupon=:costafterapplyingcoupon WHERE
    // shoppingCartID=:shoppingCartID AND productID=:productID",
    // new HashMap<String, Object>() {
    // {
    // put("shoppingCartID", details.getShoppingCartID());
    // put("productID", 3);
    // put("costafterapplyingcoupon", details.getCostAfterApplyingCoupon());
    // }
    // }, shoppingProductDetailsMapper))
    // .willReturn(detailsList);
    //
    // assertEquals(detailsList, shoppingProductDetailsDAO.savePriceAfterCoupon(1,
    // 1, 1));
    // }
}
