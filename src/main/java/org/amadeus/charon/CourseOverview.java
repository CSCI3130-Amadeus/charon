package org.amadeus.charon;

import org.amadeus.charon.data.Course;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class CourseOverview extends VerticalLayout{
	
	private Course course;
	public CourseOverview(Course course){
		this.course = course;
		init();
	}
	
	private void init(){
    	 setId("cop");
    	 
         
         HorizontalLayout titlebar = new HorizontalLayout();
         titlebar.setWidth("100%");
         addComponent(titlebar);
         
         Label courseName = new Label(course.getCourseName());
         titlebar.addComponent(courseName);
         Label courseCode = new Label(course.getCourseCode());
         Label courseDesc = new Label(course.getCourseDesc());
         addComponents(courseCode);
         addComponents(courseName);
         addComponents(courseDesc);
         
         setMargin(true);
         setSpacing(true);
	}

}
