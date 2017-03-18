package org.amadeus.charon.data;

import com.vaadin.testbench.ScreenshotOnFailureRule;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.GridElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.PanelElement;
import com.vaadin.testbench.elements.FormLayoutElement;
import com.vaadin.testbench.elements.GridLayoutElement;
import com.vaadin.testbench.elements.VerticalLayoutElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.framework.TestCase;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import static org.junit.Assert.*;

import java.util.List;


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
	   
       
       
   