package org.amadeus.charon.data;


import org.amadeus.charon.data.UserManager.LoginMessage;
import org.junit.Test;

import junit.framework.TestCase;

public class Userlogin extends TestCase{
  
  //test empty usernames or passwords
  @Test
  public void testisEmpty() {
    UserManager testuser = UserManager.getInstance();
    User test = new User("", "", "");
    LoginMessage result = testuser.login(test);
    assertEquals(LoginMessage.EMPTY, result);
  }
  //test the usernames and passwords correctly
  @Test
  public void testisCorrect(){
    UserManager userManager = UserManager.getInstance();
    userManager.register("joe", "email@email.com", "password");
    
    User user = new User("joe", "email@email.com", "password");
    LoginMessage result = userManager.login(user);
    assertEquals(LoginMessage.SUCCESS, result);
    
    //check incorrect
    User fakeUser = new User("fake", "fake@fake.com", "fakepassword");
    
    result = userManager.login(fakeUser);
    assertEquals(LoginMessage.FAILURE,result);
  }
  
}
