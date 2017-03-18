package org.amadeus.charon.data;
import static org.junit.Assert.*;


import org.junit.Test;

public class CourseTest {

	@Test 
	public void testCourseAdd() {
		CourseManager course = new CourseManager();
		boolean result= course.addCourseCode(1, "C1", "zhang", "123123");
		course.addCourseCode(2, "", "", "");
		assertEquals(true,course.addCourseCode(1, "C1", "zhang", "123123"));
		assertEquals(true,course.addCourseCode(2,"","",""));
	}
	@Test 
	public void testCourseDel() {
		CourseManager course = new CourseManager();
		course.addCourseCode(1, "", "", "");
		boolean result= course.delCourse(1);
		assertEquals(true,result);
		
	}
	
	@Test 
	public void testCourseDelnotsuccess() {
		CourseManager course = new CourseManager();
		course.addCourseCode(1, "", "", "");
		boolean result= course.delCourse(2);
		assertNotEquals(true,result);
	}
	@Test 
	public void testCourseedit() {
		CourseManager course = new CourseManager();
		course.addCourseCode(1, "", "", "");
		course.editCourse(1,"","","");
		assertEquals(true,course.editCourse(1,"1","",""));
		
	}
		
}