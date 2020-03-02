package com.guzzleIT.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.guzzleIT.data.Users;
import com.guzzleIT.data.UsersService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String requestType = request.getParameter("request_type");
		System.out.println(requestType);
		System.out.println(requestURI);

		String url = "";
		if (requestType.equalsIgnoreCase("register")) {
			System.out.println("Found parameter register");
			url = register(request, response);
		}

		if (requestType.equalsIgnoreCase("login")) {
			System.out.println("Found parameter login");
			url = login(request, response);
		}
//		 RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//         dispatcher.forward( request, response);
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

//	private String register(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String result = "";
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		request.setAttribute("email", email);
//		request.setAttribute("password", password);
//
////		HttpSession session = request.getSession(true);
////		session.setAttribute("notloggedIn", true);
//
//		Users user = new Users(email, password);
//		UsersService us = new UsersService();
//		Boolean loginStatus = us.loginUser(email, password);
//		if (!loginStatus) {
//			us.add(user);
//			System.out.println(user);
//			result = "/views/login.jsp";
//		} else {
//			request.setAttribute("errorMessage", "Email already exits");
//			result = "/views/register.jsp";
//		}
//		return result;
//	}

	private String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		request.setAttribute("email", email);
		request.setAttribute("password", password);

		HttpSession session = request.getSession(true);
		session.setAttribute("notloggedIn", true);

		Users user = new Users(email, password);
		UsersService us = new UsersService();
		Boolean userExistsStatus = us.emailExists(email);
		if (!userExistsStatus) {
			System.out.println("inside emailexists check");
			us.add(user);
			System.out.println(user);
			result = "/views/login.jsp";
		} else {
			request.setAttribute("errorMessage", "Email already exits");
			result = "/views/register.jsp";
		}
		return result;
	}

	private String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		
		HttpSession session = request.getSession();
		session.setAttribute("loggedIn", true);
		boolean loggedIn = true;

		Users user = new Users(email, password);
		UsersService us = new UsersService();
		System.out.println("I am In");
		Boolean loginStatus = us.loginUser(email, password);
		if (loginStatus) {
			System.out.println("Login Success");
			session.setAttribute("loggedIn", loggedIn);
			result = "/views/menu.jsp";
		} else {
			System.out.println("Login failed");
			request.setAttribute("errorMessage", "Invalid username or password");
			result = "/views/login.jsp";
		}
		
		
		return result;

	}

}
