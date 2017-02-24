package org.amadeus.charon.data;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager {

  private ArrayList<User> users;
  private static UserManager instance;

  private UserManager() {
	  users = new ArrayList<User>();
  }
  
  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }
  

  public boolean register(String userName,String email,String password){
	  if(userName.equals("")||password.equals("")||email.equals("")){
		  return false;
	  }
	  else if(password.length() < 8){
		  
		  return false;
	  }
	  else if(!checkEmail(email)){
		  
		  return false;
	  }
	  else{
		  User user = new User(userName,email,password);
		  users.add(user);
		  return true;	 
	  }
	    
  }
  private boolean checkEmail(String email){
	  System.out.println(email);
	  return email.contains("@");
	  
	  
  }
}
