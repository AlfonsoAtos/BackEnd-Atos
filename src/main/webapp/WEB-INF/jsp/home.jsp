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
	<a href="/">Home</a>
	<a href="shooter">Shooter</a>
	<a href="rpg">RPG</a>
	<a href="simulation">Simulation</a>
	<a href="vr">VR</a>
	<a href="strategy">Strategy</a>
	<a href="/user/login">Login</a>
	<a href="/user/sign_up">Sign up</a>
	<a href="/admin/login">Login Admin</a>
	<a href="/admin-side/">Admin Dashboard</a>
<form action="search">
    <input name="pname" class="form-control" type="search" placeholder="Enter a prouduct" aria-label="Search">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>

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