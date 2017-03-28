package org.amadeus.charon.ui;

import org.amadeus.charon.data.UserManager;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class LogoutBar extends CustomComponent {

    public static final String LOGOUT_ID = "LOGOUT";
    
    public LogoutBar() {
        init();
    }
    
    private void init() {
        
        HorizontalLayout layout = new HorizontalLayout();
        layout.setDefaultComponentAlignment(Alignment.TOP_RIGHT);
        
        Button logoutButton = new Button("Log out");
        logoutButton.setId(LOGOUT_ID);
        
        layout.addComponent(logoutButton);
        
        logoutButton.addClickListener(new ClickListener(){

            @Override
            public void buttonClick(ClickEvent event) {
                UserManager.getInstance().logout();
                Navigator.setContent(new UserLogin());
            }
            
        });
        
        setCompositionRoot(layout);
    }
}
