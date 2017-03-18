package org.amadeus.charon.data;

import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;


import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class BenchTest extends TestBenchTestCase {

   
	@Before
	public void setUp() throws Exception{
		setDriver(new PhantomJSDriver());
	}
	
	   private void openTestUrl() {
	        getDriver().get("http://localhost:8080/");
	    }


   }


