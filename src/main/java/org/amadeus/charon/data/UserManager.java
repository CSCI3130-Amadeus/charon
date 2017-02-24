package org.amadeus.charon.data;
import java.util.ArrayList;

public class UserManager {
ArrayList <User> Users = new ArrayList <User> ();
User user = new User();
  private static UserManager instance;
  
  UserManager() {

  }
  public void UserManagerAdd(String name,String password){
	  User user = new User();
	  user.setUsername(name);
	  user.setUserpassword(password);
	  Users.add(user);
  }
  private void UserManagerDelete(String name,String password){
	  
  }
  public int isEmpty(User user){
	  if(user.getUsername().equals("")&&user.getUserpassword().equals("")){
		  return 1;
	  }
	  return 0;
  }
 public int isCorrect(User user){
	 for(int i=0;i<Users.size();i++){
		 if(user.getUsername().equals(Users.get(i).getUsername())&&user.getUserpassword().equals(Users.get(i).getUserpassword())){
			 return 1;
		 }
	 }

	 return 0;
 }
  
  
  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }
}
