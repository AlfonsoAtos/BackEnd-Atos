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
		<td>Actions</td>
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
			<td>
                <svg
                    fill="blue"
                    viewBox="0 0 20 20"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        d="M17.414 2.586a2 2 0 00-2.828 0L7 10.172V13h2.828l7.586-7.586a2 2 0 000-2.828z"
                    ></path>
                    <path
                        fill-rule="evenodd"
                        d="M2 6a2 2 0 012-2h4a1 1 0 010 2H4v10h10v-4a1 1 0 112 0v4a2 2 0 01-2 2H4a2 2 0 01-2-2V6z"
                        clip-rule="evenodd"
                    ></path>
                </svg>
                <svg
                    fill="red"
                    viewBox="0 0 20 20"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        fill-rule="evenodd"
                        d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                        clip-rule="evenodd"
                    ></path>
                </svg>
            </td>
		</tr>
	</c:forEach> 
	
</table>

</body>
</html>