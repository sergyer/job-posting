package com.project.model;

import com.project.utils.DeadLine;

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

    @Column(name = "user_id")
    private Long userId;

    private String title;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "post_date")
    private Date postDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dead_line")
    private Calendar deadLine;


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public void setDeadLine(DeadLine deadLine) {
        this.deadLine = deadLine;
    }

}
