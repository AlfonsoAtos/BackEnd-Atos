<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Company</td>
		<td>Product Price</td>
		<td>Product Description</td>
		<td>Product Image Path</td>
		<td>Product Category ID</td>
		<td>Add to cart</td>
	</tr>
	<c:forEach var="product" items="${newProducts}">
		<tr>
			<td>${product.getPID()}</td>
			<td>${product.getPName()}</td>
			<td>${product.getPCompany()}</td>
			<td>${product.getPPrice()}</td>
			<td>${product.getPDescription()}</td>
			<td><img src="../../resources/img/${product.getPImagePath()}" width="20%"></td>
			<td>${product.getPCategoryID()}</td>
			<td><button>Add to cart</button></td>
		</tr>
	</c:forEach> 
	
</table>

</body>
</html>