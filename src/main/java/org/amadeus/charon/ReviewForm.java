package org.amadeus.charon;

import java.util.ArrayList;
import java.util.Observer;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.Review;
import org.amadeus.charon.data.ReviewManager;
import org.amadeus.charon.data.User;
import org.amadeus.charon.data.UserManager;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class ReviewForm extends CustomComponent {

    private VerticalLayout layout;
    private TextArea commentEntry;
    private Label commentEntryLabel;
    private Button submitButton;
    private Course course;
    private ArrayList<Observer> observers;
    
    private static final long serialVersionUID = 1654898717111927200L;

    public ReviewForm(Course course) {
        
        this.course = course;
        observers = new ArrayList<Observer>();
        
        commentEntry = new TextArea("Write a review...");
        commentEntry.setId("COMMENT_ENTRY");
        commentEntryLabel = new Label("Review course " + course.getCourseCode());
        submitButton = new Button("Submit");
        submitButton.setId("SUBMIT_BUTTON");

        submitButton.addClickListener(getSubmitButtonListener());
        
        layout = new VerticalLayout();
        
        layout.addComponent(commentEntryLabel);
        layout.addComponent(commentEntry);
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
                ReviewManager.getInstance().createReview(commentEntry.getValue(), user, course);
                // TODO: Add live update here.
                notifyObservers(new Review(commentEntry.getValue(), user, course));
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
