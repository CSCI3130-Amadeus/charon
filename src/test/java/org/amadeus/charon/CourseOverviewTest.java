package org.amadeus.charon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.vaadin.testbench.TestBenchTestCase;


public class CourseOverviewTest extends TestBenchTestCase {

 
	@Before
	public void setUp(){
		setDriver(new PhantomJSDriver());
	}
	
	@Test
	   public void openTestUrl() {
	        getDriver().get("http://localhost:8080");
	        
	        String testId = "test";
	        //Check if layout exists
	        //assertTrue($(VerticalLayoutElement.class).id("cop").exists());
	        
	    }
	      
	    
	    @After
	    public void tearDown(){
	        getDriver().quit();
	    }
	    	
	    	
	    	
}//CloseOverviewTest
	   
       
       
   