package org.amadeus.charon.data;

public class Course {
		
		int id;
		String courseCode;
		String courseName;
		String courseDesc;
		
		public Course(int i, String c, String n, String d){
			this.id = i;
			this.courseCode = c;
			this.courseName = n;
			this.courseDesc = d;
		}
		
		//Gets and Sets
		public void setCourseId(int x){
			id = x;
		}
		
		public int getCourseId(){
			return id;
		}
		
		public void setCourseId(String newName){
			courseName = newName;
		}
		
		public void setCourseName(String newName){
			courseName = newName;
		}
		
		public String getCourseName(){
			return courseName;
		}
		
		public void setCourseCode(String newCode){
			courseCode = newCode;
		}
		
		public String getCourseCode(){
			return courseCode;
		}
		
		public void setCourseDesc(String newDescription){
			courseDesc = newDescription;
		}
		
		public String getCourseDesc(){
			return courseDesc;
		}
	
}

