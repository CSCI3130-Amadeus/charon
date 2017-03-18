package org.amadeus.charon.data;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.vaadin.testbench.TestBenchTestCase;




public class CourseOverviewTest extends TestBenchTestCase {

 	  
	   @Before
	   public void setUp() throws Exception {
	       setDriver(new PhantomJSDriver());
	   }
	   
	   @Test
	   public void openTestOverview() {
	        getDriver().get("http://localhost:8080/");
	        
	    }
	   
	   @After
	   public void tearDown() throws Exception {
	       getDriver().quit();
	   }
	    	
	    	
}//CloseOverviewTESt
	   
       
       
   