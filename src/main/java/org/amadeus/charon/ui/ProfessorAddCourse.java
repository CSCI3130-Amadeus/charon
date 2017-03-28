package org.amadeus.charon.ui;

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
	
	public static final String COURSE_NAME_ID = "COURSE_NAME";
    public static final String COURSE_CODE_ID = "COURSE_CODE";
    public static final String COURSE_DESC_ID = "COURSE_DESC";
    public static final String SUBMIT_ID = "SUBMIT";
    
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
    	addCourseNameField.setId(COURSE_NAME_ID);
    	form.addComponent(addCourseNameField);

    	addCourseCodeField = new TextField("Course Code: ");
    	addCourseCodeField.setId(COURSE_CODE_ID);
    	form.addComponent(addCourseCodeField);
    	
    	addCourseDescField = new TextArea("CourseDescription: ");
    	addCourseDescField.setId(COURSE_DESC_ID);
    	form.addComponent(addCourseDescField);
    	
    	 submitButton = new Button("Submit");
         submitButton.setId(SUBMIT_ID);
         
         submitButton.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				CourseManager.getInstance().createCourse(addCourseCodeField.getValue(),
						addCourseNameField.getValue(), addCourseDescField.getValue());
				Navigator.index();
				
			}
        	 
         });

    	
    	addComponent(form);
    	addComponent(submitButton);
    	
    
    	setMargin(true);
    	setSpacing(true);
    	
    }//close init()
    
    


    
}
