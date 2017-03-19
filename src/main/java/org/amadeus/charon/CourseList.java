package org.amadeus.charon;

import java.util.List;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.CourseManager;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class CourseList extends VerticalLayout{

	public CourseList(){
		init();
	}
	
	private void init(){
		Label title = new Label("Course List"); 
		title.setId("COURSELIST");
		addComponent(title);
		List<Course> courselist = CourseManager.getInstance().getCourseList();
		for(Course course : courselist){
			addComponent(new CourseListEntry(course));
		}
	}
}
