/*
 * Filename: TestProduct.java
* Author: Mirunalini
* 03/18/2020 
 */
package com.guzzleIT.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.guzzleIT.data.Product;
import com.guzzleIT.data.ProductService;

/**
 * @author drmir
 *
 */
class TestProduct {

	ProductService ps = new ProductService();

	Product productObj = new Product("1234", "Orange", "Fresh Juice", "M", 4.99);

	String expectedProductName = "Orange";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ps.add(productObj);

	}

	/**
	 * @throws java.lang.Exception
	 */

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.guzzleIT.data.ProductService#selectProduct(java.lang.String)}.
	 */
	@Test
	void testAdd() {

		Product selectedProductObj = ps.selectProduct("1234");

		String actualProductName = selectedProductObj.getName();

		System.out.println("selected product name is " + actualProductName);

		assertEquals(expectedProductName, actualProductName);

	}

}
