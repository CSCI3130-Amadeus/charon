package org.amadeus.charon.ui;

import com.vaadin.testbench.*;
import com.vaadin.testbench.elements.*;
import java.util.*;
import org.amadeus.charon.ui.components.*;
import org.amadeus.charon.ui.pages.*;
import org.junit.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.phantomjs.*;


import static org.junit.Assert.*;

public class EndToEndTest extends TestBenchTestCase{

    private static final String PUBLIC_USERNAME = "public_user";
    private static final String PUBLIC_PASSWORD = "password";
    
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";
    
    private static final String COURSE_CODE = "CSCI3130";
    private static final String COURSE_NAME = "Software Engineering";
    private static final String COURSE_DESC = "Lorem ipsum si dolor amet";
    
    private static final String COURSE_RATING = "1";
    
    private static final String PNG_PATH = "src/main/resources/test.png";
    private static final String PDF_PATH = "src/main/resources/test.pdf";

    @Rule
    public ScreenshotOnFailureRule screenshotOnFailureRule =
        new ScreenshotOnFailureRule(this, true);
    
	@Before
	public void setUp() throws Exception{
	    Parameters.setScreenshotErrorDirectory("target/testbench/screenshot_errors");
	    setDriver(new PhantomJSDriver());
	    getDriver().get("http://localhost:8080/");
	}
	
	
	@Test
	public void integrationTest() {
	    
	    // Start the test by logging in as the administrator.
	    loginAdmin();
	    // Navigate to the add course page.
	    navigateToAddCourse();
	    // Add a course to the list
	    addCourse();
	    // Open the course page on the course list view.
	    clickCourse(COURSE_CODE);
	    // Check to make sure all the entered information is there.
	    assertTrue(checkCoursePage(COURSE_CODE, COURSE_NAME, COURSE_DESC));
	    // Return to the course list page.
	    clickHome();
	    // Log out of the admin user.
	    clickLogout();
        // Start the test by logging in as the administrator.
        loginPublic();
        // Open the course page on the course list view.
        clickCourse(COURSE_CODE);
        // Submit a review
        submitReview();
        // Return to the course list page.
        clickHome();
        // Log out of the admin user.
        clickLogout();
	}
	
	
	/**
	 *  Start state: Login screen
	 *  End state: Course list page
	 */
	private void loginAdmin(){
	   
	   System.out.println("Logging in as admin...");
	   try {
	       $(TextFieldElement.class).id(UserLoginPage.USERNAME_ID).setValue(ADMIN_USERNAME);
           $(PasswordFieldElement.class).id(UserLoginPage.PASSWORD_ID).setValue(ADMIN_PASSWORD);
           $(ButtonElement.class).id(UserLoginPage.SUBMIT_ID).click();
	   }
	   catch (NoSuchElementException e){
	       e.printStackTrace();
	       
	       fail();
	   }
	}
	
	/**
     *  Start state: Login screen
     *  End state: Course list page
     */
    private void loginPublic(){
       
       System.out.println("Logging in as public...");
       try {
           $(TextFieldElement.class).id(UserLoginPage.USERNAME_ID).setValue(PUBLIC_USERNAME);
           $(PasswordFieldElement.class).id(UserLoginPage.PASSWORD_ID).setValue(PUBLIC_PASSWORD);
           $(ButtonElement.class).id(UserLoginPage.SUBMIT_ID).click();
       }
       catch (NoSuchElementException e){
           e.printStackTrace();
           
           fail();
       }
    }
    
    /**
     * Start state: a course page
     * End state: a course page
     */
    private void submitReview(){
        System.out.println("Attempting to submit review...");
        try {
            String reviewString = "Review: " + System.currentTimeMillis();
            $(TextAreaElement.class).id(ReviewForm.REVIEW_FIELD_ID).setValue(reviewString);
            $(ListSelectElement.class).id(ReviewForm.REVIEW_RATING_ID).selectByText(COURSE_RATING);
            $(ButtonElement.class).id(ReviewForm.REVIEW_SUBMIT_ID).click();
            
            List<LabelElement> labels = $(LabelElement.class).all();
            boolean hasReviewLabel = false;
            boolean hasRatingLabel = false;
            for (LabelElement label : labels) {
                if (label.getText().equals(reviewString)){
                    hasReviewLabel = true;
                }
                if (label.getText().equals("Rating: " + COURSE_RATING)){
                	hasRatingLabel = true;
                }
            }
            
            assertTrue(hasReviewLabel);
            assertTrue(hasRatingLabel);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            
            fail();
        } 
    }
	
	/**
	 *  Start state: Course list page
	 *  End state: Add Course Page
	 */
	private void navigateToAddCourse() {
	    
	    System.out.println("Navigating to add course page...");
	    
	    try {
	        $(ButtonElement.class).id(CourseListPage.ADD_COURSE_ID).click();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            fail();
        }
	}
	
