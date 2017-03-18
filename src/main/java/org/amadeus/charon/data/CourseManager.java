package org.amadeus.charon.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class CourseManager {

	
    public static final String PERSISTENCE_UNIT = "charon_db";

    private EntityManager em;
    
    public enum CourseMessage  {
        SUCCESS,
        FAILURE,
        EMPTY
    }
    
    public HashMap<Integer, Course> course;
    private static CourseManager instance;
    
    public CourseManager() {
        course = new HashMap<Integer, Course>();
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emFactory.createEntityManager();
    }
    
    
    public static CourseManager getInstance() {
        if (instance == null) {
            instance = new CourseManager();
        }
        return instance;
    }
    
     public boolean addCourse(int id, String courseCode, String courseName, String courseDesc){
//    	 CourseManager add = new CourseManager();
    	 Course add = new Course(courseCode, courseName, courseDesc);
    	 course.put(id, add);
    	 if (course.containsKey(id))
    		 return true;
    	 
    	 else
    		 return false;
     }
     
     public boolean delCourse(int id){
    	 Course del = course.get(id);
    	 if(course.remove(id, del))
    		 return true;
    	 else
    		 return false;
     }
     
     public boolean editCourseCode(int id, String courseCode){
    	 if(course.isEmpty())
    		 return false;
    	 
    	 Course edit = course.get(id);
    	 Course old = edit;
    	 if(courseCode != null)
    		 edit.setCourseCode(courseCode);
    	 return course.replace(id, old, edit);
    	 
     }
     
     public boolean editCourseName(int id, String courseName){
    	 if(course.isEmpty())
    		 return false;
    	 
    	 Course edit = course.get(id);
    	 Course old = edit;
    	 if(courseName != null)
    		 edit.setCourseCode(courseName);
    	 return course.replace(id, old, edit);
     }
     
     public boolean editCourseDesc(int id, String courseDesc){
    	 if(course.isEmpty())
    		 return false;
    	 
    	 Course edit = course.get(id);
    	 Course old = edit;
    	 if(courseDesc != null)
    		 edit.setCourseCode(courseDesc);
    	 return course.replace(id, old, edit);
     }
     
     private List<Course> getCourseList(){
         // This is all to do one query.......
         CriteriaBuilder cb = em.getCriteriaBuilder();
         CriteriaQuery<Course> cq = cb.createQuery(Course.class);
         Root<Course> rootCourse = cq.from(Course.class);
         cq.select(rootCourse);
         TypedQuery<Course> q = em.createQuery(cq);
         List<Course> course = q.getResultList();
         
         return course;
     }
}