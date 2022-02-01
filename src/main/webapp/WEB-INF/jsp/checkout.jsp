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

        <main class="container">
            <br>
            <div class="row">
                <!-- Checkout elements -->
                <div id="order-shop" class="col-8">
                    <!-- Change to call checkout -->
                    <div id="products-list">
                    </div>
                    <div id="last-element">
                    </div>
                </div>
                <div id="right-side" class="col-4">
                    <br>
                    <div id="payment">
                        <form action="POST" id="payment_form">
                            <table>
                                <tr>
                                    <td>
                                        <label for="card">Card Number</label>
                                    </td>
                                    <td>
                                        <input type="text" name="card" form="payment_form" placeholder="XXXX-XXXX-XXXX-XXXX">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="cvv">CVV</label>
                                        <input type="text" name="cvv" form="payment_form" placeholder="XXX" style="width: 50px;">
                                    </td>
                                    <td style="float: right;">
                                        <label for="vThru">Valid Thru</label>
                                        <input type="text" name="vDate" form="payment_form" placeholder="XX/XX" style="width: 80px;">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    <button type="button" class="btn btn-success">Pay for your order now</button>
                    <form>
                        <label for="vThru">Insert coupon code</label>
                        <input type="text" name="vDate" form="payment_form" placeholder="________" style="width: 80px;">
                        <button type="button" class="btn btn-success">Apply coupon</button>
                    </form>
                    </div>
                </div>
            </div>
        </main>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="<c:url value='../../resources/src/check.js' />" type="text/javascript"></script>
    </body>
</html>