	/**
	 * State state: Add course page
	 * End state: Course list page.
	 * 
	 * 
	 * NOTE: We wrote this test as what *should* happen... if testbench supported
	 * the upload element properly. Testbench doesn't know how to set the file path,
	 * only how to click the button. 
	 */
	private void addCourse() {
	    
        System.out.println("Adding course " + COURSE_CODE + "...");
        
//        uploadBadFile();
//        uploadGoodFile();
        
        try {
    	    $(TextFieldElement.class).id(CourseCreatePage.COURSE_CODE_ID).setValue(COURSE_CODE);
    	    $(TextFieldElement.class).id(CourseCreatePage.COURSE_NAME_ID).setValue(COURSE_NAME);
    	    $(TextAreaElement.class).id(CourseCreatePage.COURSE_DESC_ID).setValue(COURSE_DESC);
    	    $(ButtonElement.class).id(CourseCreatePage.SUBMIT_ID).click();
        }
        catch (NoSuchElementException e){
           e.printStackTrace();
           fail();
        }
    }
	
	/**
	 * Start state: add course page
	 * End state: add course page
	 * 
	 * NOTE: We wrote this test as what *should* happen... if testbench supported
	 * the upload element properly. Testbench doesn't know how to set the file path,
	 * only how to click the button. 
	 */
	private void uploadBadFile(){
		System.out.println("Uploading " + PNG_PATH + " to course " + COURSE_CODE);
		
		try {
    	    $(UploadElement.class).id(CourseCreatePage.UPLOAD_FIELD_ID).sendKeys(PNG_PATH);
    	    $(UploadElement.class).id(CourseCreatePage.UPLOAD_FIELD_ID).click();
    	    boolean result = $(LabelElement.class).id(CourseCreatePage.MESSAGE_AREA)
    	    		.getText().equals(CourseCreatePage.ERROR_MESSAGE);
    	    assertTrue(result);
		}
        catch (NoSuchElementException e){
           e.printStackTrace();
           fail();
        }
	}

	/**
	 * Start state: add course page
	 * End state: add course page
	 */
	private void uploadGoodFile(){
		System.out.println("Uploading " + PDF_PATH + " to course " + COURSE_CODE);
		
		try {
    	    $(UploadElement.class).id(CourseCreatePage.UPLOAD_FIELD_ID).sendKeys(PDF_PATH);
    	    $(UploadElement.class).id(CourseCreatePage.UPLOAD_FIELD_ID).click();
    	    boolean result = $(LabelElement.class).id(CourseCreatePage.MESSAGE_AREA)
    	    		.getText().equals(CourseCreatePage.SUCCESS_MESSAGE);
    	    assertTrue(result);
		}
        catch (NoSuchElementException e){
           e.printStackTrace();
           fail();
        }
	}
	
	/**
	 * Start state: Course list page
	 * End State: Course page with the given course code
	 * 
	 * @param courseCode - The course to navigate to.
	 */
	private void clickCourse(String courseCode) {

	    try {
            System.out.println("Navigating to  " + COURSE_CODE + " overview...");
            $(ButtonElement.class).id(COURSE_CODE).click();
    	}
        catch (NoSuchElementException e){
           e.printStackTrace();
           fail();
        }
	}
	
	/**
	 * Start state: Course overview page
	 * End State: Course overview page
	 * @param courseCode
	 * @param courseName
	 * @param courseDesc
	 */
	private boolean checkCoursePage(String courseCode, String courseName, String courseDesc) {
	    
	    System.out.println("Checking content on " + courseCode + " overview");
	    try {
	        String pageCourseCode = $(LabelElement.class).id(CourseOverviewPage.COURSE_CODE_ID).getText();
	        String pageCourseName = $(LabelElement.class).id(CourseOverviewPage.COURSE_NAME_ID).getText();
	        String pageCourseDesc = $(LabelElement.class).id(CourseOverviewPage.COURSE_DESC_ID).getText();
	            
	        boolean result = pageCourseCode.equals(courseCode);
	        
	        result = result & pageCourseName.equals(courseName);
	        result = result & pageCourseDesc.equals(pageCourseDesc);
	        
	        return result;
	    
	    }
        catch (NoSuchElementException e){
           e.printStackTrace();
           fail();
           return false;
        }   
	}
	
	/**
	 * Start state: Any page with the "Home" button.
	 * End state: THe course list page.
	 */
	private void clickHome() {

        System.out.println("Clicking on home page...");
	    try {
            $(ButtonElement.class).id(Navigator.HOME_ID).click();
	    }
	    catch (NoSuchElementException e){        
           e.printStackTrace();
           fail();
	    }
    }
	
	/**
     * Start state: Any page with the "logout" button.
     * End state: The user login page.
     */
    private void clickLogout() {
        System.out.println("Clicking on log out...");
        try {
            $(ButtonElement.class).id(LogoutBar.LOGOUT_ID).click();
        }
        catch (NoSuchElementException e){        
           e.printStackTrace();
           fail();
        }
    }
	
	@After
	public void tearDown(){
	    getDriver().close();
	}

}
