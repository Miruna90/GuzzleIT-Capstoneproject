/*
 * Filename: TestUsers.java
* Author: Mirunalini
* 03/18/2020 
 */
package com.guzzleIT.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.guzzleIT.data.Users;
import com.guzzleIT.data.UsersService;

/**
 * @author drmir
 *
 */
class TestUsers {
	
	Users user = new Users("tom5@gmail.com","XXXXX");
	
	UsersService us = new UsersService();
	String expectedEmail ="tom5@gmail.com"; 
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		us.add(user);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		//us.deleteByEmail(expectedEmail);
	}

	/**
	 * Test method for {@link com.guzzleIT.data.UsersService#findUserByEmail(java.lang.String)}.
	 */
	@Test
	void testFindUserByEmail() {
		Users selectedUserObj = us.findUserByEmail("tom5@gmail.com");
		String selectedUserEmail = selectedUserObj.getEmail();
		assertEquals(expectedEmail,selectedUserEmail);
	} 

	/**
	 * Test method for {@link com.guzzleIT.data.UsersService#emailExists(java.lang.String)}.
	 */
//	@Test
//	void testEmailExists() {
//		boolean T = true;
//		boolean F = false;
//		
//		boolean selectedEmail = us.emailExists("tom1@gmail.com");
//		assertEquals(selectedEmail,T);
//		boolean selectedEmail1 = us.emailExists("hjk@gmail.com");
//		assertEquals(selectedEmail1,F);
//		
//	}

	/**
	 * Test method for {@link com.guzzleIT.data.UsersService#loginUser(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testLoginUser() {
		fail("Not yet implemented");
	}

}
