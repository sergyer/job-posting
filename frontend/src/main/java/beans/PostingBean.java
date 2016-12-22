package beans;

import com.project.dto.JobDTO;
import com.project.service.JobService;
import handlers.SessionContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by sergeyy on 12/20/16.
 */

@RequestScoped
@ManagedBean
public class PostingBean {

    @ManagedProperty("#{jobService}")
    private JobService jobService;

    @ManagedProperty("#{sessionContext}")
    private SessionContext sessionContext;

    private List<JobDTO> jobDTOList;


    private JobDTO jobDTO;

    @ManagedProperty(value = "#{param.jobId}")
    private Long id;


    @PostConstruct
    public void init() {

        jobDTOList = jobService.getJobListByUserId(sessionContext.getUser().getId());
        jobDTO = new JobDTO();
    }


    public String post() {

        jobDTO.setUserId(sessionContext.getUser().getId());
        jobService.saveJob(jobDTO);
        sessionContext.setJobDTO(jobDTO);

        return "postings?faces-redirect=true";
    }

    public String updatePost() {

        jobService.updateJob(sessionContext.getJobDTO());
        return "postings?faces-redirect=true";
    }

    public String deletePost() {
        JobDTO jobToBeDeleted = sessionContext.getJobDTO();
        if (jobService.deleteJob(jobToBeDeleted.getId())) {
            jobDTOList.remove(jobToBeDeleted);
            return "postings?faces-redirect=true";
        }
        return null;
    }


    public String setJobForEditing() {


        for (JobDTO j : jobDTOList) {
            if (j.getId().equals(id)) {
                sessionContext.setJobDTO(j);
            }

        }

        return "editPost";

    }


    public List<JobDTO> getJobDTOList() {
        return jobDTOList;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    public void setJobDTOList(List<JobDTO> jobDTOList) {
        this.jobDTOList = jobDTOList;
    }

    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public JobDTO getJobDTO() {
        return jobDTO;
    }

    public void setJobDTO(JobDTO jobDTO) {
        this.jobDTO = jobDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
