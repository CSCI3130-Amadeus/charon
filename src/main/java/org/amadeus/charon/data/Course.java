package org.amadeus.charon.data;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Course implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -618163043918935270L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 5, max = 64)
    private String courseCode;

    @NotNull
    @Size(min = 5, max = 64)
    private String courseName;

    @NotNull
    @Size(min = 5, max = 4096)
    private String courseDec;
    
    @OneToMany(mappedBy="course", cascade=CascadeType.ALL)
    private Collection<Review> reviews;
    

    public Course(String courseCode, String courseName, String courseDesc) {
        super();
        this.courseCode = courseCode;
        this.courseDec = courseDesc;
    }
    
    public Course() {}

    public long getId() {
        return id;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public String getCourseCode() {
        return courseCode;
    }
    
    
}
