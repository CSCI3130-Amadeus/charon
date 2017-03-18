package org.amadeus.charon;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextAreaElement;


public class ReviewCourseUITest extends TestBenchTestCase {

	@Before
	public void setUp() throws Exception{
	    setDriver(new PhantomJSDriver());
	}
	
	@Test
	public void testReviewComponent() {
        getDriver().get("http://localhost:8080/");
        
        $(TextAreaElement.class).id("COMMENT_ENTRY").setValue("This is a review!");
        $(ButtonElement.class).id("SUBMIT_BUTTON").click();
        
        String result = $(LabelElement.class).id("RESULT").getText();
        
        assertEquals("Success!", result);
	}
	
	@After
	public void tearDown(){
	    getDriver().close();
	}
}
