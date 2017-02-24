package org.amadeus.charon.data;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Userlogin {

	@Before
	public void Before(){
		System.out.println("Before the tset");
	}
	@After
	public void After(){
		System.out.println("Done");
	}
	//test empty usernames or passwords
	@Test
	public void testisEmpty() {
		UserManager testuser = new UserManager();
		User test = new User();
		
		test.setUsername("");
		test.setUserpassword("");
		int output = testuser.isEmpty(test);
		assertEquals(1,output);
		
		test.setUsername("asdasdasd");
		test.setUserpassword("zxcasdasd");
		int output2 = testuser.isEmpty(test);
		assertEquals(0,output2);
	}
	//test the usernames and passwords correctly
	@Test
	public void testisCorrect(){
		UserManager testuser = new UserManager();
		User test = new User();
		//check correct
		test.setUsername("aaaaa");
		test.setUserpassword("bbbbb");
		
		testuser.UserManagerAdd("aaaaa", "bbbbb");
		
		int output = testuser.isCorrect(test);
		assertEquals(1,output);
		
		//check incorrect
		test.setUsername("aaaaa");
		test.setUserpassword("bbbb");
		
		testuser.UserManagerAdd("aaaaa", "bbbbb");
		
		output = testuser.isCorrect(test);
		assertEquals(0,output);
	}
	

}
