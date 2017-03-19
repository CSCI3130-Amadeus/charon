package org.amadeus.charon.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CourseManager {

    public static final String PERSISTENCE_UNIT = "charon_db";

    private EntityManager em;
  
    private static CourseManager instance;
    
    private CourseManager() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emFactory.createEntityManager();
    }
    
    public static CourseManager getInstance(){
        if (instance == null) {
            instance = new CourseManager();
        }
        
        return instance;
    }
    
    public long createCourse(String courseCode, String courseName, String courseDesc){
        
        em.getTransaction().begin();
        Course course = new Course(courseCode, courseName, courseDesc);
        em.persist(course);
        em.getTransaction().commit();
        
        return course.getId();
    }
    
    
    public Course getCourse(long id) {
        return em.find(Course.class, id);
    }
    
}
