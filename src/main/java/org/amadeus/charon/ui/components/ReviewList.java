package org.amadeus.charon.ui.components;

import com.vaadin.ui.*;
import java.util.*;
import org.amadeus.charon.data.*;

/**
 * Created by aaron on 03/04/17.
 */
public class ReviewList extends CustomComponent implements Observer{

    private Course course;
    private VerticalLayout layout;

    public ReviewList(Course course) {
        this.course = course;
        init();
    }


    private void init(){
        layout = new VerticalLayout();

        for (Review review : course.getReviews()) {
            ReviewEntry reviewEntry = new ReviewEntry(review);
            layout.addComponent(reviewEntry);
        }

        setCompositionRoot(layout);
    }


    public void addReview(Review review){
        ReviewEntry reviewEntry = new ReviewEntry(review);
		layout.addComponent(reviewEntry);
    }


	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Review){
			Review review = (Review)arg;
			addReview(review);
		}
	}
}
