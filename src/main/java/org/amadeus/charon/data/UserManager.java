package org.amadeus.charon.data;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.amadeus.charon.data.User.UserType;

public class UserManager {

    public static final String PERSISTENCE_UNIT = "charon_db";

    private EntityManager em;
    
    
    public enum LoginMessage  {
        SUCCESS,
        INVALID_PASSWORD,
        INVALID_USERNAME,
        EMPTY
    }
  
    private static UserManager instance;
   
    private User authedUser;
    
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    
    private UserManager() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emFactory.createEntityManager();
    }
  
    public LoginMessage login(String username, String password){
        if (username.equals("") || password.equals("")) {
            return LoginMessage.EMPTY;
        }

        User user = getUser(username);

        if (user != null){
            if (user.getPassword().equals(password)){
                authedUser = user;
                return LoginMessage.SUCCESS;
            }
            else {
                return LoginMessage.INVALID_PASSWORD;
            }
        }
        else {
            return LoginMessage.INVALID_USERNAME;        
        }
        
    }
    
    public void logout(){
        authedUser = null;
    }
    

    public boolean registerUser(String username, String email, String password) {
        return register(username, email, password, UserType.PUBLIC);
    }
    
    public boolean registerAdmin(String username, String email, String password) {
        return register(username, email, password, UserType.ADMIN);
    }

    // This is protected so that the unit tests can test it.
    protected User getUser(String username){
        // Set up query.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootUser = cq.from(User.class);
        // Select where usernames are equal
        cq.where(cb.equal(rootUser.get("username"), cb.parameter(String.class, "username")));
        Query q = em.createQuery(cq);
        // Set the username to the given username.
        q.setParameter("username", username);
        // Get results (there should only be one.)
        List<User> result = q.getResultList();
        if(result.size() == 1){
            return result.get(0);
        }
        // No user found. 
        return null;
    }
    /**
     * Registers a user in the database.
     * This method will confirm that the email and password meet
     * certain requirements, as well as if another user with that
     * username exists. 
     * 
     * @param userName - The desired username
     * @param email - The desired email
     * @param password - The desired password
     * @param role - 
     * @return
     */
    private boolean register(String userName,String email,String password, UserType userType){
        
        // Check to see if username has already been registered.
        if (!usernameInUse(userName)){
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
                User user = new User(userName,email,password, userType);
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                
                return true;	 
            }
        }
        return false;
    }
    
    private boolean usernameInUse(String username) {
        
        if (getUser(username) == null){
            return false;
        }
        
        return true;
    }

    // Used in email confirmation.
    // TODO: Make this better.
    private boolean checkEmail(String email){
        return email.contains("@");
    }

    public User getAuthedUser() {
        return authedUser;
    }
    
    
}
