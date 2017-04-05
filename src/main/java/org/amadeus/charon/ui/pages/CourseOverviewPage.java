package org.amadeus.charon.ui.pages;

import com.vaadin.ui.*;
import com.vaadin.ui.Button.*;
import java.util.*;
import org.amadeus.charon.data.*;
import org.amadeus.charon.ui.*;
import org.amadeus.charon.ui.components.*;

public class CourseOverviewPage extends VerticalLayout {
	
    public static final String COURSE_CODE_ID = "COURSE_CODE";
    public static final String COURSE_NAME_ID = "COURSE_NAME";
    public static final String COURSE_DESC_ID = "COURSE_DESC";
    public static final String EDIT_COURSE_ID = "EDIT_COURSE";
    
	private ReviewForm reviewForm;
	private ReviewList reviewList;

	private AltTextbookForm altTextbookForm;
	private AltTextbookList altTextbookList;

	private Course course;
	private ArrayList<Component> listOfReviews;
	public CourseOverviewPage(Course course){
		this.course = course;
		init();
	}

	private void init(){

        buildCourseInfo();
        buildSyllabusButton();
        buildEditButton();
        buildTabSheet();

		setMargin(true);
		setSpacing(true);
	}

	private void buildCourseInfo() {
		HorizontalLayout titlebar = new HorizontalLayout();
		titlebar.setWidth("100%");
		addComponent(titlebar);

		Label courseName = new Label(course.getCourseName());
		titlebar.addComponent(courseName);
		Label courseCode = new Label(course.getCourseCode());
		Label courseDesc = new Label(course.getCourseDesc());

		addComponents(Navigator.getIndexButton());

		courseCode.setId(COURSE_CODE_ID);
		courseName.setId(COURSE_NAME_ID);
		courseDesc.setId(COURSE_DESC_ID);

		addComponents(courseCode);
		addComponents(courseName);
		addComponents(courseDesc);
	}

	private void buildSyllabusButton(){
		if (course.getSyllabusPath() != null) {
			Button syllabusButton = new Button("View Syllabus");
			syllabusButton.addClickListener(new Button.ClickListener() {
				@Override
				public void buttonClick(Button.ClickEvent clickEvent) {
					Navigator.addWindow(new SyllabusPage(course.getSyllabusPath()));
				}
			});
			addComponent(syllabusButton);
		}
	}

	private void buildTabSheet(){
		TabSheet tabSheet = new TabSheet();

		buildReviewForm(tabSheet);
		buildAltTextbookForm(tabSheet);

		addComponent(tabSheet);
	}

	private void buildReviewForm(TabSheet tabSheet){

		// Make a layout to hold the components
		VerticalLayout reviewComponents = new VerticalLayout();

        // Build the review components
		reviewForm = new ReviewForm(course);
		reviewList = new ReviewList(course);
		reviewForm.registerObserver(reviewList);

		// Add them to the layout.
		reviewComponents.addComponent(reviewForm);

		tabSheet.addTab(reviewComponents, "Reviews");
	}

	private void buildAltTextbookForm(TabSheet tabSheet){

		// Make a layout to hold the components
		VerticalLayout layout= new VerticalLayout();

        // Build the review components
        altTextbookForm = new AltTextbookForm(course);
		altTextbookList = new AltTextbookList(course);
		altTextbookForm.registerObserver(altTextbookList);

		// Add them to the layout.
		layout.addComponent(altTextbookForm);
		layout.addComponent(altTextbookList);

		tabSheet.addTab(layout, "Alt Textbook");
	}

	private void buildEditButton(){
		if (UserManager.getInstance().getAuthedUser().isAdmin()) {
			Button button = new Button("Edit Course: ");
			button.setId(EDIT_COURSE_ID);
			addComponent(button);

			button.addClickListener(new ClickListener() {
				@Override
				public void buttonClick(ClickEvent event) {
					Navigator.setContent(new CourseEditPage(course));
				}

			});
		}
	}

}
