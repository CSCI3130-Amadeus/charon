package org.amadeus.charon.ui;

import com.vaadin.ui.*;


import static org.amadeus.charon.ui.ProfessorAddCourse.*;

/**
 * Created by aaron on 02/04/17.
 */
public class SyllabusUploadComponent extends CustomComponent{

    private SyllabusUploader syllabusUploader;
	private Label messageArea;

    public SyllabusUploadComponent(SyllabusUploader syllabusUploader) {
        this.syllabusUploader = syllabusUploader;
        init();
    }

    private void init(){
        VerticalLayout verticalLayout = new VerticalLayout();

        Upload upload = new Upload("Upload Syllabus", syllabusUploader);
        upload.setId(UPLOAD_FIELD_ID);
        upload.addSucceededListener(syllabusUploader);

        messageArea = new Label("");
        messageArea.setId(MESSAGE_AREA);

        upload.addFailedListener(new Upload.FailedListener(){
            @Override
            public void uploadFailed(Upload.FailedEvent event) {
                messageArea.setValue(ERROR_MESSAGE);
            }
        });

        upload.addSucceededListener(new Upload.SucceededListener(){
            @Override
            public void uploadSucceeded(Upload.SucceededEvent event) {
                messageArea.setValue(SUCCESS_MESSAGE);
            }

        });

        verticalLayout.addComponent(upload);
        verticalLayout.addComponent(messageArea);

        setCompositionRoot(verticalLayout);
    }
}
