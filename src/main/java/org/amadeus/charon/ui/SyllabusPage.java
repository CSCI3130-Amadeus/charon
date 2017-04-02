package org.amadeus.charon.ui;

import com.vaadin.server.*;
import com.vaadin.ui.*;
import java.io.*;

/**
 * Created by aaron on 02/04/17.
 */
public class SyllabusPage extends Window {

    private String path;


    public SyllabusPage(String path) {
        super();
        this.path = path;
        init();
    }

    public void init() {


        StreamResource.StreamSource streamSource = new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                try {
                    File file = new File(path);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    return fileInputStream;
                }
                catch (IOException e) {
                    return null;
                }
            }
        };

        setWidth("800");
        setHeight("600");
        setResizable(true);

        VerticalLayout layout = new VerticalLayout();
        Embedded embedded = new Embedded();
        embedded.setSizeFull();
        embedded.setType(Embedded.TYPE_BROWSER);
        embedded.setHeight("600");
        StreamResource resource = new StreamResource(streamSource, System.currentTimeMillis()+".pdf");
        // Set the right mime type
        resource.setMIMEType("application/pdf");

        embedded.setSource(resource);
        layout.addComponent(embedded);
        setContent(layout);
    }
}
