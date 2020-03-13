<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="CapstoneProject/styles/page1.css">
<link rel="stylesheet" href="/CapstoneProject/styles/login.css">
<script src="/CapstoneProject/Scripts/Login.js"></script>
</head>
<body>
	<header class="header">
		<a class="logo" href="/CapstoneProject/views/home.jsp"> <img
			src="/CapstoneProject/Images/new1.png" alt="logo"
			style="max-width: 100%"></a>
		<nav>
			<ul class="nav_links">
				<li><a href="/CapstoneProject/views/register.jsp">Sign Up</a></li>
				<li><a href="/CapstoneProject/views/menu.jsp">Menu</a></li>
				<li><a href="/CapstoneProject/views/home.jsp#contact">Contact</a></li>
			</ul>
		</nav>
	</header>
	<div class="signIn">
		<div
			class="container-fluid list col-sm-6 col-md-12 col-xs-6 col-lg-12"
			style="width: 100%; height: 500px; background-image: url('/CapstoneProject/Images/login.jpg'); background-size: 100% 100%;">
			<div class="row">
				<div class="col-md-4 col-sm-4 col-xs-12"></div>
				<div class="col-md-4 col-sm-4 col-xs-12">
					<form class="form-container"
						action="/CapstoneProject/UserServlet?request_type=login"
						method="post">
						<h1 id="signin" style="text-align: center; color: #232020">
							Login</h1>
						<p style="color: red; text-align: center; right: 20px;">${errorMessage}</p>
						<div class="form-group">
							<label for="InputEmail">Email</label> <input type="email"
								class="form-control" id="Email" placeholder="Email" name="email">
						</div>
						<div class="form-group">
							<label for="InputPassword">Password</label> <input
								type="password" class="form-control" id="Password"
								placeholder="Password" name="password">
						</div>

						<button type="submit" value="LOGIN"
							class="btn btn-success btn-block" style="align-items: center">Login</button>
					</form>

					<p>
						<a href="/CapstoneProject/views/register.jsp ">Click Here</a> to
						create a New Account
					</p>
				</div>
			</div>
		</div>

		<!--   <div class="footer">
  <p style="background-color: gold;">@ copyright Miru2020.</p>
</div>
           -->
	</div>
</body>
</html>