package com.project.repository.impl;

import com.project.model.Job;
import com.project.repository.AbstractRepo;
import com.project.repository.JobRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by sergeyy on 12/12/16.
 */
@Repository
@Transactional
public class JobRepoImpl extends AbstractRepo implements JobRepo {

    public Long createJob(Job job) {
        Long id = 0L;

        try {
            job.setPostDate(new Date());
            session().persist(job);
            session().flush();
            id = job.getId();


        } catch (Exception e) {

        }

        return id;
    }

    public List<Job> getJobList(Integer start, Integer max) {
        List<Job> finalList = null;
        try {
            Query query = session().createSQLQuery("SELECT * FROM jobfinder.job  WHERE id>0");
            if (start != null) {
                query.setFirstResult(start);
            }
            if (max != null) {
                query.setMaxResults(max);
            }
            finalList = query.list();


        } catch (Exception e) {

        }
        return finalList;
    }

    public boolean deleteJob(Long id) {
        Job jobToDelete = findJob(id);
        if (jobToDelete != null) {
            delete(jobToDelete);
            return true;
        }

        return false;


    }

    public boolean updateJob(Long id, Job job) {
        if (job != null) {
            System.out.println(findJob(id).getDescription());
            Job jobFromDb = findJob(id);

            jobFromDb.setDeadLine(job.getDeadLine());
            jobFromDb.setTitle(job.getTitle());
            jobFromDb.setDescription(job.getDescription());

            return true;
        }
        return false;
    }


    public Job loadJob(Long id) {
        Job job = null;

        try {
            job = (Job) session().load(Job.class, id);
            if (job == null) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

        return job;
    }

    public Job findJob(Long id) {
        Job job = null;

        try {
            job = (Job) session().get(Job.class, id);
            if (job == null) {
                return null;
            }

        } catch (Exception e) {
            return null;
        }

        return job;

    }


}











