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
                                <form action="insertCoupon">
                                    <div class="first-half">
                                        <div class="item-form">
                                            <label>Coupon Name: </label>
                                            <input
                                                type="text"
                                                name="couponName"
                                                maxlength="15"
                                                required
                                            />
                                        </div>
                                        <div class="item-form">
                                            <label>Coupon Code: </label>
                                            <input
                                                type="text"
                                                style="
                                                    text-transform: uppercase;
                                                "
                                                name="couponCode"
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
                                                required
                                            />
                                        </div>
                                    </div>
                                    <div class="second-half">
                                        <div class="item-form">
                                            <label for=""
                                                >Promotional Event:
                                            </label>
                                            <select
                                                name="promotionEventId"
                                                id=""
                                                required
                                            >
                                                <c:forEach
                                                    var="events"
                                                    items="${newEvents}"
                                                >
                                                    <option
                                                        value="${events.getEventsId()}"
                                                    >
                                                        ${events.getEventsName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="item-form">
                                            <label>Product Category: </label>
                                            <select
                                                name="productCategoryId"
                                                id=""
                                                required
                                            >
                                                <option
                                                    value="none"
                                                    selected
                                                    disabled
                                                    hidden
                                                >
                                                    Select an Option
                                                </option>
                                                <option value="1">
                                                    Shooter
                                                </option>
                                                <option value="2">VR</option>
                                                <option value="3">
                                                    Strategy
                                                </option>
                                                <option value="4">
                                                    Simulation
                                                </option>
                                                <option value="5">RPG</option>
                                            </select>
                                        </div>
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
                                                value="Nopen"
                                            />
                                            <label for="no_open">No Open</label>
                                        </div>
                                    </div>
                                    <div class="button-form">
                                        <a class="cancel-button" href="#"
                                            >Cancel</a
                                        >
                                        <input
                                            class="accept-button"
                                            type="submit"
                                            value="Add"
                                        />
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Main window for managing coupons -->
                <div class="coupon-table">
                    <!-- <div class="search-table">
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
						<input type="text" class="search-table" placeholder="Search..." />
					</div> -->
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
                                        <a
                                            href="updateCoupon/${coupon.couponId}"
                                        >
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
                                        </a>
                                        <a href="#deleteItem">
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
                                            <div id="deleteItem" class="modal">
                                                <div
                                                    class="modal-contenido-delete"
                                                >
                                                    <h2>
                                                        Are you sure to delete
                                                        this item?
                                                    </h2>
                                                    <div class="button-form">
                                                        <a
                                                            href="#"
                                                            class="cancel-button"
                                                            >No</a
                                                        >
                                                        <a
                                                            href="deleteCoupon/${coupon.couponId}"
                                                            class="accept-button"
                                                            >Yes</a
                                                        >
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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
