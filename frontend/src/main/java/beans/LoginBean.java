package beans;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import handlers.SessionContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Created by sergeyy on 12/16/16.
 */

@ManagedBean
@RequestScoped
public class LoginBean {

    @ManagedProperty("#{userService}")
    private UserService userService;

    @ManagedProperty("#{sessionContext}")
    private SessionContext sessionContext;


    private String email;
    private String password;


    public String loginUser() {
        UserDTO userDTO = userService.loginUser(email, password);

        if (userDTO != null) {
            sessionContext.setUser(userDTO);
            return "profile";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", "Registration fail");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
