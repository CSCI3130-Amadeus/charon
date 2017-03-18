package org.amadeus.charon;


import javax.servlet.annotation.WebServlet;

import org.amadeus.charon.data.User;
import org.amadeus.charon.data.UserManager;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.v7.ui.Table;

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
    	 VerticalLayout CourseOv = new VerticalLayout();
    	 
         
         HorizontalLayout titlebar = new HorizontalLayout();
         titlebar.setWidth("100%");
         CourseOv.addComponent(titlebar);
         
         Label courseName = new Label("Course Title Here");
         titlebar.addComponent(courseName);
         Label courseCode = new Label("CSCI 0000");
         Label courseDesc = new Label("This is the course's description");
         CourseOv.addComponents(courseCode);
         CourseOv.addComponents(courseName);
         CourseOv.addComponents(courseDesc);
         
         CourseOv.setMargin(true);
         CourseOv.setSpacing(true);
         setContent(CourseOv);      
        
        
    }   
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
