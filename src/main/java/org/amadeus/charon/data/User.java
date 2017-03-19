package org.amadeus.charon.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User implements Serializable, Cloneable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 915243714087571416L;

    @NotNull
    @Size(min = 5, max = 64)
    private String username;
    
    @NotNull
    @Size(min = 5, max = 256)
    private String email;
    
    @NotNull
    @Size(min = 5, max = 64)
    private String password;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    Collection<Review> reviews;
    
    // TODO: If new functionality is added for these, use
    //       the "strategy" design pattern.
    public enum UserType {
        ADMIN,
        PUBLIC
    }
    
    @NotNull
    private UserType userType;
    
    public User(String username, String email, String password, UserType userType) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
    
    protected User() {
        
    }

    public boolean isAdmin(){
        
        return userType == UserType.ADMIN;
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

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        // TODO Auto-generated method stub
//        if (obj instanceof User) {
//            User user = (User)obj;
//            if (user.id == id) {
//                return true;
//            }
//        }
//        return false; 
//    }
//
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = (31*result + (int)id);
//        result = (31*result + username.hashCode());
//        result = (31*result + email.hashCode());
//        return result;
//    }
}
