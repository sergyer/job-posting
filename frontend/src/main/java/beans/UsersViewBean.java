package beans;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import utils.CommonUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by sergeyy on 12/27/16.
 */

@RequestScoped
@ManagedBean
public class UsersViewBean {

    @ManagedProperty("#{userService}")
    private UserService userService;

    private List<UserDTO> userDTOList;



    @PostConstruct
    public void init() {
        userDTOList = userService.getAllUsers();

        System.out.println("sdasdas");
        for (UserDTO u:userDTOList) {
            CommonUtils.prepareLastVisitDate(u);
        }
    }



    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }


}
