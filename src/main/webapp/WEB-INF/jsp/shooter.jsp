<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                        <li class="nav-item">
                            <a href="shooter" class="nav-link" aria-current="page">Shooter</a>
                        </li>
                        <li class="nav-item">
                            <a href="rpg" class="nav-link">RPG</a>
                        </li>
                        <li class="nav-item">
                            <a href="simulation" class="nav-link">Simulation</a>
                        </li>
						<li class="nav-item">
                            <a href="vr" class="nav-link">VR</a>
                        </li>
						<li class="nav-item">
                            <a href="strategy" class="nav-link">Strategy</a>
                        </li>
                    </ul>
                    <a href="#" class="ms-4"><i class="fas fa-shopping-cart"></i></a>
                    <a href="#" class="ms-3"><i class="fas fa-user"></i></a>
                </div>
            </div>
        </nav>
        <div class="container mt-5 mb-5">
            <form action="shooter" class="d-flex">
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
                                    <div class="d-flex align-items-center">
                                        <a href="addtocart/${product.getPID()}" class="me-auto visible">
                                            <span class="fa-stack cart-icon-group visible">
                                                <i id="cart-icon-bg" class="fas fa-circle fa-stack-2x"></i>
                                                <i class="fas fa-cart-plus fa-sm fa-stack-1x icon"></i>
                                            </span>
                                        </a>
                                        <p class="card-text text-end">$${product.getPPrice()}</p>
                                    </div>
                                </div>
							</div>
						</a>
					</div>
				<c:if test="${((p.index + 1) % 4 == 0)}"></div></c:if>
			</c:forEach>
        </div>
            

        <div id="myModal" class="modal" tabindex="-1">
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