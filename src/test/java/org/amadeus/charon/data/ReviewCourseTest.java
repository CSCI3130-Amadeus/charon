package org.amadeus.charon.data;

import com.vaadin.ui.*;
import org.junit.*;


import static org.junit.Assert.*;

public class ReviewCourseTest {
    
    
    private static final String username = "john";
    private static final String persistanceTestCourseCode = "TEST3130";
    private static final String ratingTestCourseCode = "RATE3130";
	private static final ListSelect testList = new ListSelect();
    

    private static final String SYLLABUS_PATH = "target/upload/test.pdf";

    @Before
    public void setupTest(){
        UserManager.getInstance().registerUser(username, "fake@fake.com", "passssword");
        CourseManager.getInstance().createCourse(persistanceTestCourseCode, "Software Engineering", "Lorem Ipsum", null);
        CourseManager.getInstance().createCourse(ratingTestCourseCode, "Rating test", "Lorem Ipsum", null);
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
    public void confirmPathTest() {
        Course course = CourseManager.getInstance().getCourseByCode(persistanceTestCourseCode);
        assertTrue(course.getSyllabusPath().equals(SYLLABUS_PATH));
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
