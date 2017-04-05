package org.amadeus.charon.data;

import org.junit.*;


import static org.junit.Assert.assertEquals;

/**
 * Created by aaron on 03/04/17.
 */
public class AddAltTextbookTest {

    private static final String USERNAME = "cicero";
    private static final String EMAIL = "cicero@marble.column";
    private static final String PASSWORD = "cicero_is_rad";

    private static final String COURSE_CODE = "IPSU 1000";
    private static final String COURSE_NAME = "Introduction to Lorem Ipsum";
    private static final String COURSE_DESC = "Lorem Ipsum si dolor amet.";

    private static final String ALT_TEXT_TITLE = "Into to Lorem Ipsum";
    private static final String ALT_TEXT_URL = "https://lorem.ipsum.dev";

    @Before
    public void setupTest(){
        UserManager.getInstance().registerUser(USERNAME, EMAIL, PASSWORD);
        CourseManager.getInstance().createCourse(COURSE_CODE, COURSE_NAME, COURSE_DESC, null);
    }


    @Test
    public void addAltTextbookTest(){

        User user = UserManager.getInstance().getUser(USERNAME);
        Course course = CourseManager.getInstance().getCourseByCode(COURSE_CODE);
        AltTextbookManager.getInstance().createAltTextbook(ALT_TEXT_TITLE, ALT_TEXT_URL, user, course);

        Course loadedFromDB = CourseManager.getInstance().getCourseByCode(COURSE_CODE);

        assertEquals(loadedFromDB.getAltTextbooks().size(), 1);
    }
}
