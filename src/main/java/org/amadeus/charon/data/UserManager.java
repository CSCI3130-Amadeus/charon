package org.amadeus.charon.data;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager {

  public enum LoginMessage  {
      SUCCESS,
      FAILURE,
      EMPTY
  }
  
  
  private ArrayList<User> users;
  private static UserManager instance;

  private UserManager() {
	  users = new ArrayList<User>();
  }
  
  public boolean isEmpty(User user){
	  if(user.getUsername().equals("")||user.getPassword().equals("")){
		  return true;
	  }
	  return false;
  }
  
 public LoginMessage login(User user){

   
   if (isEmpty(user)) {
     return LoginMessage.EMPTY;
   }
   
	 for(int i=0;i<users.size();i++){
		 if(user.getUsername().equals(users.get(i).getUsername())&&
		     user.getPassword().equals(users.get(i).getPassword())){
			 return LoginMessage.SUCCESS;
		 }
	 }

	 return LoginMessage.FAILURE;
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
	  return email.contains("@");
	  
	  
  }
}
