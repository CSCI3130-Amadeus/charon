package org.amadeus.charon.ui;

import java.util.List;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.CourseManager;
import org.amadeus.charon.data.UserManager;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class CourseList extends VerticalLayout{

    public static final String ADD_COURSE_ID = "ADD_COURSE";
    
	public CourseList(){
		init();
	}
	
	private void init(){
		Label title = new Label("Course List");
		addComponent(new LogoutBar());
		addComponent(title);
		List<Course> courselist = CourseManager.getInstance().getCourseList();
		for(Course course : courselist){
			addComponent(new CourseListEntry(course));
		}
		
		if (UserManager.getInstance().getAuthedUser().isAdmin()){

	        Button button = new Button("Add Course: ");
	        button.setId(ADD_COURSE_ID);
	        addComponent(button);
	        
	        button.addClickListener(new ClickListener(){

	            @Override
	            public void buttonClick(ClickEvent event) {
	                Navigator.setContent(new ProfessorAddCourse()); 
	            }
	            
	        });   
		}
	}
}
