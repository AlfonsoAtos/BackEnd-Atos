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
                    <span>
                        <span class="d-none" id="user-icons">
                            <a href="#"><i class="fas fa-user ms-3"></i></a>
                            <button type="button" class="btn btn-danger ms-3" onclick="logout()">Log out</button>
                        </span>
                    </span>
                </div>
            </div>
        </nav>

        <main class="container">
            <br>
            <div class="row">
                <!-- Checkout elements -->
                <div id="order-shop" class="col-8">
                    <!-- Change to call checkout -->
                    <table id="products-list">
                    </table>
                    <div id="last-element">
                    </div>
                </div>
                <div id="right-side" class="col-4">
                    <br>
                    <div id="payment">
                        <h2><b id="price"></b></h2><h6>All prices include VAT if applicable </h6>
                        <label for="ifGift">Is this a gift?</label>
                        <input id="checkAGift" type="checkbox" name="isGift" value="gift">
                            <input style="display: none;" id="emailGift" type="text" placeholder="@mail.com">
                        
                        <form id="payment_form">
                            <table>
                                <tr>
                                    <td>
                                        <label for="card">Card Number</label>
                                    </td>
                                    <td>
                                        <input id="cnumber" type="text" name="card" form="payment_form" placeholder="XXXX-XXXX-XXXX-XXXX" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="cvv">CVV</label>
                                        <input id="ccvv" type="text" name="cvv" form="payment_form" placeholder="XXX" style="width: 50px;" required>
                                    </td>
                                    <td style="float: right;">
                                        <label for="vThru">Valid Thru</label>
                                        <input id="cdate" type="text" name="vDate" form="payment_form" placeholder="XX/XX" style="width: 80px;" required>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    <button id="btn-payment" type="button" class="btn btn-success">Pay for your order now</button>
                    <form>
                        <label for="vThru">Insert coupon code</label>
                        <input id="tcoupon" type="text" name="vDate" form="payment_form" placeholder="________" style="width: 80px;">
                    </form>
                    </div>
                </div>
            </div>
        </main>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="<c:url value='../../resources/src/check.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/src/checkSession.js' />" type="text/javascript"></script>
        <script type="text/javascript">
            checkSessionUser();
        </script>
    </body>
</html>
