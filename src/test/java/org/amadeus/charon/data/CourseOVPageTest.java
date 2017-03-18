package org.amadeus.charon.data;

import junit.framework.TestCase;

public class CourseOVPageTest extends TestCase {
	
	
	public void isCourse(Course check){
		assertTrue(check.getCourseCode() 
		!= null && check.getCourseName() != null && check.getCourseDesc() != null);	
	}
	
		
	
}
