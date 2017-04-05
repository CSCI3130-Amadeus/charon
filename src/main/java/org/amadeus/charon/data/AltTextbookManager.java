package org.amadeus.charon.data;

import javax.persistence.*;

public class AltTextbookManager {

    public static final String PERSISTENCE_UNIT = "charon_db";

    private EntityManagerFactory emFactory;

    private static AltTextbookManager instance;

    private AltTextbookManager() {
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }
    
    public static AltTextbookManager getInstance(){
        if (instance == null) {
            instance = new AltTextbookManager();
        }
        
        return instance;
    }
    
    public boolean createAltTextbook(String title, String url, User user, Course course){
        
        if (!title.equals("") && title != null){
        	EntityManager em = emFactory.createEntityManager();
        	em.getTransaction().begin();
            // Create the textbook
            AltTextbook altTextbook = new AltTextbook(user, course, title, url);
            // Add the textbook
            course.getAltTextbooks().add(altTextbook);
            // Persist the object
            em.persist(altTextbook);
            // Save changes to course.
            em.merge(course);
            // Complete the transaction.
            em.getTransaction().commit();
            em.close();
            return true;
        }   
        return false;
    }
}
