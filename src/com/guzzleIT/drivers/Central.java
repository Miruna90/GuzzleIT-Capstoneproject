package com.guzzleIT.drivers;

import com.guzzleIT.data.CustomerService;
import com.guzzleIT.data.ProductService;
import com.guzzleIT.data.Users;
import com.guzzleIT.data.UsersService;

public class Central {

	public static void main(String[] args) {
	
		Central c = new Central();
		c.run();
	}
	public void run() {
		ProductService ps = new ProductService();
		ps.selectProduct("4001");
		//System.out.println(ps);
		
//		ps.findProductById(1);
//		
//		UsersService us = new UsersService();
//		us.findUserById(2);
//		
		Users user =new Users("miru@gmail.com","OOOOO");
		UsersService us1 = new UsersService();
//		us1.add(user);
		String email="test@test.com";
		us1.emailExists(email);
		String email1="test123@test.com";
		us1.emailExists(email1);
//		UsersService us = new UsersService();
    	 //Boolean loginStatus = us.loginUser("sam@gmail.com", "XXXXX");
    	 //System.out.println(loginStatus);
//    	 Boolean loginStatus1 = us.loginUser("test@test.com", "1234");
//    	 System.out.println(loginStatus1);
    	
    	
//		CustomerService cs = new CustomerService();
//		cs.findUserById(2);
//		cs.update(2, "peter", "top", "peter@gmail.com", "YYYYYY", "12345654", "23,Adams", "Rochester", "MI", 48023, null);
//		cs.findUserById(2);
	}

}
