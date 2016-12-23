package beans;

import com.project.dto.JobDTO;
import com.project.service.JobService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by sergeyy on 12/21/16.
 */
@RequestScoped
@ManagedBean
public class PostingsViewBean {

    @ManagedProperty("#{jobService}")
    private JobService jobService;

    private List<JobDTO> jobDTOList;


    @PostConstruct
    public void init() {
        jobDTOList = jobService.getJobList(0, 5);
    }


    public JobService getJobService() {
        return jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public List<JobDTO> getJobDTOList() {
        return jobDTOList;
    }

    public void setJobDTOList(List<JobDTO> jobDTOList) {
        this.jobDTOList = jobDTOList;
    }


}
