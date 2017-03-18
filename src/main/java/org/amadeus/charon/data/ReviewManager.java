package org.amadeus.charon.data;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReviewManager {

    public static final String PERSISTENCE_UNIT = "charon_db";

    private EntityManager em;
  
    private static ReviewManager instance;
    
    private ReviewManager() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emFactory.createEntityManager();
    }
    
    public static ReviewManager getInstance(){
        if (instance == null) {
            instance = new ReviewManager();
        }
        
        return instance;
    }
    
    public long createReview(String comment, User user, Course course){
        
        if (!comment.equals("") && comment != null){
            Review review = new Review(comment, user, course);
            
            em.getTransaction().begin();
            
            Collection<Review> reviews = course.getReviews();
            reviews.add(review);
            review.setCourse(course);
            course.setReviews(reviews);
            
            em.merge(course);
            em.persist(review);
            
            em.getTransaction().commit();
            
            return review.getId();
        }   
        return -1L;
    }
    
    
    protected Review getCourse(long id) {
        return em.find(Review.class, id);        
    }

}
