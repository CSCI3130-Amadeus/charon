package org.amadeus.charon;

import org.amadeus.charon.data.CourseManager;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ProfessorAddCourse extends VerticalLayout{
	
	
    private TextField addCourseNameField;
    private TextField addCourseCodeField;
    private TextArea addCourseDescField;
    private Button submitButton;

    public ProfessorAddCourse(){
    	init();
    }
    
    private void init(){
    	//professorAddCourse = new ProfessorAddCourse(course);
    	//professorAddCourse.registerObserver(this);
    	
    	HorizontalLayout titlebar = new HorizontalLayout();
    	titlebar.setWidth("100%");
    	addComponent(titlebar);
    
 
    	FormLayout form = new FormLayout();

    	addCourseNameField = new TextField("Name: ");
    	form.addComponent(addCourseNameField);

    	addCourseCodeField = new TextField("Course Code: ");
    	form.addComponent(addCourseCodeField);
    	
    	addCourseDescField = new TextArea("CourseDescription: ");
    	form.addComponent(addCourseDescField);
    	
    	 submitButton = new Button("Submit");
         submitButton.setId("SUBMIT_BUTTON");
         
         submitButton.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				CourseManager.getInstance().createCourse(addCourseNameField.getValue(),
						addCourseCodeField.getValue(), addCourseDescField.getValue());
				Navigator.index();
				
			}
        	 
         });

    	
    	addComponent(form);
    	addComponent(submitButton);
    	
    
    	setMargin(true);
    	setSpacing(true);
    	
    }//close init()
    
    


    
}
