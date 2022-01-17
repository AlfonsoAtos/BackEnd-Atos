<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Sign up IT Shop</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Favicons -->
    <meta name="theme-color" content="#7952b3">

    <!-- Custom styles -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
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
        <form>
          <img class="mb-4" src="<c:url value="/resources/images/WIFI_icon.svg.png" />" alt="" width="72" height="auto">
          <h1 class="h3 mb-3 fw-normal">Sign up</h1>
  
          <div class="form-floating">
            <input type="email" class="form-control" id="floatingName" placeholder="John Smith">
            <label for="floatingName">Name</label>
          </div>
          <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Email address</label>
          </div>
          <div class="form-floating">
            <input type="text" class="form-control" id="floatingPhone" placeholder="81 1071 7952">
            <label for="floatingPhone">Phone Number</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="floatingConfirmPassword" placeholder="ConfirmPassword">
            <label for="floatingConfirmPassword">Confirm Password</label>
          </div>
  
          <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
        </form>
      </main>
    </div>
  </body>
</html>