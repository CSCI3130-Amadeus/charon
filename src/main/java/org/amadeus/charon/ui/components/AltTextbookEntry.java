package org.amadeus.charon.ui.components;

import com.vaadin.server.*;
import com.vaadin.ui.*;
import org.amadeus.charon.data.*;

/**
 * Created by aaron on 03/04/17.
 */
public class AltTextbookEntry extends CustomComponent{

    private AltTextbook altTextbook;

    private Label titleLabel;
    private Label userLabel;
    private Link link;


    public AltTextbookEntry(AltTextbook altTextbook) {
        this.altTextbook = altTextbook;
        init();
    }

    private void init(){

        VerticalLayout layout = new VerticalLayout();
        userLabel = new Label(altTextbook.getOwner().getUsername());
        titleLabel = new Label(altTextbook.getTitle());
        layout.addComponent(userLabel);
        layout.addComponent(titleLabel);
        if (altTextbook.getUrl() != null && !altTextbook.getUrl().equals("")){
            link = new Link("View textbook", new ExternalResource(altTextbook.getUrl()));
            layout.addComponent(link);
        }

        setCompositionRoot(layout);
    }
}
