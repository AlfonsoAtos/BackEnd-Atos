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
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Favicons -->
    <meta name="theme-color" content="#7952b3">

    <!-- Custom styles -->
    <link href="<c:url value="/resources/css/signup.css" />" rel="stylesheet">
    <link rel="stylesheet" href="../../resources/css/style.css">
  </head>
  <body class="text-center">
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
          </ul>
        </div>
      </div>
    </nav>

    <main class="container-fluid form-signin p-4">
      <div class="row">
        <div class="col">
          <img class="mb-4 img-fluid" src="../../resources/img/logo-g.jpg" alt="" width="450" height="auto">
          <h1 class="h3 mb-3 fw-normal">Sign up</h1>
          <p id="signup-error" class="error-message d-none">Error signing up</p>
          <form id="signup_form" class="form-signin col">

            <div class="form-floating">
              <input type="text" class="form-control" id="floatingName" name="name" placeholder="John Smith" required>
              <label for="floatingName">Name</label>
            </div>
            <div class="form-floating">
              <input type="email" class="form-control" id="floatingInput" name="email" placeholder="name@example.com" required>
              <label for="floatingInput">Email address</label>
            </div>
            <div class="form-floating">
              <input type="text" class="form-control" id="floatingPhone" name="number" placeholder="81 1071 7952" required>
              <label for="floatingPhone">Phone Number</label>
            </div>
            <div class="form-floating">
              <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password" required>
              <label for="floatingPassword">Password</label>
            </div>
            <div class="form-floating">
              <input type="password" class="form-control" id="floatingConfirmPassword" name="confirmPassword" placeholder="ConfirmPassword" required>
              <label for="floatingConfirmPassword">Confirm Password</label>
            </div>
            <div>
              <p id="password-error" class="error-message d-none">Passwords don't match</p>
            </div>

            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
          </form>
          <div class="mt-4">
            <p>
              Already have an account?
              <a href="/user/login"> Log in here. </a>
            </p>
          </div>
        </div>
      </div>
    </main>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  	<script src="<c:url value="/resources/src/signup.js" />" type="text/javascript"></script>
  </body>
</html>
