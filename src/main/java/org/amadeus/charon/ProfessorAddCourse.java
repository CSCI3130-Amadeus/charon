package org.amadeus.charon;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.CourseManager;
import org.amadeus.charon.data.User;
import org.amadeus.charon.data.UserManager;

import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ProfessorAddCourse extends VerticalLayout{
	
	
    private TextField addCourseNameField;
    private TextField addCourseCodeField;
    private TextArea addCourseDescField;
    private Button submitButton;
    private Course course;
    private ProfessorAddCourse professorAddCourse;
    private VerticalLayout layout;
    
    public ProfessorAddCourse(Course course){
    	this.course = course;
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

    	
    	addComponent(form);
    	addComponent(submitButton);
    	
    
    	setMargin(true);
    	setSpacing(true);
    	
    }//close init()
    
    @SuppressWarnings({ "serial", "unused" })
    private ClickListener getSubmitButtonListener() {
        return new ClickListener(){

            public void buttonClick(ClickEvent event) {
                User user = UserManager.getInstance().getAuthedUser();
                long id = CourseManager.getInstance().createCourse(addCourseNameField.getValue(),
                		addCourseCodeField.getValue(),
                		addCourseDescField.getValue());
                if (id != -1) {
                    Label result = new Label("Success!");
                    result.setId("RESULT");
                    layout.addComponent(result);
                }
                else {
                    Label result = new Label("Failed!");
                    result.setId("RESULT");
                    layout.addComponent(result);
                }
            }

			@Override
			public void click(com.vaadin.event.MouseEvents.ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
        };
        
        
    }

    
}
