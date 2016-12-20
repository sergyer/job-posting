package com.project.service;

import com.project.dto.JobDTO;
import com.project.model.Job;

import java.util.List;

/**
 * Created by sergeyy on 12/20/16.
 */
public interface JobService {

    Long saveJob(JobDTO jobDTO);

    boolean deleteJob(Long id);

    boolean updateJob(JobDTO jobDTO);

    List<JobDTO> getJobList(Integer start, Integer max);

    Job loadJob(Long id);

    Job findJob(Long id);

    List<JobDTO> getJobListByUserId(Long userId);

}
