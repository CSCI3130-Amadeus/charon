package org.amadeus.charon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReviewCourseTest {
    
    
    private static final String username = "john";
    private static final String courseCode = "TEST3130";

    @Before
    public void setupTest(){
        UserManager.getInstance().registerUser(username, "fake@fake.com", "passssword");
        CourseManager.getInstance().createCourse(courseCode, "Software Engineering", "Lorem Ipsum");
    }

    
    @Test
    public void testPersistence() {
        
        User user = UserManager.getInstance().getUser(username);
        Course course = CourseManager.getInstance().getCourseByCode(courseCode);
        String comment = "Lorem ipsum si dolor amet";
        String rating = "2";
        
        ReviewManager.getInstance().createReview(comment, user, course, rating);
        
        Course loadedFromDB = CourseManager.getInstance().getCourseByCode(courseCode);
        
        assertTrue(loadedFromDB.getReviews().size() >= 1);
    }
    
    @Test
    public void badReviewTest() {
        
        User user = UserManager.getInstance().getUser(username);
        Course course = CourseManager.getInstance().getCourseByCode(courseCode);
        String comment = "";
        String rating = "";
        
        
        assertFalse(ReviewManager.getInstance().createReview(comment, user, course, rating));
    }
}
