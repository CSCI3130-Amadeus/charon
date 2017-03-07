package org.amadeus.charon.data;
import java.util.HashMap;

public class UserManager {

    public enum LoginMessage  {
        SUCCESS,
        INVALID_PASSWORD,
        INVALID_USERNAME,
        EMPTY
    }
  
    private HashMap<String, User> users;
    private static UserManager instance;
    
    private UserManager() {
        users = new HashMap<String, User>();
    }
  
    public LoginMessage login(String username, String password){
        if (username.equals("") || password.equals("")) {
            return LoginMessage.EMPTY;
        }
        User user = users.get(username);
        if (user == null) {
            return LoginMessage.INVALID_USERNAME;
        }
        if (user.getPassword().equals(password)){
            return LoginMessage.SUCCESS;
        }
        return LoginMessage.INVALID_PASSWORD;
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
            users.put(user.getUsername(), user);
            return true;	 
        }
    }

    private boolean checkEmail(String email){
        return email.contains("@");
    }
}
