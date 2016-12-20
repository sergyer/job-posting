package com.project.dto;

import com.project.utils.DeadLine;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sergeyy on 12/20/16.
 */
public class JobDTO {

    private Long id;
    private Long userId;
    private String title;
    private String content;
    private Date postDate;
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
        int dayOfMonth = deadLine.get(Calendar.DAY_OF_MONTH);
        int month = deadLine.get(Calendar.MONTH);
        int year = deadLine.get(Calendar.YEAR);

        return new DeadLine(year, month, dayOfMonth);
    }

    public void setDeadLine(Calendar deadLine) {
        this.deadLine = deadLine;
    }



}
