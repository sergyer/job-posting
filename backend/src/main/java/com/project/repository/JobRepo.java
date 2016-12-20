package com.project.repository;

import com.project.model.Job;

import java.util.List;

/**
 * Created by sergeyy on 12/12/16.
 */
public interface JobRepo {

    void createJob(Job job);

    void deleteJob(Long id);

    void updateJob(Job job);

    List<Job> getJobList(Integer start, Integer max);

    Job loadJob(Long id);

    Job findJob(Long id);

    List<Job> getJobListByUserId(Long userId);


}


