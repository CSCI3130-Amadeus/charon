package org.amadeus.charon;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.Review;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class CourseOverview extends VerticalLayout implements Observer{
	
	private ReviewForm reviewForm;
	
	private Course course;
	private ArrayList<Component> listOfReviews;
	public CourseOverview(Course course){
		this.course = course;
		init();
	}
	
	private void init(){
    	 reviewForm = new ReviewForm(course);
    	 reviewForm.registerObserver(this);
    	 listOfReviews = getReviewComponents();
         
         HorizontalLayout titlebar = new HorizontalLayout();
         titlebar.setWidth("100%");
         addComponent(titlebar);
         
         Label courseName = new Label(course.getCourseName());
         courseName.setId("cop");
         titlebar.addComponent(courseName);
         Label courseCode = new Label(course.getCourseCode());
         Label courseDesc = new Label(course.getCourseDesc());
         addComponents(Navigator.getIndexButton());
         addComponents(courseCode);
         addComponents(courseName);
         addComponents(courseDesc);
         addComponents(reviewForm);
         
         
         for(Component component : listOfReviews){
        	 addComponent(component);
         }
         
         setMargin(true);
         setSpacing(true);
	}
	
	

	private ArrayList<Component> getReviewComponents(){
		ArrayList<Component> components = new ArrayList<Component>();
		for(Review review : course.getReviews()){
			components.add(new ReviewDisplay(review));
		}
		return components;
	}
	
	private void addReview(Review review){
		ReviewDisplay reviewDisplay = new ReviewDisplay(review);
		listOfReviews.add(reviewDisplay);
		addComponent(reviewDisplay);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof Review){
			Review review = (Review)arg;
			addReview(review);
		}
	}
}
