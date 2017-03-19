package org.amadeus.charon;

import org.amadeus.charon.data.Course;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class CourseListEntry extends CustomComponent{
	
	private Course course;

	public CourseListEntry(Course course) {
		super();
		this.course = course;
		init();
	}
	
	private void init(){
		Label courseLabel = new Label(course.getCourseCode());
		Button submit = new Button("View");
		HorizontalLayout layout = new HorizontalLayout();
		layout.addComponent(courseLabel);
		layout.addComponent(submit);
		this.setCompositionRoot(layout);
	}
	
}
