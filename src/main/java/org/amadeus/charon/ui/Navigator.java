package org.amadeus.charon.ui;

import com.vaadin.ui.*;
import com.vaadin.ui.Button.*;
import org.amadeus.charon.ui.pages.*;

/**
 * A class used for navigation in the project.
 * FIXME: THis is really clugy and bad.
 * @author aaron
 *
 */
public class Navigator {
    
    public static final String HOME_ID = "HOME";

    private static MyUI ui;
    
    public static void registerNavigator(MyUI ui) {
        Navigator.ui = ui;
    }
    

    public static void setContent(Component content) {
        ui.setContent(content);
    }

    public static void addWindow(Window window) {
        ui.addWindow(window);
    }
    
    public static void index(){
        ui.setContent(new CourseListPage());
    }
    
    public static Button getIndexButton() {
        Button button = new Button("Home");
        button.setId(HOME_ID);
        button.addClickListener(new ClickListener(){

            @Override
            public void buttonClick(ClickEvent event) {
                Navigator.index();
            }
            
        });
        
        return button;
    }
}
