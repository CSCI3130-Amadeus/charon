package org.amadeus.charon.data;

import static org.junit.Assert.*;

import org.junit.Test;


public class CourseTest {
	//public Course course = new Course();

	@Test 
	public void testGetId() {
		//Course course = new Course.getId();
		Course course = new Course();
		course.setId(1);
		assertEquals(1,course.getId()); 	
     }
	@Test 
	public void testGetIdnotpass() {
		Course course = new Course();
		course.setId(1);
		assertNotEquals(2,course.getId()); 	
     }
	@Test 
	public void testSetId() {
		int Id =1;
		Course course = new Course();
		course.setId(Id);
		assertEquals(Id,course.getId());
		
		int Id2=2;
		course.setId(Id);
		assertNotEquals(Id2,course.getId());
		
		
     }
	
	@Test 
	public void testSetandGetCourseCode() {
		Course course = new Course();
		String coursecode= "zhangzhidu";
		course.setCourseCode(coursecode);
		assertEquals(coursecode,course.getCourseCode()); 
		
		String coursecode2 ="zhangzh";
		course.setCourseCode(coursecode);
		assertNotEquals(coursecode2,course.getCourseCode()); 
		
     }
	@Test 
	public void testSetandGetCourseName() {
		Course course = new Course();
		String coursename= "zhangzhidu";
		course.setCourseName(coursename);
		assertEquals(coursename,course.getCourseName()); 
		
		String coursename2 ="zhangzh";
		course.setCourseName(coursename);
		assertNotEquals(coursename2,course.getCourseName()); 
		
     }
	@Test 
	public void testSetandGetCourseDesc() {
		Course course = new Course();
		String coursedesc= "zhangzhidu";
		course.setCourseDesc(coursedesc);
		assertEquals(coursedesc,course.getCourseDesc()); 
		
		String coursedesc2 ="zhangzh";
		course.setCourseDesc(coursedesc);
		assertNotEquals(coursedesc2,course.getCourseDesc()); 
		
     }
}