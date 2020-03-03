<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Menu</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/CapstoneProject/styles/menu1.css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:500&display=swap"
	rel="stylesheet">
</head>
<body style="background-color: #fff1cf">
	<header class="header">
		<a class="logo" href="/CapstoneProject/views/home.jsp"> <img
			src="/CapstoneProject/Images/new1.png" alt="logo"
			style="max-width: 100%"></a>
		<nav>
			<ul class="nav_links">
			    <li><a href="/CapstoneProject/views/cart.jsp"> <img class="logo" src="/CapstoneProject/Images/order.png" alt="logo"
		style="max-width: 100%" height="40px" width="40px"padding: 5px 20px 15px 20px;>Cart</a></li>
				<li><a href="/CapstoneProject/views/home.jsp#contact">Contact</a></li>
				<li><a href="/CapstoneProject/CustomerServlet?request_type=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<!--        Menu-1-->
	<div class="container">

		<div>
			<img src="/CapstoneProject/Images/orange.png" alt="Juice"
				style="height: 300px; width: 200px; margin: 50px;">
		</div>

		<div class="description">
			<p name="name" style="font-weight:700; font-size: 20px; color: black;">Orange Morning</p>
			<p name="desc"><b>Made of :</b>Carrot, Lemon, Apple, Ginger</p>
			<p><input type="hidden" value=${product.priceCurrencyFormat}
					name="price"><b>Price = </b>$5.99</p>
		<!-- 	<p name="size">M</p> -->

		</div>

		<form action="/CapstoneProject/CartServlet?request_type=addItem"
			method="post">
			<div>
				<a class="cta" href=""> <input type="hidden" name="productCode"
					value="4001"> <input type="hidden" name="price" value=5.99>
					<button class="myBtn" id="myBtn1">Add to Cart</button>
				</a>
			</div>
		</form>
	</div>
	
		<!--        Menu4-->
	<div class="container">

		<div>
			<img src="/CapstoneProject/Images/citrus.png" alt="Juice"
				style="height: 300px; width: 200px; margin: 50px;">
		</div>
		<div class="description col-6 col-md-6 col-xs-4"">
			<p name="name" style="font-weight:700; font-size: 20px; color: black;">Citrus Smoothie</p>
			<p name="desc"><b>Made of :</b>Banana, Date, Orange,Ginger,Hemp seeds</p>
			<p><input type="hidden" value=${product.priceCurrencyFormat}
					name="price"><b>Price = </b>$5.99</p>
		<!-- 	<p name="size">M</p> -->

		</div>

		<div>
			<form action="/CapstoneProject/CartServlet?request_type=addItem"
				method="post">
				<div style="margin-top: 12px;">
					<a class="cta" href=""> <input type="hidden" name="productCode"
						value="4004"> <input type="hidden" name="price" value=5.99>
						<button class="myBtn" id="myBtn2">Add to Cart</button>
					</a>
				</div>
			</form>
		</div>
	</div>
	
	<!--        Menu3-->
	<div class="container">

		<div>
			<img src="/CapstoneProject/Images/choco.png" alt="Juice"
				style="height: 300px; width: 200px; margin: 50px;">
		</div>
		<div class="description col-6 col-md-6 col-xs-4"">
			<p name="name" style="font-weight:700; font-size: 20px; color: black;">Choco Smoothie</p>
			<p name="desc"><b>Made of :</b>Hazelnut,Date,Cinnamon,Chocolate powder,Ginger</p>
			<p><input type="hidden" value=${product.priceCurrencyFormat}
					name="price"><b>Price = </b>$5.99</p>
		<!-- 	<p name="size">M</p> -->

		</div>

		<div>
			<form action="/CapstoneProject/CartServlet?request_type=addItem"
				method="post">
				<div style="margin-top: 12px;">
					<a class="cta" href=""> <input type="hidden" name="productCode"
						value="4003"> <input type="hidden" name="price" value=5.99>
						<button class="myBtn" id="myBtn2">Add to Cart</button>
					</a>
				</div>
			</form>
		</div>
	</div>
	
	<!--        Menu2-->
	<div class="container">

		<div>
			<img src="/CapstoneProject/Images/lemonade.png" alt="Juice"
				style="height: 300px; width: 200px; margin: 50px;">
		</div>
		<div class="description">
			<p name="name" style="font-weight:700; font-size: 20px; color: black;">Lemonade</p>
			<p name="desc"><b>Made of :</b>Mint, Lemon, Ginger, Agava syrup</p>
			<p><input type="hidden" value=${product.priceCurrencyFormat}
					name="price"><b>Price = </b>$5.99</p>
		<!-- 	<p name="size">M</p> -->

		</div>

		<div>
			<form action="/CapstoneProject/CartServlet?request_type=addItem"
				method="post">
				<div style="margin-top: 12px;">
					<a class="cta" href=""> <input type="hidden" name="productCode"
						value="4002"> <input type="hidden" name="price" value=5.99>
						<button class="myBtn" id="myBtn2">Add to Cart</button>
					</a>
				</div>
			</form>
		</div>
	</div>

	
		<!--        Menu5-->
	<div class="container">

		<div>
			<img src="/CapstoneProject/Images/green.png" alt="Juice"
				style="height: 300px; width: 200px; margin: 50px;">
		</div>
		<div class="description col-6 col-md-6 col-xs-4"">
			<p name="name" style="font-weight:700; font-size: 20px; color: black;">Green day</p>
			<p name="desc"><b>Made of :</b>Apple, Cucumber, lime, Spinach</p>
			<p><input type="hidden" value=${product.priceCurrencyFormat}
					name="price"><b>Price = </b>$5.99</p>
		<!-- 	<p name="size">M</p> -->

		</div>

		<div>
			<form action="/CapstoneProject/CartServlet?request_type=addItem"
				method="post">
				<div style="margin-top: 12px;">
					<a class="cta" href=""> <input type="hidden" name="productCode"
						value="4005"> <input type="hidden" name="price" value=5.99>
						<button class="myBtn" id="myBtn2">Add to Cart</button>
					</a>
				</div>
			</form>
		</div>
	</div>

	<!--        Menu6-->
	<div class="container">

		<div>
			<img src="/CapstoneProject/Images/red.png" alt="Juice"
				style="height: 300px; width: 200px; margin: 50px;">
		</div>
		<div class="description col-6 col-md-6 col-xs-4"">
			<p name="name" style="font-weight:700; font-size: 20px; color: black;">Red Juice</p>
			<p name="desc"><b>Made of :</b> Lemon, Apple, Beet, Carrot</p>
			<p><input type="hidden" value=${product.priceCurrencyFormat}
					name="price"><b>Price = </b>$5.99</p>
		<!-- 	<p name="size">M</p> -->

		</div>

		<div>
			<form action="/CapstoneProject/CartServlet?request_type=addItem"
				method="post">
				<div style="margin-top: 12px;">
					<a class="cta" href=""> <input type="hidden" name="productCode"
						value="4006"> <input type="hidden" name="price" value=5.99>
						<button class="myBtn" id="myBtn2">Add to Cart</button>
					</a>
				</div>
			</form>
		</div>
	</div>

	<footer>@ copyright Miru2020.</footer>


</body>
</html>