<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CapstoneProject/styles/regi.css">
</head>
<body>

	<header class="header">
		<a class="logo" href="/CapstoneProject/views/home.jsp"> <img src="/CapstoneProject/Images/new1.png" alt="logo"
			style="max-width: 100%"></a>
		<nav>
			<ul class="nav_links">
				<li><a href="/CapstoneProject/views/login.jsp">Login</a></li>
				<li><a href="/CapstoneProject/views/menu.jsp"">Menu</a></li>
				<li><a href="/CapstoneProject/views/home.jsp#contact">Contact</a></li>
			</ul>
		</nav>
	</header>
	<div class="container-fluid list col-sm-6 col-md-12 col-xs-6 col-lg-12" style="
  width: 100%;
  height: 500px;
  background-image: url('/CapstoneProject/Images/register.jpg');
  background-size: 100% 100%;">

		<div class="signup-form">
			<form action="/CapstoneProject/UserServlet?request_type=register" method="post">
				<h2>Sign Up</h2>
				<p style="color: red; text-align: center;">${errorMessage}</p>
				<p>Please fill in this form to create an account!</p>
				<!-- <div class="form-group">
					<label for="username">Username</label> <input type="name"
						class="form-control" id="username" placeholder="Username"
						required="required">
				</div> -->
				<div class="form-group">
					<label for="email">Email</label> <input type="email" name="email"
						class="form-control" id="Email" placeholder="Email" required="required">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password" name="password"
						class="form-control" id="password" placeholder="Password" required="required">
				</div>
				<div class="form-group">
					<button type="submit" value="REGISTER" class="btn btn-success btn-block"
						style="align-items: center">Signup</button>
				</div>
				
			</form>
		</div>

	</div>
	<!--
        <div class="footer">
  <p style="background-color: gold;">@ copyright Miru2020.</p>

-->

</body>
</html>