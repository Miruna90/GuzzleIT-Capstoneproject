/*
 * Filename: TestCustomer.java
* Author: Mirunalini
* 03/18/2020 
 */
package com.guzzleIT.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.guzzleIT.data.Customer;
import com.guzzleIT.data.CustomerService;
import com.guzzleIT.data.OrderDetails;
import com.guzzleIT.data.Orders;
import com.guzzleIT.data.Product;
import com.guzzleIT.data.Users;

/**
 * @author drmir
 *
 */
class TestCustomer {

	private Customer underTest;
	private String expectedFirstName = "Jack";
	private CustomerService cs = new CustomerService();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Users user = new Users("jack1@gmail.com", "xxxx");
		Product product = new Product("1234", "Orange", "Fresh Juice", "M", 4.99);
		OrderDetails orderDetails = new OrderDetails(1, 5.99, product);
		List<OrderDetails> odList = new ArrayList();
		odList.add(orderDetails);
		Date date = new Date();
		Orders order = new Orders(1, date, "Process", "special", odList);
		List<Orders> oList = new ArrayList();
		oList.add(order);
		underTest = new Customer("Jack", "Daniel", "2342342345", "12 E road", "Detroit", "MI", "23456", user, oList);
		cs.add(underTest);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.guzzleIT.data.CustomerService#add(com.guzzleIT.data.Customer)}.
	 */
	@Test
	void testAdd() {
		String actualFirstName = underTest.getFirstName();
		assertEquals(expectedFirstName, actualFirstName);

	}

}
