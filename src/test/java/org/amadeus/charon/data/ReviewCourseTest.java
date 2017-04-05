package org.amadeus.charon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.steadystate.css.dom.Property;
import com.vaadin.data.Item;
import com.vaadin.ui.ListSelect; 

public class ReviewCourseTest {
    
    
    private static final String username = "john";
    private static final String persistanceTestCourseCode = "TEST3130";
    private static final String ratingTestCourseCode = "RATE3130";
	private static final ListSelect testList = new ListSelect();
    

    @Before
    public void setupTest(){
        UserManager.getInstance().registerUser(username, "fake@fake.com", "passssword");
        CourseManager.getInstance().createCourse(persistanceTestCourseCode, "Software Engineering", "Lorem Ipsum");
        CourseManager.getInstance().createCourse(ratingTestCourseCode, "Rating test", "Lorem Ipsum");
        
    }

    
    @Test
    public void testPersistence() {
        
        User user = UserManager.getInstance().getUser(username);
        Course course = CourseManager.getInstance().getCourseByCode(persistanceTestCourseCode);
        String comment = "Lorem ipsum si dolor amet";
        int rating = 3;
        
        ReviewManager.getInstance().createReview(comment, user, course, rating);
        
        Course loadedFromDB = CourseManager.getInstance().getCourseByCode(persistanceTestCourseCode);
        
        assertTrue(loadedFromDB.getReviews().size() >= 1);
    }
    
    @Test
    public void badReviewTest() {
        
        User user = UserManager.getInstance().getUser(username);
        Course course = CourseManager.getInstance().getCourseByCode(persistanceTestCourseCode);
        String comment = "";
        int rating = 3;
        
        assertFalse(ReviewManager.getInstance().createReview(comment, user, course, rating));
    }
    
    @Test
    public void testRating() {
    	int rating = 3;
    	User user = UserManager.getInstance().getUser(username);
    	Course course = CourseManager.getInstance().getCourseByCode(ratingTestCourseCode);
    	ReviewManager.getInstance().createReview("Review", user, course, rating);
    	
    	Course loadedFromDB = CourseManager.getInstance().getCourseByCode(ratingTestCourseCode);
    	
    	boolean hasRating = false;
    	
    	for (Review review : loadedFromDB.getReviews()) {
    		if (review.getRating() == rating) {
    			hasRating = true;
    		}
    	}
    	
    	assertTrue(hasRating);
    }
}
