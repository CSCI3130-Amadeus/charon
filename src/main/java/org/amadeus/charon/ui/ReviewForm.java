package org.amadeus.charon.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observer;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.Review;
import org.amadeus.charon.data.ReviewManager;
import org.amadeus.charon.data.User;
import org.amadeus.charon.data.UserManager;

import com.gargoylesoftware.htmlunit.javascript.host.Notification;
import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.ListSelect; 

public class ReviewForm extends CustomComponent {

    private VerticalLayout layout;
    private TextArea commentEntry;
    private Label commentEntryLabel;
    private Button submitButton;
    private Course course;
    private ArrayList<Observer> observers;
    
    public static final String REVIEW_FIELD_ID = "REVIEW_FIELD";
    public static final String REVIEW_SUBMIT_ID = "REVIEW_SUBMIT";
    public static final String REVIEW_RATING_ID = "REVIEW_RATING";
    public ListSelect selectRating = new ListSelect("Pick a Rating...");
    
    private static final long serialVersionUID = 1654898717111927200L;
    private static final int score1 = 1;
    private static final int score2 = 2;
    private static final int score3 = 3;
    private static final int score4 = 4;
    private static final int score5 = 5;

    public ReviewForm(Course course) {
        
        this.course = course;
        observers = new ArrayList<Observer>();
        
        commentEntry = new TextArea("Write a review...");
        commentEntry.setId(REVIEW_FIELD_ID);
        commentEntryLabel = new Label("Review course " + course.getCourseCode());
        submitButton = new Button("Submit");
        submitButton.setId(REVIEW_SUBMIT_ID);
        
        //Adding rating UI component here
        selectRating.setId(REVIEW_RATING_ID);
		selectRating.addItems(score1, score2, score3, score4, score5);
		selectRating.setNullSelectionAllowed(false);
		selectRating.setRows(5);
		

        submitButton.addClickListener(getSubmitButtonListener());
        
        layout = new VerticalLayout();
        
        layout.addComponent(commentEntryLabel);
        layout.addComponent(commentEntry);
        layout.addComponent(selectRating);
        layout.addComponent(submitButton);
        
        
        setCompositionRoot(layout);
        setSizeFull();
        
    }
    
    @SuppressWarnings("serial")
    private ClickListener getSubmitButtonListener() {
        return new ClickListener(){

            @Override
            public void buttonClick(ClickEvent event) {
                User user = UserManager.getInstance().getAuthedUser();
                String rating = selectRating.getValue().toString();
                ReviewManager.getInstance().createReview(commentEntry.getValue(), user, course, rating);
                // TODO: Add live update here.
                notifyObservers(new Review(commentEntry.getValue(), user, course, rating));
            }
        };
    }
    
    private void notifyObservers(Review review){
    	for (Observer observer : observers){
    		observer.update(null, review);
    	}
    }
    
    public void registerObserver(Observer observer){
    	observers.add(observer);
    }
}
