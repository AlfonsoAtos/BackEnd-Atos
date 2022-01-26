<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Log in IT Shop</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Favicons -->
    <meta name="theme-color" content="#7952b3">

    <!-- Custom styles -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/signup.css" />" rel="stylesheet">
  </head>
  <body class="text-center">
    <div>
		<!-- Navigation bar -->
		<ul class="navbar">
			<div class="logo-nav">
				<span>Logo</span>
			</div>
		</ul>
	</div>
    
    <div class="login-main">
      <main class="form-signin">
        <img class="mb-4" src="<c:url value="/resources/images/WIFI_icon.svg.png" />" alt="" width="72" height="auto">
        <h1 class="h3 mb-3 fw-normal">Log in</h1>
        <form id="login_form">
          <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Email address</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
          </div>
  
          <%-- <div class="checkbox mb-3">
            <label>
              <input type="checkbox" value="remember-me"> Remember me
            </label>
          </div> --%>
          <button class="w-100 btn btn-lg btn-primary" type="submit">Log in</button>
        </form>
        <div class="mt-4">
          <p>
            Do not have an account?
            <a href="/user/sign_up"> Create one here. </a>
          </p>
        </div>
      </main>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  	<script src="<c:url value="/resources/src/login.js" />" type="text/javascript"></script>
  </body>
</html>