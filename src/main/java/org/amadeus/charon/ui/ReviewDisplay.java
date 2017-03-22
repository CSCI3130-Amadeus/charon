package org.amadeus.charon.ui;

import org.amadeus.charon.data.Review;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ReviewDisplay extends CustomComponent{
	private Label description;
	private Label userName;
	private Review review;
	
	public ReviewDisplay(Review review){
		this.review = review;
		init();
	}
	
	private void init(){
		VerticalLayout layout = new VerticalLayout();
		description = new Label(review.getComment());
		userName = new Label(review.getOwner().getUsername());
		layout.addComponent(description);
		layout.addComponent(userName);
		
		setCompositionRoot(layout);
		setSizeFull();

	}
}
