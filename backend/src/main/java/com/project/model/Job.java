package com.project.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sergeyy on 12/12/16.
 */

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar deadLine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Calendar getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Calendar deadLine) {
        this.deadLine = deadLine;
    }
}
