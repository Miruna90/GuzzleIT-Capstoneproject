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
<link rel="stylesheet" href="/CapstoneProject/styles/confirmation1.css">
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
	

	<div class="container">
	<h2 style="color: brown">Double check your Order Details</h2>
		<div class="row">
			<div class="col-md-8">
				<h3 style="color: palevioletred">Billing Address</h3>
				<address>
				
					<form action="/CapstoneProject/views/checkout.jsp">
    <input type="submit" value="EDIT" class="btn btn-info pull-right" />
</form>
					<p>
						Name :
						<c:out value='${customer.firstName}' />
						<c:out value='${customer.lastName}' />
					</P>
					<p>
						Address :
						<c:out value='${customer.address}' />
					</p>
					<p>
						City :
						<c:out value='${customer.city}' />
					</p>
					<p>
						State :
						<c:out value='${customer.state}' />
					</p>
					<p>
						Zipcode :
						<c:out value='${customer.zipcode}' />
					</p>
				</address>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div>
				<h3 style="color: palevioletred">Order Summary</h3>
				<table class="table">
					<thead class="bg-light" style="font-size: 18px;">

						<tr>
							<th scope="col">Quantity</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Amount</th>
							<th scope="col">Tax</th>
							<th scope="col">Total</th>


						</tr>
					</thead>
					</tbody>
					<c:forEach var="item" items="${cart.items}">
						<td><c:out value='${item.quantity}'></c:out>
						<td><c:out value='${item.product.name}' /></td>
						<td><c:out value='${item.product.description}' /></td>
						<td>$<c:out value='${item.product.price}' /></td>
						<td>$<c:out value='${item.product.price * item.quantity}' /></td>
						<td>$<fmt:formatNumber type="number" maxFractionDigits="2"
								value='${(item.product.price * item.quantity)*(6/100)}' /></td>
						<td>$<fmt:formatNumber type="number" maxFractionDigits="2"
								value='${(item.product.price * item.quantity)+((item.product.price * item.quantity)*(6/100))}' /></td>

						</tbody>
					</c:forEach>

				</table>
				
			
				   <p style="margin-left:950px; ">Order Total = $<fmt:formatNumber type="number" maxFractionDigits="2"
								value = '${(cart.cartTotal)+((cart.cartTotal)*(6/100))}' /></p>
				
			</div> 
		</div>

		<form
			action="/CapstoneProject/CustomerServlet?request_type=confirmOrder"
			method="post">
			<div class="form-group col-lg-4">
				<label>Special Instructions:</label>
				<textarea class="form-control" rows="5" id="comment" name="comment"></textarea>
				
			</div>
			<input type="submit" value="confirm order"
				class="btn btn-info pull-right" style="margin-top:60px;" >

		</form>
	</div>



</body>
</html>