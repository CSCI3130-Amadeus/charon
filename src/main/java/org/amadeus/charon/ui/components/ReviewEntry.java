package org.amadeus.charon.ui.components;

import org.amadeus.charon.data.Review;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ReviewEntry extends CustomComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label description;
	private Label rating;
	private Label userName;
	private Review review;
	
	public ReviewEntry(Review review){
		this.review = review;
		init();
	}
	
	private void init(){
		VerticalLayout layout = new VerticalLayout();
		userName = new Label(review.getOwner().getUsername());
		description = new Label(review.getComment());
		rating = new Label("Rating: " + review.getRating());

		layout.addComponent(userName);
		layout.addComponent(rating);
		layout.addComponent(description);

		setCompositionRoot(layout);
		setSizeFull();

	}
}
