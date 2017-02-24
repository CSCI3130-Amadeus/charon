package org.amadeus.charon.data;

import junit.framework.TestCase;

public class isAdminTest extends TestCase {

	public void testIsAdmin() {
	  User.clearIndex();
		User admin = new User("admin", "admin@webmaster.com", "password");
		boolean result = admin.isAdmin();
		assertEquals(true, admin.isAdmin());
	}
	
	public void testIsntAdmin() {
	  User.clearIndex();
    User admin = new User("admin", "admin@webmaster.com", "password");
	  User user = new User("joe", "joe@email", "password");
		boolean result = user.isAdmin();
		assertEquals(false, result);
	}
	
}
