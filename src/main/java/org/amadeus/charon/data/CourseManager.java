package org.amadeus.charon.data;

import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.*;

public class CourseManager {

    public static final String PERSISTENCE_UNIT = "charon_db";

    private EntityManagerFactory emFactory;
  
    private static CourseManager instance;
    
    private CourseManager() {
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }
    
    public static CourseManager getInstance(){
        if (instance == null) {
            instance = new CourseManager();
        }
        
        return instance;
    }
    
    public void createCourse(String courseCode, String courseName, String courseDesc, String sylPath){
    	EntityManager em = emFactory.createEntityManager();
    	
        em.getTransaction().begin();
        Course course = new Course(courseCode, courseName, courseDesc);
        course.setSyllabusPath(sylPath);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }
    
    public void editCourse(Course course, String courseCode, String courseName, String courseDesc){
    	EntityManager em = emFactory.createEntityManager();
    	em.getTransaction().begin();
    	
    	course.setCourseCode(courseCode);
    	course.setCourseName(courseName);
    	course.setCourseDesc(courseDesc);
    	
    	em.merge(course);
    	em.getTransaction().commit();
    	em.close();
    	
    }
    
    // THIS IS A DEBUGGING METHOD. DO NOT USE IT FOR REAL STUFF.
    // THIS MEANS YOU.
    public Course getCourseByCode(String courseCode) {
        EntityManager em = emFactory.createEntityManager();
    	// Set up query.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> rootCourse = cq.from(Course.class);
        // Select where course codes are equal
        cq.where(cb.equal(rootCourse.get("courseCode"), cb.parameter(String.class, "courseCode")));
        Query q = em.createQuery(cq);
        // Set the course code to the given username.
        q.setParameter("courseCode", courseCode);
        // Get results (there should only be one.)
        List<Course> result = q.getResultList();
        
        if(result.size() >= 1){
            return result.get(0);
        }
        // No course found. 
        return null;
    }
    
    public List<Course> getCourseList() {
    	EntityManager em = emFactory.createEntityManager();
    	// Set up query.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Query q = em.createQuery(cq);
        List<Course> result = q.getResultList();
        em.close();
         
        return result;
    }
    
    public Course getCourse(long id) {
    	EntityManager em = emFactory.createEntityManager();
        Course course = em.find(Course.class, id);
        em.close();
        return course;
    }
    
}