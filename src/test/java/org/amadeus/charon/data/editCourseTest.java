package org.amadeus.charon.data;

import org.junit.*;


import static org.junit.Assert.*;

public class editCourseTest {

	 private static final String username = "john";
	 private static final String courseCode = "TEST3130";

	 @Before
	 public void setupTest(){
	     UserManager.getInstance().registerUser(username, "fake@fake.com", "passssword");
	     CourseManager.getInstance().createCourse(courseCode, "Software Engineering", "Lorem Ipsum", null);
	 }
	@Test
	public void editSuccess() {
		Course course = CourseManager.getInstance().getCourseByCode(courseCode);
		CourseManager.getInstance().editCourse(course, "111", "222", "333");
		Course newCourse = CourseManager.getInstance().getCourseByCode("111");
		assertTrue(course.getCourseName().equals("222"));
	}

}
