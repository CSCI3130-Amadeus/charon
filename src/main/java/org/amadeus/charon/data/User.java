package org.amadeus.charon.data;

public class User {
	private String Username;
	private String Userpassword;
	private int admin;

public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getUserpassword() {
	return Userpassword;
}
public void setUserpassword(String userpassword) {
	Userpassword = userpassword;
}
public void setadmin(int i){
	admin = i;
}
public int getadmin(){
	return admin;
}
}
