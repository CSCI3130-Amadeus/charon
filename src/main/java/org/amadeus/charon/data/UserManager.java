package org.amadeus.charon.data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserManager {

    public static final String PERSISTENCE_UNIT = "charon_db";

    private EntityManager em;
    
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
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emFactory.createEntityManager();
    }
  
    public LoginMessage login(String username, String password){
        if (username.equals("") || password.equals("")) {
            return LoginMessage.EMPTY;
        }

        List<User> users = getUserList();
        
        for (User user : users) {
            if (user.getUsername().equals(username)){
                if (user.getPassword().equals(password)){
                    return LoginMessage.SUCCESS;
                }
                else {
                    return LoginMessage.INVALID_PASSWORD;
                }
            }
        }

        return LoginMessage.INVALID_USERNAME;
    }
    
    
    public void createTestUserData() {
        em.getTransaction().begin();
        User john = new User("John", "john@email.com", "password1", 1);
        User jane = new User("Jane", "jane@email.com", "password1", 1);

        em.persist(john);
        em.persist(jane);
        
        em.getTransaction().commit();
    }
    
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public boolean registerUser(String username, String email, String password) {
        return register(username, email, password, 1);
    }
    
    public boolean registerAdmin(String username, String email, String password) {
        return register(username, email, password, 0);
    }


    protected User getUser(String username, String password){
        List<User> users = getUserList();
        
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        
        return null;
    }
    
    private boolean register(String userName,String email,String password, int role){
        
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
                User user = new User(userName,email,password, role);
//                users.put(user.getUsername(), user);
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                
                return true;	 
            }
        }
        return false;
    }
    
    private boolean usernameInUse(String username) {
        List<User> users = getUserList();
        
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        
        return false;
    }

    private boolean checkEmail(String email){
        return email.contains("@");
    }
  
    private List<User> getUserList(){
        // This is all to do one query.......
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootUser = cq.from(User.class);
        cq.select(rootUser);
        TypedQuery<User> q = em.createQuery(cq);
        List<User> users = q.getResultList();
        
        return users;
    }

}
