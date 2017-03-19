package org.amadeus.charon;


import javax.servlet.annotation.WebServlet;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.CourseManager;
import org.amadeus.charon.data.ReviewManager;
import org.amadeus.charon.data.UserManager;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        CourseManager.getInstance().createCourse("CSCI3130", "Software Engineering", "Lorem ipsum");
        Course course = CourseManager.getInstance().getCourseByCode("CSCI3130");
        UserManager.getInstance().registerUser("public_user", "public@public.com", "123456789");
        UserManager.getInstance().login("public_user", "123456789");
        
       /* ReviewManager.getInstance().createReview("foo", UserManager.getInstance().getAuthedUser(), course);
        ReviewManager.getInstance().createReview("bar", UserManager.getInstance().getAuthedUser(), course);
        ReviewManager.getInstance().createReview("foo", UserManager.getInstance().getAuthedUser(), course);
        ReviewManager.getInstance().createReview("bar", UserManager.getInstance().getAuthedUser(), course);
        ReviewManager.getInstance().createReview("foo", UserManager.getInstance().getAuthedUser(), course);*/
    	
        CourseOverview courseOverview = new CourseOverview(course);
        setContent(courseOverview);
    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    	
    }
}
