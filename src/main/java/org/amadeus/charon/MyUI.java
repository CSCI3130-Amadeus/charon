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
         
         Label title = new Label("Course");
         titlebar.addComponent(title);
         
         setContent(CourseOv);      
    	 
    	 
    	 
        /* GridLayout gridCourseOverview = new GridLayout(8, 8);
        
        
        final TextField name = new TextField();
        
        //Dummy data
        int[] courseIds = new int[]{1, 2, 3, 4};
        String[] courseCodes = new String[]{"CSCI 0000", "CSCI 0001", "CSCI 0002", "CSCI 0003"};
        String[] courseNames = new String[]{"Name_1", "Name_2", "Name_3", "Name_4"};
        String[] courseDescs = new String[]{"This is Name_1's desc.", "This is Name_2's desc.", "This is Name_3's desc.", "This is Name_4's desc."};
        
        //Header Label for Welcoming Users
        Label welcome = new Label("Charon- Course Page");
        gridCourseOverview.addComponent(welcome, 0, 0);
        
        
        //Panel for visualizing courses
        for (int i = 0; i < 4; i++){
        	Panel course = new Panel(courseCodes[i]);
        	course.setWidth("50%");
        	FormLayout courseContent = new FormLayout();
        	courseContent.addComponent(new Label(courseNames[i]));
        	courseContent.addComponent(new Label(courseDescs[i]));
        	courseContent.setSizeUndefined();
        	courseContent.setMargin(true);
        	course.setContent(courseContent);
        	gridCourseOverview.addComponent(course, i, 1);
        	
        ////Course verti 
        	
        }
        
        gridCourseOverview.setMargin(true);
        gridCourseOverview.setSpacing(true);
        setContent(gridCourseOverview);
    }*/
        
        
    }   
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
