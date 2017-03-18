package org.amadeus.charon;

import org.amadeus.charon.data.Course;
import org.amadeus.charon.data.ReviewManager;
import org.amadeus.charon.data.User;
import org.amadeus.charon.data.UserManager;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class ReviewForm extends CustomComponent {

    private VerticalLayout layout;
    private TextArea commentEntry;
    private Label commentEntryLabel;
    private Button submitButton;
    private Course course;
    
    private static final long serialVersionUID = 1654898717111927200L;

    public ReviewForm(Course course) {
        
        this.course = course;
        
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
                long id = ReviewManager.getInstance().createReview(commentEntry.getValue(), user, course);
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
        };
    }
}
