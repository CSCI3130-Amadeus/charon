package org.amadeus.charon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class isAdminTest {

    @Before
    public void setupTest(){
        UserManager userManager = UserManager.getInstance();
        userManager.registerAdmin("admin", "admin@webmaster.com", "adminpassword");
        userManager.registerUser("user", "user@webmaster.com", "userpassword");
    }
    
    @Test
	public void testIsAdmin() {
        UserManager userManager = UserManager.getInstance();
		User user = userManager.getUser("admin");
	    assertNotNull(user);
	    assertEquals(true, user.isAdmin());
	}
    
	@Test
	public void testIsntAdmin() {
	    UserManager userManager = UserManager.getInstance();
	    User user = userManager.getUser("user");
        assertNotNull(user);
        assertEquals(false, user.isAdmin());
	}
}
