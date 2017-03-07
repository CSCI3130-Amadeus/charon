package org.amadeus.charon.data;

public class User {

    private String username,email,password;

    private int index;//index from database check whether user is admin

    private static int autoIncrement = 1;

    public static int getAutoIncrement() {
        return autoIncrement;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
