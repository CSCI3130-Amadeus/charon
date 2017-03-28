package org.amadeus.charon.ui;

import org.amadeus.charon.data.UserManager;
import org.amadeus.charon.data.UserManager.LoginMessage;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class UserLogin extends VerticalLayout{
	
	
    private TextField usernameField;
    private PasswordField passwordField;
    private Button submitButton;
    
    private Label errorMessageArea;

    
    public static final String USERNAME_ID = "USERNAME";
    public static final String PASSWORD_ID = "PASSWORD";
    public static final String SUBMIT_ID = "SUBMIT";
    
    
    public UserLogin(){
    	init();
    }
    
    private void init(){
    	
    	HorizontalLayout titlebar = new HorizontalLayout();
    	titlebar.setWidth("100%");
    	addComponent(titlebar);
    	
    	errorMessageArea = new Label();
    
 
    	FormLayout form = new FormLayout();

    	usernameField = new TextField("Username: ");
    	usernameField.setId(USERNAME_ID);
    	form.addComponent(usernameField);

    	passwordField = new PasswordField("Password: ");
        passwordField.setId(PASSWORD_ID);
    	form.addComponent(passwordField);
    	
    	submitButton = new Button("Submit");
        submitButton.setId(SUBMIT_ID);
         
        submitButton.addClickListener(new ClickListener(){
            
            @Override
            public void buttonClick(ClickEvent event) {
                
                LoginMessage result = UserManager.getInstance().login(usernameField.getValue(), passwordField.getValue());
                
                switch (result) {
                    case SUCCESS :
                        Navigator.index();
                        break;
                        
                    case EMPTY :
                        errorMessageArea.setValue("Error: Cannot submit empty fields!");
                        break;
                        
                    default :
                        errorMessageArea.setValue("Error: Incorrect username or password.");
                        break;
                }
                
            }
            
         });

    	
    	addComponent(form);
    	addComponent(submitButton);
        addComponent(errorMessageArea);
    	
    	setMargin(true);
    	setSpacing(true);	
    }
}
