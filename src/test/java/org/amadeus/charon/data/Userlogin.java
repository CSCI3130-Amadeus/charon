package org.amadeus.charon.data;

import org.amadeus.charon.data.UserManager.LoginMessage;
import org.junit.Test;
import junit.framework.TestCase;

public class Userlogin extends TestCase{
    //test empty usernames or passwords
    @Test
    public void testisEmpty() {
        UserManager testuser = UserManager.getInstance();
        LoginMessage result = testuser.login("", "");
        assertEquals(LoginMessage.EMPTY, result);
    }
    //test the usernames and passwords correctly
    @Test
    public void testisCorrect(){
        UserManager userManager = UserManager.getInstance();
        userManager.registerUser("joe", "email@email.com", "password");
        
        LoginMessage result = userManager.login("joe", "password");
        assertEquals(LoginMessage.SUCCESS, result);

        result = userManager.login("joe", "fakepasword");
        assertEquals(LoginMessage.INVALID_PASSWORD, result);
        
        result = userManager.login("fake", "fakepasword");
        assertEquals(LoginMessage.INVALID_USERNAME, result);        
    }
}
