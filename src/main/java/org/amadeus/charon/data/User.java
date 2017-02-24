package org.amadeus.charon.data;

public class User {

	
	public int index;//index from database check whether user is admin
	
	public boolean isAdmin(int index){
		boolean admin = false;
		if(index == 1){
			admin = true;
		}
		return admin;
	}
}
