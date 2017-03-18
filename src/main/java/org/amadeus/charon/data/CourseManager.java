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
        INVALID_PASSWORD,
        INVALID_USERNAME,
        EMPTY
    }
    
    private HashMap<String, Course> course;
    private static CourseManager instance;
    
    private CourseManager() {
        course = new HashMap<String, Course>();
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emFactory.createEntityManager();
    
    }
	
	
}
