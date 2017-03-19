package org.amadeus.charon;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
/**
 * A class used for navigation in the project.
 * FIXME: THis is really clugy and bad.
 * @author aaron
 *
 */
public class Navigator {

    private static MyUI ui;
    
    public static void registerNavigator(MyUI ui) {
        Navigator.ui = ui;
    }
    

    public static void setContent(Component content) {
        ui.setContent(content);
    }
    
    public static void index(){
        ui.setContent(new CourseList());
    }
    
    public static Button getIndexButton() {
        Button button = new Button("Home");
        button.addClickListener(new ClickListener(){

            @Override
            public void buttonClick(ClickEvent event) {
                Navigator.index();
            }
            
        });
        
        return button;
    }
}
