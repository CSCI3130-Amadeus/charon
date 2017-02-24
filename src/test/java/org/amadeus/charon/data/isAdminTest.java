package org.amadeus.charon.data;

import junit.framework.TestCase;

public class isAdminTest extends TestCase {

	public void testIsAdmin() {
		UserManager test = new UserManager();
		boolean result = test.isAdmin(1);
		assertEquals(true, result);
	}
	
}
