package beans;

import com.project.dto.JobDTO;
import com.project.service.JobService;
import com.project.service.UserService;
import handlers.SessionContext;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


/**
 * Created by sergeyy on 12/20/16.
 */

@ViewScoped
@ManagedBean
public class PostingBean {

    @ManagedProperty("#{jobService}")
    private JobService jobService;

    @ManagedProperty("#{sessionContext}")
    private SessionContext sessionContext;

    private List<JobDTO> jobDTOList;

    @PostConstruct
    public void init() {
        jobDTOList = jobService.getJobListByUserId(sessionContext.getUser().getId());

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
}
