package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.backend.webproject.entity.Product;
import com.backend.webproject.mappers.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
    @Autowired
    private NamedParameterJdbcTemplate jtemp;

    @Autowired
    private ProductMapper ProductMapper;
    
    public List<Product> getNewProducts() {
        List<Product> newProducts = jtemp.query("SELECT * FROM Product ORDER BY productID DESC", ProductMapper);
        return newProducts;
	}

    public List<Product> searchProducts(String pName, String pCategoryID) {
        StringJoiner where = new StringJoiner(" AND ", " WHERE ", "").setEmptyValue("");
        if (pName != null && !pName.trim().isEmpty()) {
            where.add("regexp_like(productName, :pName, 'i')");
        }
        if (pCategoryID != null && !pCategoryID.trim().isEmpty()) {
            where.add("productCategoryID = :pCategoryID");
        }
        String sql = "SELECT * FROM Product" + where + " ORDER BY productName";
        Map<String, Object> params = new HashMap<>();
        params.put("pName", pName);
        params.put("pCategoryID", pCategoryID);
        List<Product> searchResult = jtemp.query(sql, params, ProductMapper);

        return searchResult;
    }

    public Product getProductById(int pID) {
        Product product = jtemp.queryForObject("SELECT * FROM Product WHERE productID = :pID", new HashMap<String, Object>() {{put("pID", pID);}}, ProductMapper);
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = jtemp.query(
            "SELECT * FROM Product ORDER BY productID ASC", ProductMapper);
        return allProducts;
    }

    public int insertNewProduct(int pID, String pName, String pCompany, float pPrice, String pDescription, String pImagePath, int pCategoryID)
	{
        return jtemp.update(
            "INSERT INTO Product Values(:pID, :pName, :pCompany, :pPrice, :pDescription, :pImagePath, :pCategoryID)",
            new HashMap<String, Object>() {{
                put("pID", pID);
                put("pName", pName);
                put("pCompany", pCompany);
                put("pPrice", pPrice);
                put("pDescription", pDescription);
                put("pImagePath", pImagePath);
                put("pCategoryID", pCategoryID);
            }});
	}
	
    public int updateProduct(int pID, String pName, String pCompany, float pPrice, String pDescription, String pImagePath, int pCategoryID) {
        return jtemp.update(
            "UPDATE Product SET productName = :pName, productCompany = :pCompany, productPrice = :pPrice, productDescription = :pDescription, productImagePath = :pImagePath, productCategoryId = :pCategoryID where productID  = :pID",
            new HashMap<String, Object>() {{
                put("pID", pID);
                put("pName", pName);
                put("pCompany", pCompany);
                put("pPrice", pPrice);
                put("pDescription", pDescription);
                put("pImagePath", pImagePath);
                put("pCategoryID", pCategoryID);
            }});
    }

	public int deleteProduct(int pID)
	{
        return jtemp.update("DELETE FROM Product WHERE productID = :pID", new HashMap<String, Object>() {{put("pID", pID);}});
	}

    public int getAutoProductId() {
    	try {    		
    		return jtemp.getJdbcTemplate().queryForObject("select COALESCE(MAX(productID) + 1, 1) FROM Product", Integer.class);
    	} catch (DataAccessException err) {
    		System.out.println("Error getting Product ID, reason: '" + err + "'");
		}
    	return 0;
    }
}