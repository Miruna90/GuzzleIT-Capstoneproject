/*
 * Filename: CustomerServlet.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guzzleIT.cart.Cart;
import com.guzzleIT.data.Customer;
import com.guzzleIT.data.CustomerService;
import com.guzzleIT.data.Orders;
import com.guzzleIT.data.OrdersService;
import com.guzzleIT.data.Users;
import com.guzzleIT.data.UsersService;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String requestType = request.getParameter("request_type");
		String url="";
		
		if(requestType.equalsIgnoreCase("logout")) {
			url=logout(request,response);
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String requestType = request.getParameter("request_type");
		
		String url="";
		if(requestType.equalsIgnoreCase("processUser")) {
		
			url=processUser(request,response);
		}
		if(requestType.equalsIgnoreCase("confirmOrder")) {
			
			url=confirmOrder(request,response);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	//confirm Order
	private String confirmOrder(HttpServletRequest request, HttpServletResponse response) {
		String url ="/views/Success.jsp";
		
		HttpSession session = request.getSession();
		  Customer customer = (Customer) session.getAttribute("customer");      
	        Cart cart = (Cart) session.getAttribute("cart");

	        java.util.Date today = new java.util.Date();
	        String instructions = request.getParameter("comment");

	        Orders orders = new Orders();
	        OrdersService os = new OrdersService();
	        String status = "Process";
	        orders.setOrderDate(today);
	        orders.setOdList(cart.getItems());
	        orders.setOrderStatus(status);
	        orders.setSplInstructions(instructions);
	        os.add(orders);
	        List<Orders> order = new ArrayList<>();
	        order.add(orders);
	        customer.setOrderList(order);
	        CustomerService cs = new CustomerService();
	        cs.add(customer);
		
		return url;
	}

	//Process User
    private String processUser(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	String url = "/views/confirmation.jsp";
    	
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zip");

        HttpSession session = request.getSession();
        
        Customer customer = (Customer) session.getAttribute("customer");
        
        if (customer == null) {
        	customer = new Customer();
        }
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setState(state);
        customer.setZipcode(zipcode);
        
        UsersService us = new UsersService();
        CustomerService cs = new CustomerService();
        Users user = new Users();
        
        if (us.emailExists(email)) {
        	user = us.findUserByEmail(email);
        	customer.setUsers(user);
            cs.add(customer);
        }        
       session.setAttribute("customer", customer);  
        return url;
    }
    
    private String logout(HttpServletRequest request,
            HttpServletResponse response) {
    	String url ="/views/login.jsp";
    	HttpSession session = request.getSession();
    	session.invalidate();
				return url;
    	
    }


}
