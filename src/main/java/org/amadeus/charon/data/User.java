package org.amadeus.charon.data;

public class User {
	
  String username,email,password;

	private int index;//index from database check whether user is admin
	
	private static int autoIncrement = 1;
	
  public User(String username, String email, String password) {
    super();
    this.username = username;
    this.email = email;
    this.password = password;
    index = autoIncrement;
    autoIncrement += 1;
  }

	public boolean isAdmin(){
	  System.out.print(index +": ");
		boolean admin = false;
		if(index == 1){
			admin = true;
		}
    System.out.println(admin);
		return admin;
	}
	
	public static void clearIndex() {
	  autoIncrement = 1;
	}
}
