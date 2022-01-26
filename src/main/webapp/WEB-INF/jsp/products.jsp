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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>Home</title>
</head>
<body>
    <div class="container-fluid p-0">
        <nav id="navbar" class="navbar navbar-expand-lg">
            <div class="container">
                <a class="navbar-brand" href="#">Logo</a>
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
                    <a href="#"><i class="fas fa-shopping-cart"></i></a>
                    <a href="#"><i class="fas fa-user"></i></a>
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
						<a data-bs-toggle="modal" data-bs-target="#myModal">
							<div class="card border-0 product-card">
								<img src="../../resources/img/${product.getPImagePath()}" class="card-img-top" alt="">
								<div class="card-body">
									<h5 class="card-title">${product.getPName()}</h5>
									<div class="d-flex justify-content-end align-items-center">
										<span class="fa-stack cart-icon-group" onclick="$.post('addtocart/${product.getPID()}')">
                                            <i id="cart-icon-bg" class="fas fa-circle fa-stack-2x"></i>
                                            <i class="fas fa-cart-plus fa-sm fa-stack-1x icon"></i>
                                        </span>
										<p class="card-text text-end">$${product.getPPrice()}</p>
									</div>
								</div>
							</div>
						</a>
					</div>
				<c:if test="${((p.index + 1) % 4 == 0)}"></div></c:if>
			</c:forEach>
        </div>
            

        <!-- <div id="myModal" class="modal" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content border-0">
                    <div class="card border-0">
                        <img src="./img/splatoon.png" class="card-img-top" alt="">
                        <div class="card-body">
                            <h5 class="card-title">Product Name</h5>
                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                            <div class="d-flex justify-content-between">
                                <p class="card-text">$00.00</p>
                                <button type="button" class="btn btn-success"><i class="fas fa-cart-plus"></i>  Add to cart</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> -->

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