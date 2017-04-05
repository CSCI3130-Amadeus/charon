package org.amadeus.charon.data;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Created by aaron on 03/04/17.
 */
@Entity
public class AltTextbook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User owner;

    @ManyToOne
    private Course course;

    @Size(min = 5, max = 4096)
    private String url;

    @NotNull
    @Size(min = 5, max = 4096)
    private String title;

    public AltTextbook(User owner, Course course, String title, String url) {
        this.owner = owner;
        this.course = course;
        this.title = title;

        if (!url.equals("")) {
            this.url = url;
        }
        else {
            this.url = null;
        }
    }

    public AltTextbook() { }

    public User getOwner() {
        return owner;
    }

    public Course getCourse() {
        return course;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
