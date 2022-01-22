<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
                    <span>Logo</span>
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
                            My Profile
                        </a>
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
                    <li style="background: #00abfd">
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
                <div class="new-coupon-btn">
                    <!-- Modal Window Button for adding coupons -->
                    <a href="#miModal">New Coupon</a>
                    <!-- Modal Window -->
                    <div id="miModal" class="modal">
                        <div class="modal-contenido">
                            <a class="close-modal" href="#">X</a>
                            <h2>New Coupon</h2>
                            <div class="coupon-form">
                                <form action="">
                                    <div class="first-half">
                                        <div class="item-form">
                                            <label for="">Coupon Name: </label>
                                            <input type="text" />
                                        </div>
                                        <div class="item-form">
                                            <label for="">Coupon Code: </label>
                                            <input type="text" />
                                        </div>
                                        <div class="item-form">
                                            <label for=""
                                                >Coupon Discount:
                                            </label>
                                            <input type="text" />
                                        </div>
                                    </div>
                                    <div class="second-half">
                                        <div class="item-form">
                                            <label for=""
                                                >Promotional Event:
                                            </label>
                                            <select name="" id="">
                                                <option
                                                    value="none"
                                                    selected
                                                    disabled
                                                    hidden
                                                >
                                                    Select an Option
                                                </option>
                                                <option
                                                    value="Black Friday 2021"
                                                >
                                                    Black Friday 2021
                                                </option>
                                                <option value="Halloween">
                                                    Halloween
                                                </option>
                                                <option value="Christmas">
                                                    Christmas
                                                </option>
                                            </select>
                                        </div>
                                        <div class="item-form">
                                            <label for=""
                                                >Product Category:
                                            </label>
                                            <select name="" id="">
                                                <option
                                                    value="none"
                                                    selected
                                                    disabled
                                                    hidden
                                                >
                                                    Select an Option
                                                </option>
                                                <option value="Horror">
                                                    Horror
                                                </option>
                                                <option value="Shooters">
                                                    Shoters
                                                </option>
                                                <option value="Sports">
                                                    Sports
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="radio-form">
                                        <div class="radio-item">
                                            <input
                                                type="radio"
                                                id="open"
                                                name="coupon_type"
                                                value="Open"
                                            />
                                            <label for="open">Open</label>
                                        </div>
                                        <div class="radio-item">
                                            <input
                                                type="radio"
                                                id="no_open"
                                                name="coupon_type"
                                                value="No Open"
                                            />
                                            <label for="no_open">No Open</label>
                                        </div>
                                    </div>
                                    <div class="button-form">
                                        <button class="cancel-button" href="#">
                                            Cancel
                                        </button>
                                        <button class="accept-button" href="#">
                                            Add
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Main window for managing coupons -->
                <div class="coupon-table">
                    <div class="search-table">
                        <svg
                            class="w-6 h-6"
                            fill="currentColor"
                            viewBox="0 0 20 20"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                fill-rule="evenodd"
                                d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                                clip-rule="evenodd"
                            ></path>
                        </svg>
                        <input
                            type="text"
                            class="search-table"
                            placeholder="Search..."
                        />
                    </div>
                    <table class="table" id="couponsTable">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>Name</td>
                                <td>Code</td>
                                <td>Type</td>
                                <td>Discount</td>
                                <td>Event ID</td>
                                <td>Category ID</td>
                                <td>Actions</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="coupon" items="${newCoupons}">
                                <tr>
                                    <td>${coupon.getCouponId()}</td>
                                    <td>${coupon.getCouponName()}</td>
                                    <td>${coupon.getCouponCode()}</td>
                                    <td>${coupon.getCouponType()}</td>
                                    <td>${coupon.getCouponDiscount()}</td>
                                    <td>${coupon.getPromotionEventId()}</td>
                                    <td>${coupon.getProductCategoryId()}</td>
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
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <footer>
            <div className="footer-component">
                <div>
                    <span>Footer</span>
                </div>
            </div>
        </footer>
    </body>
</html>
