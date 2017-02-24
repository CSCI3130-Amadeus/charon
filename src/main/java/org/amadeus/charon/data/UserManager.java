package org.amadeus.charon.data;

public class UserManager {

  private static UserManager instance;
  
  UserManager() {
  
  }
  
  public static UserManager getInstance() {
    if (instance == null) {
      instance = new UserManager();
    }
    return instance;
  }
  
  public boolean isAdmin(int index){
	  User admin = new User();
	  if (admin.isAdmin(index) == true){
		  return true;
	  }
	  else{
		  return false;
	  }
  }
}
