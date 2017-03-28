package org.amadeus.charon.ui;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextAreaElement;

public class CourseListUITest extends TestBenchTestCase{

	@Before
	public void setUp() throws Exception{
	    setDriver(new PhantomJSDriver());
	}
	
	@Test
	public void testReviewComponent() {
        getDriver().get("http://localhost:8080/");
        
        
        
        assertNotNull($(LabelElement.class).id("COURSELIST"));
        
        
	}
	
	@After
	public void tearDown(){
	    getDriver().close();
	}

}
