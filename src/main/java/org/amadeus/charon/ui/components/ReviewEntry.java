package org.amadeus.charon.ui.components;

import org.amadeus.charon.data.Review;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ReviewEntry extends CustomComponent{
	private Label description;
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
		layout.addComponent(userName);
		layout.addComponent(description);

		setCompositionRoot(layout);
		setSizeFull();

	}
}
