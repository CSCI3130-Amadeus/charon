package org.amadeus.charon.ui;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.amadeus.charon.data.*;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class CourseOverview extends VerticalLayout implements Observer{
	
    public static final String COURSE_CODE_ID = "COURSE_CODE";
    public static final String COURSE_NAME_ID = "COURSE_NAME";
    public static final String COURSE_DESC_ID = "COURSE_DESC";
    public static final String EDIT_COURSE_ID = "EDIT_COURSE";
    
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

         courseCode.setId(COURSE_CODE_ID);
         courseName.setId(COURSE_NAME_ID);
         courseDesc.setId(COURSE_DESC_ID);
         
         addComponents(courseCode);
         addComponents(courseName);
         addComponents(courseDesc);

		if (course.getSyllabusPath() != null) {
			Button syllabusButton = new Button("View Syllabus");
			syllabusButton.addClickListener(new Button.ClickListener() {
				@Override
				public void buttonClick(Button.ClickEvent clickEvent) {
					Navigator.addWindow(new SyllabusPage(course.getSyllabusPath()));
				}
			});
            addComponent(syllabusButton);
		}

        addComponents(reviewForm);

        if (UserManager.getInstance().getAuthedUser().isAdmin()) {
			Button button = new Button("Edit Course: ");
			button.setId(EDIT_COURSE_ID);
			addComponent(button);

			button.addClickListener(new ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					Navigator.setContent(new ProfessorEditCourse(course));
				}

			});
		}
         
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