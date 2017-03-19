package org.amadeus.charon;

import org.amadeus.charon.data.Course;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
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
		
		submit.addClickListener(new ClickListener(){
            @Override
            public void buttonClick(ClickEvent event) {
                // TODO Auto-generated method stub
                Navigator.setContent(new CourseOverview(course));
            }
		    
		});
		
		HorizontalLayout layout = new HorizontalLayout();
		layout.addComponent(courseLabel);
		layout.addComponent(submit);
		this.setCompositionRoot(layout);
	}
	
}
