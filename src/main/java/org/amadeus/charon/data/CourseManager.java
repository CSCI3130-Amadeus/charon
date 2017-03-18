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
        FAILURE
    }
    
    private HashMap<Integer, Course> course;
    private static CourseManager instance;
    
    private CourseManager() {
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
    
     public boolean addCourseCode(int id, String courseCode, String courseName, String courseDesc){
//    	 CourseManager add = new CourseManager();
    	 Course add = new Course(courseCode, courseName, courseDesc);
    	 if (course.put(id, add) == null)
    		 return false;
    	 
    	 else
    		 return true;
     }
     
     public boolean delCourse(int id){
    	 Course del = course.get(id);
    	 if(course.remove(id, del))
    		 return true;
    	 else
    		 return false;
     }
     
     public boolean editCourse(int id, String courseCode, String courseName, String courseDesc){
    	 if(course.isEmpty())
    		 return false;
    	 
    	 Course edit = course.get(id);
    	 if(courseCode != null)
    		 edit.setCourseCode(courseCode);
    	 if(courseName != null)
    		 edit.setCourseName(courseName);
    	 if(courseDesc != null)
    		 edit.setCourseDesc(courseDesc);
    	 course.remove(id);
    	 course.put(id, edit);
    	 
    	 return true;
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