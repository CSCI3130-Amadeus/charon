package org.amadeus.charon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReviewCourseTest {
    
    
    private static final String username = "john";
    private long courseId;

    @Before
    public void setupTest(){
        UserManager.getInstance().registerUser(username, "fake@fake.com", "passssword");
        courseId = CourseManager.getInstance().createCourse("CSCI3130", "Software Engineering", "Lorem Ipsum");
    }

    
    @Test
    public void testPersistence() {
        
        User user = UserManager.getInstance().getUser(username);
        Course course = CourseManager.getInstance().getCourse(courseId);
        String comment = "Lorem ipsum si dolor amet";
        
        ReviewManager.getInstance().createReview(comment, user, course);
        
        Course loadedFromDB = CourseManager.getInstance().getCourse(courseId);
        
        assertTrue(loadedFromDB.getReviews().size() >= 1);
    }
    
    @Test
    public void badReviewTest() {
        
        User user = UserManager.getInstance().getUser(username);
        Course course = CourseManager.getInstance().getCourse(courseId);
        String comment = "";
        
        long id = ReviewManager.getInstance().createReview(comment, user, course);
        
        assertEquals(id, -1);
    }
}
