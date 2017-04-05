package org.amadeus.charon.ui.components;

import com.vaadin.ui.*;
import com.vaadin.ui.Button.*;
import java.util.*;
import org.amadeus.charon.data.*;

public class AltTextbookForm extends CustomComponent {

    private FormLayout layout;
    private TextField titleField;
    private Label titleFieldLabel;
    private TextField urlField;
    private Label urlFieldLabel;
    private Button submitButton;
    private Course course;
    private ArrayList<Observer> observers;

    public static final String TITLE_FIELD = "ALT_TEXT_TITLE_FIELD";
    public static final String URL_FIELD = "ALT_TEXT_TITLE_FIELD";
    public static final String SUBMIT_BUTTON = "ALT_TEXT_SUBMIT";


    public AltTextbookForm(Course course) {
        
        this.course = course;
        observers = new ArrayList<Observer>();
        init();
    }

    private void init(){
        layout = new FormLayout();

        titleFieldLabel = new Label("Title:");
        titleField = new TextField();
        titleField.setId(TITLE_FIELD);

        urlFieldLabel = new Label("URL (Optional) :");
        urlField = new TextField();
        urlField.setId(URL_FIELD);

        submitButton = new Button("Add Alt Textbook");
        submitButton.addClickListener(getSubmitButtonListener());

        layoutComponents();
    }

    private void layoutComponents(){

        layout.addComponent(titleFieldLabel);
        layout.addComponent(titleField);
        layout.addComponent(urlFieldLabel);
        layout.addComponent(urlField);
        layout.addComponent(submitButton);

        setCompositionRoot(layout);
    }

    @SuppressWarnings("serial")
    private ClickListener getSubmitButtonListener() {
        return new ClickListener(){

            @Override
            public void buttonClick(ClickEvent event) {
                User user = UserManager.getInstance().getAuthedUser();
                AltTextbookManager.getInstance().createAltTextbook(
                        titleField.getValue(), urlField.getValue(), user, course);

                notifyObservers(new AltTextbook(user, course, titleField.getValue(), urlField.getValue()));
            }
        };
    }
    
    private void notifyObservers(AltTextbook altTextbook){
    	for (Observer observer : observers){
    		observer.update(null, altTextbook);
    	}
    }
    
    public void registerObserver(Observer observer){
    	observers.add(observer);
    }
}
