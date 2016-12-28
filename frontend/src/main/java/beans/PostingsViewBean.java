package beans;

import com.project.dto.JobDTO;
import com.project.service.JobService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by sergeyy on 12/21/16.
 */
@RequestScoped
@ManagedBean
public class PostingsViewBean {

    @ManagedProperty("#{jobService}")
    private JobService jobService;

    private List<JobDTO> jobDTOList;

    private String searchingTitle;

    @ManagedProperty("#{i18n}")
    private ResourceBundle bundle;


    @PostConstruct
    public void init() {
        jobDTOList = jobService.getJobList(0, 5);
    }

    public void doSearch() {
        if (searchingTitle == null) {
            FacesMessage msg = new FacesMessage(bundle.getString("emptySearchTitle"));
            FacesContext.getCurrentInstance().addMessage(null,msg);
        } else {
            jobDTOList=jobService.findJobsByTitle(searchingTitle);
        }

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


    public String getSearchingTitle() {
        return searchingTitle;
    }

    public void setSearchingTitle(String searchingTitle) {
        this.searchingTitle = searchingTitle;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }
}
