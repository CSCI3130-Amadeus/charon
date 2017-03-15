package org.amadeus.charon.data;

import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class BenchTest extends TestBenchTestCase {

    @Rule
    public ScreenshotOnFailureRule screenshotOnFailureRule =
            new ScreenshotOnFailureRule(this, true);
	

	@Before
	public void setUp() throws Exception{
		setDriver(new PhantomJSDriver());
	}
	
	   private void openTestUrl() {
	        getDriver().get("http://localhost:8080/");
	    }
	    public void testClickButton() throws Exception {
	        openTestUrl();

	        // At first there should be no labels
	        assertFalse($(LabelElement.class).exists());
	        
	        // Set the name
	        TextFieldElement textField = $(TextFieldElement.class)
	        		.caption("Type your name here:").first();
	        textField.setValue("User");

	        // Click the button
	        ButtonElement clickMeButton = $(ButtonElement.class).
	                caption("Click Me").first();
	        clickMeButton.click();

	        // There should now be one label
	        assertEquals(1, $(LabelElement.class).all().size());
	        // ... with the specified text
	        assertEquals("Thanks User, it works!",
	                $(LabelElement.class).first().getText());

	        // Click the button again
	        clickMeButton.click();

	        // There should now be two labels
	        List<LabelElement> allLabels = $(LabelElement.class).all();
	        assertEquals(2, allLabels.size());
	        // ... and the last label should have the correct text
	        LabelElement lastLabel = allLabels.get(1);
	        assertEquals("Thanks User, it works!", lastLabel.getText());
	    } 
	   
       
       
   }


