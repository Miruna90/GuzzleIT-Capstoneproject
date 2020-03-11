/*
 * Filename: CartServlet.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guzzleIT.cart.Cart;
import com.guzzleIT.data.OrderDetails;
import com.guzzleIT.data.OrderDetailsService;
import com.guzzleIT.data.Product;
import com.guzzleIT.data.ProductService;
import com.guzzleIT.data.Users;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside Get method");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String requestType = request.getParameter("request_type");
		System.out.println("requestType = " + requestType);
		System.out.println(requestURI);

		String url = "";
		if (requestType.equalsIgnoreCase("addItem")) {
			System.out.println("add Item");
			url = addItem(request, response);
		}

		if (requestType.equalsIgnoreCase("updateItem")) {
			System.out.println("Update Item");
			url = updateItem(request, response);
		}

		if (requestType.equalsIgnoreCase("removeItem")) {
			System.out.println("remove Item");
			url = removeItem(request, response);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	private String Update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	// Add the Item to the cart
	private String addItem(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside addItem method");
		String url = "/views/cart.jsp";

		int quantity = 1;
		HttpSession session = request.getSession(true);
		Cart cart = (Cart) session.getAttribute("cart");
		Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
		System.out.println("loggedin = "+loggedIn);

		if (loggedIn!=null) {

			if (cart == null)
				cart = new Cart();
			String productCode = request.getParameter("productCode");
			System.out.println(productCode);
			String price = request.getParameter("price");
			System.out.println(price);
			Product product = new Product();
			ProductService ps = new ProductService();
			product = ps.selectProduct(productCode);

			System.out.println("productCode=" + productCode);
			System.out.println("product=" + product);
			if (product != null) {
				OrderDetails orderDetails = new OrderDetails();
				OrderDetailsService ods = new OrderDetailsService();
				orderDetails.setProduct(product);
				orderDetails.setPrice(product.getPrice() * quantity);
				orderDetails.setQuantity(quantity);

				System.out.println("orderDetails = " + orderDetails);
				cart.addItem(orderDetails);
				cart.setCartTotal();
				ods.add(orderDetails);
				System.out.println("Successfully added");
				System.out.println("orderDetails = " + orderDetails);
			}
		} else {
			request.setAttribute("errorMessage", "Please Login");
			return "/views/login.jsp";
		}
		session.setAttribute("cart", cart);

		return url;
	}

	// Update the quantity
	private String updateItem(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside the update");
		String url = "/views/cart.jsp";
		String quantityString = request.getParameter("quantity");
		String productCode = request.getParameter("productCode");
		System.out.println(productCode);
		System.out.println(quantityString);

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		int quantity;
		try {
			quantity = Integer.parseInt(quantityString);
			if (quantity < 0)
				quantity = 1;
		} catch (NumberFormatException ex) {
			quantity = 1;
		}
		Product product = new Product();
		ProductService ps = new ProductService();
		product = ps.selectProduct(productCode);
		if (product != null && cart != null) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setProduct(product);
			orderDetails.setPrice(product.getPrice() * quantity);
			orderDetails.setQuantity(quantity);
			if (quantity > 0) {
				cart.addItem(orderDetails);
				cart.setCartTotal();
				System.out.println(orderDetails);
			} else {
				cart.removeItem(orderDetails);
				cart.setCartTotal();
				System.out.println(orderDetails);
			}
		}
		session.setAttribute("cart", cart);
		return url;
	}

	private String removeItem(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside the remove");
		String url = "/views/cart.jsp";
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		String productCode = request.getParameter("productCode");
		Product product = new Product();
		ProductService ps = new ProductService();
		product = ps.selectProduct(productCode);
		if (product != null && cart != null) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setProduct(product);
			cart.removeItem(orderDetails);
			cart.setCartTotal();
		}
		session.setAttribute("cart", cart);
		return url;

	}

}
