/*
 * Filename: PopulateDatabase.java
* Author: Mirunalini
* 03/10/2020 
 */
package com.guzzleIT.drivers;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.guzzleIT.data.Customer;
import com.guzzleIT.data.CustomerService;
import com.guzzleIT.data.OrderDetails;
import com.guzzleIT.data.OrderDetailsService;
import com.guzzleIT.data.Orders;
import com.guzzleIT.data.OrdersService;
import com.guzzleIT.data.Product;
import com.guzzleIT.data.ProductService;
import com.guzzleIT.data.Users;
import com.guzzleIT.data.UsersService;

/**
 * @author drmir
 *
 */
public class PopulateDatabase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PopulateDatabase central = new PopulateDatabase();
		central.run();
	}

	private void run() {
		
		Product product1 = new Product("4001","Orange Morning","Carrot, Lemon, Apple, Ginger","medium",5.99);
		Product product2 = new Product("4002","Lemonade","Mint, Lemon, Ginger, Agava syrup","medium",5.99);
		Product product3 = new Product("4003","Choco Smoothie","Hazelnut,Date,Cinnamon,Chocolate powder,Ginger","medium",5.99);
		Product product4 = new Product("4004","Citrus Smoothie","Banana, Date, Orange,Ginger,Hemp seeds","medium",5.99);
		Product product5 = new Product("4005","Green day","Apple, Cucumber, lime, Spinach","medium",5.99);
		Product product6 = new Product("4006","Red Juice","Lemon, Apple, Beet, Carrot","medium",5.99);
		ProductService ps = new ProductService();
		ps.add(product1);
		ps.add(product2);
		ps.add(product3);
		ps.add(product4);
		ps.add(product5);
		ps.add(product6);
	    
//		OrderDetails orderdetails = new OrderDetails(1, 5.99,product1);
//		OrderDetailsService ods1 = new OrderDetailsService();
//		ods1.add(orderdetails);
//		List<OrderDetails> od1 = new ArrayList<>();
//		od1.add(orderdetails);
//		
//		OrderDetails orderdetails1 = new OrderDetails(2, 5.99,product2);
//		OrderDetails orderdetails2 = new OrderDetails(1, 5.99,product3);
//		OrderDetailsService ods2 = new OrderDetailsService();
//		ods2.add(orderdetails1);
//		ods2.add(orderdetails2);
//		List<OrderDetails> od2 = new ArrayList<>();
//		od2.add(orderdetails1);
//		od2.add(orderdetails2);
//		
//		Date date = new Date();
//		
//		Orders orders = new Orders(1,date,"complete","no milk",od1);
//		Orders orders1 = new Orders(2,date,"Process","vegan",od2);
//		OrdersService os = new OrdersService();
//		os.add(orders);
//		os.add(orders1);
//		List <Orders> o = new ArrayList<>();
//		o.add(orders);
//		o.add(orders1);
//		
//		Users user = new Users("sam@gmail.com","XXXXX");
//		Users user1 = new Users("Jack@gmail.com","xxxxx");
//		UsersService us = new UsersService();
//		us.add(user);
//		us.add(user1);
//	
//		
//		Customer customer =new Customer("Sam","Pat","1234566233","83timberview","Rochester hills","MI","48037",user,o);
//		Customer customer1 =new Customer("Jack","Pat","123456678","45timber","Rochester","MI","48037",user1,o);
//		CustomerService cs = new CustomerService();
//		cs.add(customer);
//		cs.add(customer1);
		
		
		
		
		
	}
}
