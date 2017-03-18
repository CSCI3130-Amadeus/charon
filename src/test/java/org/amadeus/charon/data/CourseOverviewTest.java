package org.amadeus.charon.data;

import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.GridElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import static org.junit.Assert.*;

import java.util.List;


public class CourseOverviewTest extends TestBenchTestCase {

 
	@Before
	public void setUp() throws Exception{
		setDriver(new PhantomJSDriver());
	}
	
	@Test
	   public void openTestUrl() {
	        getDriver().get("http://localhost:8080");
	        assertTrue($(GridElement.class).exists());	    
	    }
	      
	    
	    @After
	    public void tearDown() throws Exception {
	        getDriver().quit();
	    }
	    	
	    	
	    	
}//CloseOverviewTESt
	   
       
       
   