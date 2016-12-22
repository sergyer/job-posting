package com.project.service.impl;

import com.project.dto.JobDTO;
import com.project.model.Job;
import com.project.repository.JobRepo;
import com.project.service.JobService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeyy on 12/20/16.
 */

@Component
@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private Mapper dtoMapper;


    @Override
    public Long saveJob(JobDTO jobDTO) {
        Long id = null;

        if (jobDTO != null) {
            Job jobToBeSaved = dtoMapper.map(jobDTO, Job.class);
            jobRepo.createJob(jobToBeSaved);

            id = jobToBeSaved.getId();
        }

        return id;
    }

    @Override
    public boolean deleteJob(Long id) {
        if (id != null) {
            try {
                jobRepo.deleteJob(id);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }

        }

        return false;
    }

    @Override
    public boolean updateJob(JobDTO jobDTO) {
        if (jobDTO != null) {
            Job jobToBeUpdated = dtoMapper.map(jobDTO, Job.class);
            jobRepo.updateJob(jobToBeUpdated);

        }

        return false;
    }

    @Override
    public List<JobDTO> getJobList(Integer start, Integer max) {
        List<JobDTO> finalList = null;

        if (start != null && max != null) {
            List<Job> listFromDB = jobRepo.getJobList(start, max);

            finalList = new ArrayList<>();

            for (Job j : listFromDB) {
                JobDTO temp = dtoMapper.map(j, JobDTO.class);
                finalList.add(temp);


            }


        }
        return finalList;
    }


    @Override
    public JobDTO getJob(Long id) {
        JobDTO result = null;
        if (id != null) {
            Job jobFromDB = jobRepo.findJob(id);
            result = dtoMapper.map(jobFromDB, JobDTO.class);
            return result;
        }

        return result;
    }

    @Override
    public List<JobDTO> getJobListByUserId(Long userId) {
        List<JobDTO> finalList = null;

        if (userId != null) {
            List<Job> listFromDB = jobRepo.getJobListByUserId(userId);
            finalList = new ArrayList<>(listFromDB.size());

            for (Job j : listFromDB) {
                JobDTO temp = dtoMapper.map(j, JobDTO.class);
                finalList.add(temp);


            }

        }
        return finalList;
    }
}
