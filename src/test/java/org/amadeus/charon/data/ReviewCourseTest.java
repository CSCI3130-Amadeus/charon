package org.amadeus.charon.data;

import org.junit.*;


import static org.junit.Assert.*;

public class ReviewCourseTest {
    
    
    private static final String username = "john";
    private static final String courseCode = "TEST3130";

    private static final String SYLLABUS_PATH = "target/upload/test.pdf";

    @Before
    public void setupTest(){
        UserManager.getInstance().registerUser(username, "fake@fake.com", "passssword");
        CourseManager.getInstance().createCourse(courseCode, "Software Engineering", "Lorem Ipsum", SYLLABUS_PATH);
    }

    
    @Test
    public void testPersistence() {
        
        User user = UserManager.getInstance().getUser(username);
        Course course = CourseManager.getInstance().getCourseByCode(courseCode);
        String comment = "Lorem ipsum si dolor amet";
        
        ReviewManager.getInstance().createReview(comment, user, course);
        
        Course loadedFromDB = CourseManager.getInstance().getCourseByCode(courseCode);
        
        assertTrue(loadedFromDB.getReviews().size() >= 1);
    }

    @Test
    public void confirmPathTest() {
        Course course = CourseManager.getInstance().getCourseByCode(courseCode);
        assertTrue(course.getSyllabusPath().equals(SYLLABUS_PATH));
    }
    
    @Test
    public void badReviewTest() {
        
        User user = UserManager.getInstance().getUser(username);
        Course course = CourseManager.getInstance().getCourseByCode(courseCode);
        String comment = "";
        
        assertFalse(ReviewManager.getInstance().createReview(comment, user, course));
    }
}
