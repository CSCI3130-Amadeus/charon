package org.amadeus.charon.ui;

import com.vaadin.ui.*;
import com.vaadin.ui.Button.*;
import org.amadeus.charon.data.*;

public class ProfessorAddCourse extends VerticalLayout{
	
	public static final String COURSE_NAME_ID = "COURSE_NAME";
    public static final String COURSE_CODE_ID = "COURSE_CODE";
    public static final String COURSE_DESC_ID = "COURSE_DESC";
    public static final String SUBMIT_ID = "SUBMIT";
	public static final String UPLOAD_FIELD_ID = "UPLOAD_FIELD";
	public static final String MESSAGE_AREA = "MESSAGE_AREA";
	public static final String ERROR_MESSAGE = "Error: Invalid file type uploaded";
	public static final String SUCCESS_MESSAGE = "File uploaded successfully!";
	
	
    private TextField addCourseNameField;
    private TextField addCourseCodeField;
    private TextArea addCourseDescField;
    private Button submitButton;
    private SyllabusUploader syllabusUploader;
	private Label messageArea;

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
		SyllabusUploadComponent syllabusUploadComponent = new SyllabusUploadComponent(syllabusUploader);
		form.addComponent(syllabusUploadComponent);

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
