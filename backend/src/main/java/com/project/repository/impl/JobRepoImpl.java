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


    public List<Job> getJobListByUserId(Long userId) {
        List<Job> finalList = null;
        Query query = session().createQuery("SELECT c FROM Job c where c.userId=:userId")
                .setParameter("userId", userId);
        finalList = query.list();
        return finalList;
    }

    public void createJob(Job job) {

        job.setPostDate(new Date());
        session().persist(job);
        session().flush();


    }

    public List<Job> getJobList(Integer start, Integer max) {
        List<Job> finalList = null;

        Query query = session().createQuery("SELECT c FROM Job c WHERE c.id > 0");
        query.setFirstResult(start);
        query.setMaxResults(max);
        finalList = query.list();

        return finalList;
    }

    public void deleteJob(Long id) {
        Job jobToDelete = findJob(id);
        delete(jobToDelete);


    }

    public void updateJob(Job job) {
        session().update(job);

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











