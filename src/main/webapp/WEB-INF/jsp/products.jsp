<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="../../resources/src/addToCart.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>Products</title>
</head>
<body>
    <div class="container-fluid p-0">
        <nav id="navbar" class="navbar navbar-expand-lg">
            <div class="container">
                <div class="logo-nav">
                    <img src="../../resources/img/logo-g.jpg" />
                </div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a href="/" class="nav-link active" aria-current="page">Home</a>
                        </li>
                        <form action="search" class="d-flex">
                            <c:forEach var="pCategory" items="${productCategories}">
                                <button class="nav-btn" type="submit" name="pcatid" value="${pCategory.pcID}">${pCategory.pcName}</button>
                            </c:forEach>
                        </form> 
                    </ul>
                    <a id="cartBtn" href="#" class="ms-4">
                        <i class="fas fa-shopping-cart"></i>
                        <span id="cartCounter">${numProductsInCart}</span>
                    </a>
                    <a href="#" class="ms-4"><i class="fas fa-user"></i></a>
                </div>
            </div>
        </nav>
        <div class="container mt-5 mb-5">
            <form action="search" class="d-flex">
                <select name="pcatid" id="categories">
                    <option value="">Select a category</option>
                    <c:forEach var="pCategory" items="${productCategories}">
                        <option value="${pCategory.pcID}">${pCategory.pcName}</option>
                    </c:forEach>
				</select>
                <input name="pname" class="form-control" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
			<c:forEach var="product" items="${searchResult}" varStatus="p">
				<c:if test="${(p.index % 4 == 0)}"><div class="row d-flex align-items-center mt-4 mb-4"></c:if>
					<div class="col-3 d-flex justify-content-center">
                        <a data-bs-toggle="modal" data-bs-target="#modal${product.getPID()}">
                            <div class="card border-0 product-card">
                                <img src="../../resources/img/${product.getPImagePath()}" class="card-img-top" alt="">
                                <div class="card-body">
                                    <h5 class="card-title">${product.getPName()}</h5>
                                    <div id="short-desc-container">
                                        <p id="short-desc-txt">${product.getPDescription()}</p>
                                    </div>
                        </a>
                                    <div class="d-flex align-items-center mt-2">
                                        <span class="fa-stack cart-icon-group me-auto visible" data-pID="${product.getPID()}" onclick="addToCart(this)">
                                            <i id="cart-icon-bg" class="fas fa-circle fa-stack-2x"></i>
                                            <i class="fas fa-cart-plus fa-sm fa-stack-1x icon"></i>
                                        </span>
                                        <p class="card-text text-end">$${product.getPFormattedPrice()}</p>
                                    </div>
                                </div>
                            </div>
                    </div>

                    <div id="modal${product.getPID()}" class="modal" tabindex="-1">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content border-0">
                                <div class="card border-0">
                                    <img src="../../resources/img/${product.getPImagePath()}" class="card-img-top" alt="">
                                    <div class="card-body">
                                        <h5 class="card-title">${product.getPName()}</h5>
                                        <p class="card-text">${product.getPDescription()}</p>
                                        <div class="d-flex justify-content-between align-items-end">
                                            <button type="button" class="btn btn-success" data-pID="${product.getPID()}" onclick="addToCart(this)">
                                                <i class="fas fa-cart-plus"></i>  Add to cart
                                            </button>
                                            <p class="card-text price-in-modal">$${product.getPFormattedPrice()}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

				<c:if test="${((p.index + 1) % 4 == 0)}"></div></c:if>
			</c:forEach>
        </div>

        <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 2000">
            <div id="addToCartNotification" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <i class="fas fa-cart-plus me-2"></i>
                    <strong class="me-auto">Shopping Cart</strong>
                    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                    Product added to cart.
                </div>
            </div>
        </div>
    </div>
    <script>
        document.querySelectorAll('.card').forEach(item => {
            item.addEventListener('mouseenter', e => {
                let cartIcon = e.currentTarget.querySelector(".cart-icon-group");
                cartIcon.style.visibility = "visible";
            });
        });
        document.querySelectorAll('.card').forEach(item => {
            item.addEventListener('mouseleave', e => {
                let cartIcon = e.currentTarget.querySelector(".cart-icon-group");
                cartIcon.style.visibility = "hidden";
            });
        });
    </script>
</body>
</html>