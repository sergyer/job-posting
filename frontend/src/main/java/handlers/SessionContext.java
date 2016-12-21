package handlers;

import com.project.dto.JobDTO;
import com.project.dto.UserDTO;
import com.project.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Created by sergeyy on 12/16/16.
 */

@ManagedBean
@SessionScoped
public class SessionContext {
    private UserDTO user;
    private FacesContext context;
    private ExternalContext externalContext;
    private JobDTO jobDTO;

    public SessionContext() {
        context = FacesContext.getCurrentInstance();
        externalContext = context.getExternalContext();
        user = new UserDTO();
        jobDTO = new JobDTO();
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public JobDTO getJobDTO() {
        return jobDTO;
    }

    public void setJobDTO(JobDTO jobDTO) {
        this.jobDTO = jobDTO;
    }
}
