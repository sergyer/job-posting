package com.project.repository;

import com.project.model.Job;

import java.util.List;

/**
 * Created by sergeyy on 12/12/16.
 */
public interface JobRepo {

    Long createJob(Job job);

    List<Job> getJobList(Integer start, Integer max);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job job);

    Job loadJob(Long id);

    Job findJob(Long id);


}


