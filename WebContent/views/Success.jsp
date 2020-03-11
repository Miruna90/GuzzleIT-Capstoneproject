<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Confirmation</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/CapstoneProject/styles/Success.css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:500&display=swap"
	rel="stylesheet">
</head>
<body style="background-color: #fff1cf">
	<header class="header">
	<a class="logo" href="/CapstoneProject/views/home.jsp"> <img src="/CapstoneProject/Images/new1.png" alt="logo"
			style="max-width: 100%"></a>
		<nav>
			<ul class="nav_links">
				<li><a href="/CapstoneProject/views/home.jsp#contact">Contact</a>
				<li><a href="/CapstoneProject/CustomerServlet?request_type=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="container" style="
  width: 100%;
  height: 500px;
  background-image: url('/CapstoneProject/Images/confirm.jpg');
  background-size: 100% 100%;">
	  <div class="box jumbotron">
        <h2>Order Confirmation</h2>    
	<p>Thank you for your Order.</p>
	<p> Order has been Confirmed.</p>
	<p> Your order will be ready in 20 min.</p>
            </div>
	</div>
	<footer class="site-footer col-sm-6 col-md-12 col-xs-6 col-lg-12">
		<div class="container">
			<div class="row">
				<p
					style="color: black; font-family: Montserrat, sans-serif; font-weight: 500; font-size: 20px">Contact
					Us</p>
			</div>
			<div class="bottom-footer" style="font-size: 15px;">
				<div class="col-md-5">
					83,Timberview dr,<br />Rochester Hills<br>Michigan-480238
				</div>
				<div class="col-md-7">
					Phone: 4802380533<br> Email: GuzzltIt.com
				</div>

			</div>
		</div>
	</footer>

	</body>
	</html>