package org.amadeus.charon.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Review implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5813797372631188327L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    private User owner;

    @ManyToOne
    private Course course;
    
    @NotNull
    @Size(min = 5, max = 4096)
    private String comment;
    
    @NotNull
    private int rating;

    public Review(String comment, User owner, Course course, int rating) {
        this.comment = comment;
        this.owner = owner;
        this.course = course;
        this.rating = rating;
    }
    
    public Review() {
        
    }

    public User getOwner() {
        return owner;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public void setRating(int rating){
    	this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public Course getCourse() {
        return course;
    }
    
    public int getRating() {
    	return rating;
    }

}
