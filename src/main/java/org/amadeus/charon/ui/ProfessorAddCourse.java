package org.amadeus.charon.ui;

import org.amadeus.charon.data.CourseManager;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;

public class ProfessorAddCourse extends VerticalLayout{
	
	public static final String COURSE_NAME_ID = "COURSE_NAME";
    public static final String COURSE_CODE_ID = "COURSE_CODE";
    public static final String COURSE_DESC_ID = "COURSE_DESC";
    public static final String SUBMIT_ID = "SUBMIT";
	public static final String UPLOAD_FIELD_ID = "UPLOAD_FIELD";
	public static final String MESSAGE_AREA = "MESSAGE_AREA";
	public static final String ERROR_MESSAGE = "Error: Invalid file type uploaded";
	public static final String SUCCESS_MESSAGE = "File uploaded successfully!";
	
	
    private Label messageArea;
    private TextField addCourseNameField;
    private TextField addCourseCodeField;
    private TextArea addCourseDescField;
    private Button submitButton;
    private SyllabusUploader syllabusUploader;

    public ProfessorAddCourse(){
    	init();
    }
    
    private void init(){
    	
    	HorizontalLayout titlebar = new HorizontalLayout();
    	titlebar.setWidth("100%");
    	addComponent(titlebar);
    
 
    	FormLayout form = new FormLayout();

    	addCourseNameField = new TextField("Name: ");
    	addCourseNameField.setId(COURSE_NAME_ID);
    	form.addComponent(addCourseNameField);

    	addCourseCodeField = new TextField("Course Code: ");
    	addCourseCodeField.setId(COURSE_CODE_ID);
    	form.addComponent(addCourseCodeField);
    	
    	addCourseDescField = new TextArea("CourseDescription: ");
    	addCourseDescField.setId(COURSE_DESC_ID);
    	form.addComponent(addCourseDescField);
    	
    	
    	syllabusUploader = new SyllabusUploader();
    	Upload upload = new Upload("Upload Syllabus", syllabusUploader);
    	upload.setId(UPLOAD_FIELD_ID);
    	upload.addSucceededListener(syllabusUploader);
    	
    	form.addComponent(upload);
    	
    	messageArea = new Label("");
    	messageArea.setId(MESSAGE_AREA);
    	upload.addFailedListener(new FailedListener(){
			@Override
			public void uploadFailed(FailedEvent event) {
				messageArea.setValue(ERROR_MESSAGE);
			}
    	});
    	
    	upload.addSucceededListener(new SucceededListener(){

			@Override
			public void uploadSucceeded(SucceededEvent event) {
				messageArea.setValue(SUCCESS_MESSAGE);
			}
    		
    	});
    	
    	form.addComponent(messageArea);
    	
    	 submitButton = new Button("Submit");
         submitButton.setId(SUBMIT_ID);
         
         submitButton.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				CourseManager.getInstance().createCourse(addCourseCodeField.getValue(),
						addCourseNameField.getValue(), addCourseDescField.getValue(),
						syllabusUploader.getUploadedPath());
				Navigator.index();
				
			}
        	 
         });

    	addComponent(form);
    	addComponent(submitButton);
    
    	setMargin(true);
    	setSpacing(true);
    	
    }   
}
