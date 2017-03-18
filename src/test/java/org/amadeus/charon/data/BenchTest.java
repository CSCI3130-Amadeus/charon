package org.amadeus.charon.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.vaadin.testbench.TestBenchTestCase;


public class BenchTest extends TestBenchTestCase {

	@Before
	public void setUp() throws Exception{
		try {
		    setDriver(new PhantomJSDriver());
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	@Test
	public void openTestUrl() {
	    try {
	        getDriver().get("http://localhost:8080/");
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@After
	public void tearDown(){
	    getDriver().close();
	}
}
