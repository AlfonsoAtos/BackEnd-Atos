<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
        <link href="
        <c:url value="/resources/css/main.css" />
        " rel="stylesheet">
        <title>Coupon Details</title>
    </head>
    <body>
        <div>
            <!-- Navigation bar -->
            <ul class="navbar">
                <div class="logo-nav">
                    <a href="/admin-side/">
                        <div class="logo-bg">
                            <img src="../../resources/img/logo.png" />
                        </div>
                    </a>
                </div>
                <div class="items-nav">
                    <li>
                        <a href="#">
                            <svg
                                fill="white"
                                viewBox="0 0 20 20"
                                xmlns="http://www.w3.org/2000/svg"
                            >
                                <path
                                    fill-rule="evenodd"
                                    d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-6-3a2 2 0 11-4 0 2 2 0 014 0zm-2 4a5 5 0 00-4.546 2.916A5.986 5.986 0 0010 16a5.986 5.986 0 004.546-2.084A5 5 0 0010 11z"
                                    clip-rule="evenodd"
                                ></path>
                            </svg>
                            <p id="admin-name">My Profile</p>
                        </a>
                    </li>
                    <li>
                        <button type="button" class="logout-button" onclick="logout()">Log out</button>
                    </li>
                </div>
            </ul>
        </div>
        <!-- Main content for coupons -->
        <div class="main-content">
            <!-- Side bar -->
            <ul class="sidebar">
                <div class="items-side">
                    <li>
                        <a href="/admin-side/products">
                            <svg
                                fill="white"
                                viewBox="0 0 20 20"
                                xmlns="http://www.w3.org/2000/svg"
                            >
                                <path
                                    fill-rule="evenodd"
                                    d="M10 2a4 4 0 00-4 4v1H5a1 1 0 00-.994.89l-1 9A1 1 0 004 18h12a1 1 0 00.994-1.11l-1-9A1 1 0 0015 7h-1V6a4 4 0 00-4-4zm2 5V6a2 2 0 10-4 0v1h4zm-6 3a1 1 0 112 0 1 1 0 01-2 0zm7-1a1 1 0 100 2 1 1 0 000-2z"
                                    clip-rule="evenodd"
                                ></path>
                            </svg>
                            Products
                        </a>
                    </li>
                    <li>
                        <a href="/admin-side/events">
                            <svg
                                fill="white"
                                viewBox="0 0 20 20"
                                xmlns="http://www.w3.org/2000/svg"
                            >
                                <path
                                    d="M5 3a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2V5a2 2 0 00-2-2H5zM5 11a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2v-2a2 2 0 00-2-2H5zM11 5a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V5zM11 13a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z"
                                ></path>
                            </svg>
                            Events
                        </a>
                    </li>
                    <li>
                        <a href="/admin-side/coupons">
                            <svg
                                fill="white"
                                viewBox="0 0 20 20"
                                xmlns="http://www.w3.org/2000/svg"
                            >
                                <path
                                    d="M2 6a2 2 0 012-2h12a2 2 0 012 2v2a2 2 0 100 4v2a2 2 0 01-2 2H4a2 2 0 01-2-2v-2a2 2 0 100-4V6z"
                                ></path>
                            </svg>
                            Coupons
                        </a>
                    </li>
                </div>
            </ul>
            <!-- Main Content -->
            <div class="content">
                <div class="update-form">
                    <form action="../updateCouponData/${couponData.couponId}">
                        <div class="first-half">
                            <div class="item-form">
                                <label>Coupon ID: </label>
                                ${couponData.couponId}
                            </div>
                            <div class="item-form">
                                <label>Coupon Name: </label>
                                <input
                                    type="text"
                                    name="couponName"
                                    value="${couponData.couponName}"
                                    maxlength="15"
                                    required
                                />
                            </div>
                            <div class="item-form">
                                <label>Coupon Code: </label>
                                <input
                                    type="text"
                                    style="text-transform: uppercase"
                                    name="couponCode"
                                    value="${couponData.couponCode}"
                                    minlength="10"
                                    maxlength="10"
                                    required
                                />
                            </div>
                            <div class="item-form">
                                <label>Coupon Discount: </label>
                                <input
                                    type="number"
                                    name="couponDiscount"
                                    value="${couponData.couponDiscount}"
                                    required
                                />
                            </div>
                        </div>
                        <div class="second-half">
                            <div class="item-form">
                                <label for="">Promotional Event: </label>
                                <select name="promotionEventId" id="" required>
                                    <c:forEach
                                        var="events"
                                        items="${newEvents}"
                                    >
                                        <option value="${events.getEventsId()}">
                                            ${events.getEventsName()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="item-form">
                                <label>Product Category: </label>
                                <select name="productCategoryId" required>
                                    <option value="none" disabled hidden>
                                        Select an Option
                                    </option>
                                    <option value="1" selected>Shooter</option>
                                    <option value="2">VR</option>
                                    <option value="3">Strategy</option>
                                    <option value="4">Simulation</option>
                                    <option value="5">RPG</option>
                                </select>
                            </div>
                            <div class="radio-form">
                                <div class="radio-item">
                                    <input
                                        type="radio"
                                        id="open"
                                        name="couponType"
                                        value="Open"
                                        required
                                    />
                                    <label for="open">Open</label>
                                </div>
                                <div class="radio-item">
                                    <input
                                        type="radio"
                                        id="no_open"
                                        name="couponType"
                                        value="Not open"
                                    />
                                    <label for="no_open">No Open</label>
                                </div>
                            </div>
                        </div>
                        <div class="button-form">
                            <input
                                class="accept-button"
                                type="submit"
                                value="Update"
                            />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <!-- <footer>
            <div className="footer-component">
                <div>
                    <span>Footer</span>
                </div>
            </div>
        </footer> -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="<c:url value="/resources/src/checkSession.js" />" type="text/javascript"></script>
        <script type="text/javascript">
            checkSessionAdmin();
        </script>
    </body>
</html>
