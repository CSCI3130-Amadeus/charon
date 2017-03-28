package org.amadeus.charon.ui;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.LabelElement;


public class CourseOverviewTest extends TestBenchTestCase {

 
	@Before
	public void setUp(){
		setDriver(new PhantomJSDriver());
	}
	
	@Test
	   public void openTestUrl() {
	        getDriver().get("http://localhost:8080");
	        
	        assertNotNull($(LabelElement.class).id("cop"));
	        
	    }
	      
	    
	    @After
	    public void tearDown(){
	        getDriver().quit();
	    }
	    	
	    	
	    	
}//CloseOverviewTest
	   
       
       
   