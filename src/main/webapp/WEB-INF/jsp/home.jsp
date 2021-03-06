<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <title>Home</title>
</head>
<body>
    <div class="container-fluid p-0">
        <nav id="navbar" class="navbar navbar-expand-lg">
            <div class="container">
                <div class="logo-nav me-5">
                    <a href="/">    
                        <img src="../../resources/img/logo.png" class="p-0"/>
                    </a>
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
                    <span>
                        <span class="d-none" id="user-icons">
                            <a id="cartBtn" href="#" class="ms-4">
                                <i class="fas fa-shopping-cart"></i>
                                <span id="cartCounter"></span>
                            </a>
                            <span class="text-white" ><i class="fas fa-user ms-3"></i></span>
                            <span class="text-white" id="user-name">Name</span>
                            <button type="button" class="btn btn-danger ms-3" onclick="logout()">Log out</button>
                        </span>
                        <span class="d-none" id="login-button">
                            <a href="/user/login/"><button type="button" class="btn btn-primary">Log in</button></a>
                        </span>
                    </span>
                </div>
            </div>
        </nav>
        <div id="bannerCarousel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators invisible">
                <button type="button" data-bs-target="#bannerCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#bannerCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#bannerCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner carousel-main pb-2">
                <c:forEach var="product" items="${newProducts}" varStatus="p">
                    <c:if test="${(p.index % 1 == 0)}"><div class="carousel-item ${(p.index == 0) ? 'active' : ''}"></c:if>
                        <img src="../../resources/img/${product.getPImagePath()}" class="d-block w-100" alt="">
                    <c:if test="${((p.index + 1) % 1 == 0)}"></div></c:if>
                </c:forEach>
            </div>
            <div class="bg-text px-5 py-auto">
                <form action="search">
                    <h5 id="banner-title" class="display-5 fw-bold">Search for your next adventure!</h5>
                    <input name="pname" class="form-control mt-3" type="search" placeholder="Search Products" aria-label="Search">
                    <button class="btn btn-success mt-3" type="submit">Search</button>
                </form>
            </div>
            <button class="carousel-control-prev invisible" type="button" data-bs-target="#bannerCarousel" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next invisible" type="button" data-bs-target="#bannerCarousel" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
        <div class="container mt-5 mb-5">
            <div id="newerProductsCarousel" class="carousel slide product-carousel" data-ride="carousel" data-bs-interval="false">
                <div class="carousel-inner">
                    <div class="row">
                        <div class="col-11 d-flex align-items-end">
                            <p class="lead mb-0">Newer Games</p>
                        </div>
                        <div class="col-1 d-flex justify-content-between">
                            <button class="btn carousel-button" type="button" data-bs-target="#newerProductsCarousel" data-bs-slide="prev">
                                <i class="fas fa-angle-left"></i>
                            </button>
                            <button class="btn carousel-button" type="button" data-bs-target="#newerProductsCarousel" data-bs-slide="next">
                                <i class="fas fa-angle-right"></i>
                            </button>
                        </div>
                    </div>
                    <hr class="border-1">
					<c:forEach var="product" items="${newProducts}" varStatus="p">
						<c:if test="${(p.index % 4 == 0)}"><div class="carousel-item ${(p.index == 0) ? 'active' : ''}"><div class="row d-flex align-items-center"></c:if>
							<div class="col-3 d-flex justify-content-center">
								<a data-bs-toggle="modal" data-bs-target="#modal${product.getPID()}">
									<div id="product${product.getPID()}Card" class="card border-0 product-card">
										<img src="../../resources/img/${product.getPImagePath()}" class="card-img-top" alt="">
										<div class="card-body">
											<h5 class="card-title">${product.getPName()}</h5>
                                            <div id="short-desc-container">
                                                <p id="short-desc-txt">${product.getPDescription()}</p>
                                            </div>
                                </a>
											<div class="d-flex align-items-center mt-2">
                                                <span class="fa-stack cart-icon-group visible" data-pID="${product.getPID()}" onclick="addToCart(this)">
                                                    <i id="cart-icon-bg" class="fas fa-circle fa-stack-2x"></i>
                                                    <i class="fas fa-cart-plus fa-sm fa-stack-1x icon"></i>
                                                </span>
                                                <span class="d-none fst-italic text-muted"><span class="productQuantityInCart">0</span>x in cart</span>
												<p class="card-text ms-auto">$${product.getPFormattedPrice()}</p>
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
                                                <div class="d-flex align-items-center">
                                                    <button type="button" class="btn btn-success me-2" data-pID="${product.getPID()}" onclick="addToCart(this)">
                                                        <i class="fas fa-cart-plus"></i>  Add to cart
                                                    </button>
                                                    <span class="d-none fst-italic fs-6 text-muted"><span class="productQuantityInCart fs-6">0</span>x in cart</span>
                                                    <p class="card-text price-in-modal ms-auto">$${product.getPFormattedPrice()}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
						<c:if test="${((p.index + 1) % 4 == 0)}"></div></div></c:if>
					</c:forEach>
                </div>
            </div>
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

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="../../resources/src/addToCart.js"></script>
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
    <script src="<c:url value="/resources/src/checkSession.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/src/getNumProductsInCart.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/src/getProductsInCart.js" />" type="text/javascript"></script>
    <script type="text/javascript">
        checkSessionUser();
        getNumProductsInCart();
        getProductsInCart();
    </script>
</body>
</html>
