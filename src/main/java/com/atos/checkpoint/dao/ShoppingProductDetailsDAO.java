package com.atos.checkpoint.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.atos.checkpoint.entity.Product;
import com.atos.checkpoint.entity.ShoppingCart;
import com.atos.checkpoint.entity.ShoppingProductDetails;
import com.atos.checkpoint.mappers.ShoppingProductDetailsMapper;

@Component
public class ShoppingProductDetailsDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    @Autowired
    private ShoppingProductDetailsMapper spdm;

    @Autowired
    private ProductDAO productDAO;

    public int addToCart(int pID) {
        // Fixed value for testing
        int userID = 1;

        ShoppingCart inSessionCart = shoppingCartDAO.getInSessionCart(userID);
        if (inSessionCart == null) {
            shoppingCartDAO.createNewCart(userID);
            inSessionCart = shoppingCartDAO.getInSessionCart(userID);
        }
        int inSessionCartId = inSessionCart.getShoppingCartID();

        Product product = productDAO.getProductById(pID);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("quantity", 1);
        params.put("cost", product.getPPrice());
        params.put("pID", product.getPID());
        params.put("scID", inSessionCartId);
        int productExists = jdbcTemplate.queryForObject(
                "SELECT COUNT(productID) FROM ShoppingProductDetails WHERE shoppingCartId = :scID AND productID = :pID",
                params, Integer.class);
        if (productExists == 1) {
            String sql = "UPDATE ShoppingProductDetails SET quantity = quantity + :quantity WHERE shoppingCartId = :scID AND productID = :pID";
            return jdbcTemplate.update(sql, params);
        } else {
            String sql = "INSERT INTO ShoppingProductDetails VALUES ((SELECT COALESCE(MAX(shoppingProductDetailsID) + 1, 1) FROM ShoppingProductDetails),:quantity,:cost,null,:pID,:scID)";
            return jdbcTemplate.update(sql, params);
        }
    }

    public List<ShoppingProductDetails> getAllDetailsFromCart(int cartID) {
        String sql = "select * from shoppingproductdetails where shoppingCartID=:cartID";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("cartID", cartID);
        List<ShoppingProductDetails> list = jdbcTemplate.query(sql, paramMap, spdm);
        return list;
    }

    public int getNumProductsInCart() {
        //Fixed value for testing
        int userID = 1;
        ShoppingCart inSessionCart = shoppingCartDAO.getInSessionCart(userID);
        if(inSessionCart != null) {
            int inSessionCartId = inSessionCart.getShoppingCartID();
            String sql = "SELECT SUM(quantity) FROM ShoppingProductDetails WHERE shoppingCartId = :inSessionCartId";
            int numProductsInCart = jdbcTemplate.queryForObject(sql, new HashMap<String, Object>() {{put("inSessionCartId", inSessionCartId);}}, Integer.class);
            return numProductsInCart;
        } else {
            return 0;
        }

    }
  
    public int removeFromCart(int shoppingProductDetailsID) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("spdid", shoppingProductDetailsID);
        int quantityOfItems = jdbcTemplate.queryForObject(
                "SELECT quantity FROM shoppingproductdetails WHERE SHOPPINGPRODUCTDETAILSID=:spdid", params,
                Integer.class);
        String query = "";
        if (quantityOfItems > 1) {
            query = "UPDATE shoppingproductdetails SET quantity=quantity-1 WHERE SHOPPINGPRODUCTDETAILSID=:spdid";
        } else {
            query = "DELETE from shoppingproductdetails WHERE SHOPPINGPRODUCTDETAILSID=:spdid";
        }
        int aux = 0;
        try {
            aux = jdbcTemplate.update(query, params); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    }

    public int finalizeShoppingProductDetail(ShoppingProductDetails spd){
        String query = "UPDATE shoppingproductdetails SET shoppingcost=:shoppingcost, costafterapplyingcoupon=:costafterapplyingcoupon WHERE shoppingProductDetailsID=:id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("shoppingcost", spd.getShoppingCost());
        params.put("costafterapplyingcoupon", spd.getCostAfterApplyingCoupon());
        params.put("id", spd.getShoppingProductDetailsID());
        return jdbcTemplate.update(query, params);
    }

}
