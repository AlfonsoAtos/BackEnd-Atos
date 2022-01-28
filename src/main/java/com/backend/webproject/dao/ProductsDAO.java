package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.backend.webproject.mappers.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductsDAO {

    JdbcTemplate temp;

    public ProductsDAO(JdbcTemplate temp) {
        this.temp = temp;
    }

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getNewProducts() {
        List<Product> newProducts = jdbcTemplate.query(
                "SELECT * FROM (SELECT * FROM Product ORDER BY productID DESC) WHERE ROWNUM <= 8", productMapper);
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
        List<Product> searchResult = jdbcTemplate.query(sql, params, productMapper);

        return searchResult;
    }

    public Product getProductById(int pID) {
        Product product = jdbcTemplate.queryForObject("SELECT * FROM Product WHERE productID = :pID",
                new HashMap<String, Object>() {
                    {
                        put("pID", pID);
                    }
                }, productMapper);
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = jdbcTemplate.query(
                "SELECT * FROM Product ORDER BY productID ASC", productMapper);
        return allProducts;
    }

    public void insertNewProduct(int pID, String pName, String pCompany, int pPrice, String pDescription, String pImagePath, int pCategoryID)
	{
		temp.update("INSERT INTO Product Values(?,?,?,?,?,?,?)", new Object[] {pID, pName, pCompany, pPrice, pDescription, pImagePath, pCategoryID});
        // String query = "INSERT INTO Product VALUES(:pID, :pName, :pCompany, :pPrice, :pDescription, :pImagePath, :pCategoryID)";
        // Map<String, Object> paramMap = new HashMap<String, Object>();
        // paramMap.put("pID", pID);
        // paramMap.put("pName", pName);
        // paramMap.put("pCompany", pCompany);
        // paramMap.put("pPrice", pPrice);
        // paramMap.put("pDescription", pDescription);
        // paramMap.put("pImagePath", pImagePath);
        // paramMap.put("pCategoryID", pCategoryID);
        // jdbcTemplate.update(query, paramMap);
	}
	
    public void updateProduct(int pID, String pName, String pCompany, int pPrice, String pDescription, String pImagePath, int pCategoryID) {
        temp.update("UPDATE Product SET productName = ?, productCompany = ?, productPrice = ?, productDescription = ?, productImagePath = ?, productCategoryId = ? where productID=?",
                new Object[] { pName, pCompany, pPrice, pDescription, pImagePath, pCategoryID, pID });
        // String query = "UPDATE Product SET productName = :pName, productCompany = :pCompany, productPrice = :pPrice, productDescription = :pDescription, productImagePath = :pImagePath, productCategoryId = :pCategoryID where productID = :pID";
        // Map<String, Object> paramMap = new HashMap<String, Object>();
        // paramMap.put("pName", pName);
        // paramMap.put("pCompany", pCompany);
        // paramMap.put("pPrice", pPrice);
        // paramMap.put("pDescription", pDescription);
        // paramMap.put("pImagePath", pImagePath);
        // paramMap.put("pCategoryID", pCategoryID);
        // paramMap.put("pID", pID);
        // System.out.println(jdbcTemplate.update(query, paramMap));
    }

	public void deleteProduct(int pID)
	{
		temp.update("DELETE FROM Product WHERE productID = ?", new Object[] {pID});
        // String query = "DELETE FROM Product WHERE productID = :pID";
        // Map<String, Object> paramMap = new HashMap<String, Object>();
        // paramMap.put("pID", pID);
        // jdbcTemplate.update(query, paramMap);
	}

    public int getAutoProductId() {
        int newProductId = temp.queryForObject("SELECT MAX(productID) + 1 FROM Product", Integer.class);
        return newProductId;
        // jdbcTemplate.queryForObject("SELECT MAX(productID) + 1 FROM Product", Integer.class);
    }

}