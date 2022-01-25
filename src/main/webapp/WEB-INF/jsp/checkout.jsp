<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="../../resources/css/check.css">
    <title>Checkout</title>
</head>
    <body>
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
                    <form action="search" class="d-flex">
                        <input name="pname" class="form-control me-2" type="search" placeholder="Search Products" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                    <a href="#"><i class="fas fa-shopping-cart"></i></a>
                    <a href="#"><i class="fas fa-user"></i></a>
                </div>
            </div>
        </nav>

		<!-- Checkout elements -->
		<div id="order-shop">
			<!-- Change to call checkout -->
			<c:forEach var="product" items="${newProducts}" varStatus="c">
				<div class="order-element">
					<img src="" alt="" width="100px" height="60px" style="display: inline-block;">
					<div style="display: inline-block;">     
						<!-- name -->
						<h5>SWAT 4: Gold Edition</h5>
						
						<sub>Remove</sub>
						<h6 style="position:relative; display: inline-block; left: 95px;"><b>10.73</b></h6>
					</div>
				</div>
			</c:forEach>
            <div id="last-element">
                <h6>All prices include VAT if applicable</h6> <b>ORDER TOTAL: 32.19</b>
            </div>
		</div>
		<div id="right-side">
            <div id="balance">
                <h3>Wallet founds (balance $0.00)</h3>
                <h6><b>Purchase more wallet founds </b><button type="button" class="btn btn-success btn-sm">add founds</button></h6>
            </div>
            <br>
            <div id="payment">
                <div class="payment-method"><i>Visa/MasterCard/American Express/ Credit & Debit Card</i></div>
                <div class="payment-method"><i>Paypal</i></div>
                <div class="payment-method"><i>Google pay</i></div>
                <div id="isAGift">
                    <input type="checkbox" id="gift" name="gift" value="isAGift">
                    <label for="gift">Gift this order</label><br>
                </div>
                <button type="button" class="btn btn-success">Pay for your order now</button>
            </div>
        </div>
    </body>
</html>