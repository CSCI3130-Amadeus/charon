package org.amadeus.charon.data;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vaadin.ui.ListSelect;

public class ReviewManager {

    public static final String PERSISTENCE_UNIT = "charon_db";

    private EntityManagerFactory emFactory;
  
    private static ReviewManager instance;
    
    private ReviewManager() {
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }
    
    public static ReviewManager getInstance(){
        if (instance == null) {
            instance = new ReviewManager();
        }
        
        return instance;
    }
    
    public boolean createReview(String comment, User user, Course course, String rating){
        
        if (!comment.equals("") && comment != null){
        	EntityManager em = emFactory.createEntityManager();
        	em.getTransaction().begin();
            Review review = new Review(comment, user, course, rating);
            course.getReviews().add(review);
            em.merge(course);
            em.persist(review);
            em.getTransaction().commit();
            em.close();
            return true;
        }   
        return false;
    }
    
    
    protected Review getCourse(long id) {
    	EntityManager em = emFactory.createEntityManager();
    	Review review = em.find(Review.class, id);
    	em.close();
    	return review;
    }
    

}
