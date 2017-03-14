package org.amadeus.charon.data;

import junit.framework.TestCase;

public class isAdminTest extends TestCase {

	public void testIsAdmin() {
		UserManager userManager = UserManager.getInstance();
	    userManager.registerAdmin("admin", "admin@webmaster.com", "adminpassword");
	    User user = userManager.getUser("admin", "adminpassword");
	    assertNotNull(user);
	    assertEquals(true, user.isAdmin());
	}
	
	public void testIsntAdmin() {
	    UserManager userManager = UserManager.getInstance();
	    userManager.registerUser("user", "user@webmaster.com", "userpassword");
        User user = userManager.getUser("user", "userpassword");
        assertNotNull(user);
        assertEquals(false, user.isAdmin());
	}
	
}
