package org.amadeus.charon.ui;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.CourseManager;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ProfessorEditCourse extends VerticalLayout{

	public static final String COURSE_NAME_ID = "COURSE_NAME";
    public static final String COURSE_CODE_ID = "COURSE_CODE";
    public static final String COURSE_DESC_ID = "COURSE_DESC";
    public static final String SUBMIT_ID = "SUBMIT";
    
    private TextField editCourseNameField;
    private TextField editCourseCodeField;
    private TextArea editCourseDescField;
    private Button submitButton;
    private Course course;

    public ProfessorEditCourse(Course course){
    	this.course = course;
    	init();
    }
    
    private void init(){
    	
    	
    	HorizontalLayout titlebar = new HorizontalLayout();
    	titlebar.setWidth("100%");
    	addComponent(titlebar);
    
 
    	FormLayout form = new FormLayout();

    	editCourseNameField = new TextField("Name: ");
    	editCourseNameField.setId(COURSE_NAME_ID);
    	editCourseNameField.setValue(course.getCourseName());	
    	form.addComponent(editCourseNameField);

    	editCourseCodeField = new TextField("Course Code: ");
    	editCourseCodeField.setId(COURSE_CODE_ID);
    	editCourseCodeField.setValue(course.getCourseCode());
    	form.addComponent(editCourseCodeField);
    	
    	editCourseDescField = new TextArea("CourseDescription: ");
    	editCourseDescField.setId(COURSE_DESC_ID);
    	editCourseDescField.setValue(course.getCourseDesc());
    	form.addComponent(editCourseDescField);
    	
    	 submitButton = new Button("Update");
         submitButton.setId(SUBMIT_ID);
         
         submitButton.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				CourseManager.getInstance().editCourse(course, editCourseCodeField.getValue(),
						editCourseNameField.getValue(), editCourseDescField.getValue());
				Navigator.index();
				
			}
        	 
         });

    	
    	addComponent(form);
    	addComponent(submitButton);
    	
    
    	setMargin(true);
    	setSpacing(true);
    	
    }
}
