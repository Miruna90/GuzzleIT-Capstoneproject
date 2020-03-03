<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Shopping Cart</title>
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

<link rel="stylesheet" href="../styles/checkout.css">
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
				<li><a href="/CapstoneProject/views/menu.jsp">Menu</a></li>
				<li><a href="/CapstoneProject/views/home.jsp#contact">Contact</a></li>
				<li><a href="/CapstoneProject/CustomerServlet?request_type=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<br />
	<img class="logo" src="/CapstoneProject/Images/order.png" alt="logo"
		style="max-width: 100%" height="40px" width="40px"padding: 5px 20px 15px 20px;>
	<span style="font-size: 30px">Checkout</span>
	<div class="row">
		<div class="col-75">
			<div class="container">
				<form action="/CapstoneProject/CustomerServlet?request_type=processUser" method="post">

					<div class="row">
						<div class="col-50">
							<h3>Billing Address</h3>
							<label for="fname"><i class="fa fa-user"></i> First Name</label><input
								type="text" id="fname" name="firstName" value="${customer.firstName}" required  maxlength=20
								placeholder="Kate M">
								<label for="lname"><i class="fa fa-user"></i> Last Name</label> <input
								type="text" id="lname" name="lastName" value="${customer.lastName}" required
								placeholder="Smith">
								 <label for="email"><i
								class="fa fa-envelope"></i> Email</label> <input type="text" id="email"
								name="email" value="${user.email}" required placeholder="Kate@example.com">
								 <label for="adr"><i class="fa fa-address-card-o"></i> Address</label> <input
								type="text" id="adr" name="address" value="${customer.address}" required
								placeholder="123 E. 2nd Street"> 
								<label for="city"><i class="fa fa-institution"></i> City</label> <input type="text" id="city"
								name="city" value="${customer.city}" required placeholder="Detroit">

							<div class="row">
							<div class="col-50">
									<label for="phone">Phone</label> <input type="text" id="phone"
										name="phone"  value="${customer.phone}" required placeholder="343-456-1022">
								</div>
								<div class="col-25">
									<label for="state">State</label> <input type="text" id="state"
										name="state"  value="${customer.state}" required placeholder="MI">
								</div>
								<div class="col-25">
									<label for="zip">Zip</label> <input type="text" id="zip"
										name="zip"  value="${customer.zipcode}" required placeholder="48024">
								</div>
							</div>
						</div>

						<div class="col-50">
							<h3>Payment</h3>
							<label for="fname">Accepted Cards</label>
							<div class="icon-container">
								<i class="fa fa-cc-visa" style="color: navy;"></i> <i
									class="fa fa-cc-amex" style="color: blue;"></i> <i
									class="fa fa-cc-mastercard" style="color: red;"></i> <i
									class="fa fa-cc-discover" style="color: orange;"></i>
							</div>
							<label for="cname">Name on Card</label> <input type="text"
								id="cname" name="cardname" required placeholder="Kate M Smith">
							<label for="ccnum">Credit card number</label> <input type="number"
								id="ccnum" name="cardnumber" required  placeholder="9999-8888-7777-6666">
							<label for="expmonth">Exp Month</label> <input type="text"
								id="expmonth" name="expmonth" required  placeholder="January">
							<div class="row">
								<div class="col-50">
									<label for="expyear">Exp Year</label> <input type="number"
										id="expyear" name="expyear" required  placeholder="2020"  min="2020" max="2030">
								</div>
								<div class="col-50">
									<label for="cvv">CVV</label> <input type="number" id="cvv"
										name="cvv" required  placeholder="567" min="000" max="999">
								</div>
							</div>
						</div>

					</div>
					<label> <input type="checkbox" checked="checked"
						name="sameadr"> Shipping address same as billing
					</label>
					 <input type="submit" value="Continue to checkout" class="btn btn-info">
					</form> 
				</form>
			</div>
		</div>
	</div>


</body>
</html>