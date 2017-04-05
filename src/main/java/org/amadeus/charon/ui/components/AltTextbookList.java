package org.amadeus.charon.ui.components;

import com.vaadin.ui.*;
import java.util.*;
import org.amadeus.charon.data.*;

/**
 * Created by aaron on 03/04/17.
 */
public class AltTextbookList extends CustomComponent implements Observer{

    private Course course;
    private VerticalLayout layout;

    public AltTextbookList(Course course) {
        this.course = course;
        init();
    }


    private void init(){
        layout = new VerticalLayout();

        for (AltTextbook altTextbook : course.getAltTextbooks()) {
            AltTextbookEntry altTextbookEntry = new AltTextbookEntry(altTextbook);
            layout.addComponent(altTextbookEntry);
        }

        setCompositionRoot(layout);
    }


    public void addReview(AltTextbook altTextbook){
        AltTextbookEntry altTextbookEntry = new AltTextbookEntry(altTextbook);
		layout.addComponent(altTextbookEntry);
    }


	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof AltTextbook){
			AltTextbook altTextbook = (AltTextbook)arg;
			addReview(altTextbook);
		}
	}
}
