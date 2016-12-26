package beans;

import com.project.dto.UserDTO;
import com.project.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.ResourceBundle;

/**
 * Created by sergeyy on 12/14/16.
 */

@ManagedBean
@ViewScoped
public class UserBean {

    @ManagedProperty("#{userService}")
    private UserService userService;
    private UserDTO user;

    @ManagedProperty("#{i18n}")
    private ResourceBundle bundle;

    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public UserBean() {
        user = new UserDTO();
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public String registerUser() {
        Long userId = userService.saveUser(user);
        if (userId != null) {

            FacesMessage msg = new FacesMessage(bundle.getString("registrationSuccess"));

            FacesContext.getCurrentInstance().addMessage(null, msg);

            return "registration_success.xhtml";

        }
        FacesMessage msg = new FacesMessage(bundle.getString("emailIsBusy"));
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return null;

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }
}
