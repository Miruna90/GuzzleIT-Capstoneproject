<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Shopping Cart</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/CapstoneProject/styles/cart.css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:500&display=swap"
	rel="stylesheet">
</head>
<body style="background-color: #fff1cf; font-size:15px">
	<header class="header">
		<a class="logo" href="/CapstoneProject/views/home.jsp"> <img src="/CapstoneProject/Images/new1.png" alt="logo"
			style="max-width: 100%"></a>
		<nav>
			<ul class="nav_links">
				<li><a href="/CapstoneProject/views/menu.jsp"">Menu</a></li>
				<li><a href="/CapstoneProject/views/home.jsp#contact">Contact</a></li>
				<li><a href="/CapstoneProject/CustomerServlet?request_type=logout">Logout</a></li>
			</ul>
		</nav>
	</header>
	<script src="https://use.fontawesome.com/c560c025cf.js"></script>
	<div class="container" style="padding-top: 20px">
		<img class="logo" src="/CapstoneProject/Images/order.png" alt="logo"
		style="max-width: 100%" height="40px" width="40px"padding: 5px 20px 15px 20px;></a></li> <span
			style="font-size: 25px">Shopping cart </span>

		<form action="/CapstoneProject/views/menu.jsp" method="post">
			<a href="/CapstoneProject/views/menu.jsp"
				class="btn btn-info pull-right">Continue
				shopping</a> <input type="hidden" name="action" value="shop"> <input
				type="hidden" value="Continue Shopping">
		</form>
		<div class="clearfix"></div>
		<section>
			<table class="table" style="margin-top:10px;">
				<thead class="bg-warning" style="font-size:18px;">
					<tr>
						<th scope="col">Quantity</th>
						<th scope="col">Name</th>
						<th scope="col">Description</th>
						<th scope="col">Price</th>
						<th scope="col">Amount</th>
					

					</tr>
				</thead>
				<tbody class="body" style="font-size:11px;" >
					<c:forEach var="item" items="${cart.items}">
						<tr >
							<td>
								<form
									action="/CapstoneProject/CartServlet?request_type=updateItem"
									method="post">
									<input type="hidden" name="productCode"
										value="<c:out value ='${item.product.productCode}'/>">
									<input type=text size="4" style="text-align:center;" name="quantity"
										value="<c:out value='${item.quantity}'/>" id="quantity">
									<input type="submit" value="Update">
								</form>
							</td>
							<td><c:out value='${item.product.name}' /></td>
							<td><c:out value='${item.product.description}' /></td>
							<td>$<c:out value='${item.product.price}' /></td>
							<td>$<c:out value='${item.product.price*item.quantity}' /></td>
							<td>
								<div class="text-right">
									<form
										action="/CapstoneProject/CartServlet?request_type=removeItem"
										method="post">
										<input type="hidden" name="productCode"
											value="<c:out value='${item.product.productCode}'/>">
										<input type="hidden" name="quantity" value="0"> <input
											type="hidden" value="Remove Item">
										<button type="submit"
											class="btn btn-outline-danger btn-xs pull-right">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<tr>
				<td>
					<p>
						<b>To change the quantity for an item</b>, enter the new quantity
						and click on the Update button.
					</p>
					<p>
						<b>To remove an item</b>, click on the Remove button.
					</p>
				</td>
				<td colspan="3">&nbsp;</td>
			</tr>

			<form action="/CapstoneProject/views/checkout.jsp" method="post">
				<a href="/CapstoneProject/views/checkout.jsp"class="btn btn-info pull-right	">Checkout</a>
				<input type="hidden" name="action" value="checkout"> <input
					type="hidden" value="Checkout">
			</form>
		</section>
</body>
</html>