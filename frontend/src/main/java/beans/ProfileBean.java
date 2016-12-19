package beans;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import handlers.SessionContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Created by sergeyy on 12/16/16.
 */

@ManagedBean
@RequestScoped
public class ProfileBean {

    @ManagedProperty("#{userService}")
    private UserService userService;

    @ManagedProperty("#{sessionContext}")
    private SessionContext sessionContext;

    private UserDTO user;


    @PostConstruct
    public void init() {
        user = userService.getUserById(sessionContext.getUser().getId());


    }


    public String updateUser() {
//        if (user.getPassword().isEmpty()) {
//            user.setPassword(null);
//        }
        userService.updateUser(user);
        sessionContext.setUser(user);

        return null;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }
}
