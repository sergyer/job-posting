package beans;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import handlers.SessionContext;
import utils.CommonUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.time.*;
import java.util.List;

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

    private Part uploadedFile;

    private List<UserDTO> userDTOList;


    @PostConstruct
    public void init() {
        user = userService.getUserById(sessionContext.getUser().getId());
      /*  prepareLastVisit();*/
        CommonUtils.prepareLastVisitDate(user);

    }


    public String updateUser() {


        userService.updateUser(user);
        sessionContext.setUser(user);

        return "profile?faces-redirect=true";
    }

    public String updateUserPswd() {
        userService.updateUserPswd(user);
        sessionContext.setUser(user);
        return null;
    }

    public String doUploadFile() {


        try {
            InputStream inputStream = uploadedFile.getInputStream();
            byte[] contentBytes = new byte[(int) uploadedFile.getSize()];

            inputStream.read(contentBytes);
            user.setImage(contentBytes);
            userService.updateUser(user);
            sessionContext.setUser(user);


        } catch (IOException e) {

        } catch (NullPointerException e) {
            System.out.println("empty file!!!!!!!");
            return "profile?faces-redirect=true";
        }


        return "profile?faces-redirect=true";


    }

    public String doDeleteFile() {
        user.setImage(null);
        userService.updateUser(user);
        sessionContext.setUser(user);

        return "profile?faces-redirect=true";
    }


    /*public void prepareLastVisit() {
        Instant instant = user.getLastVisitedDate().toInstant();
        ZonedDateTime zd = instant.atZone(ZoneId.systemDefault());

        LocalDate lastVisited = zd.toLocalDate();
        LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());

        Period period = Period.between(lastVisited, currentDate);

        String result = period.getDays() + "ago";

        if (period.getMonths() != 0 || period.getYears() != 0) {
            result = period.getDays() + "days " + period.getMonths() + "months " +
                    period.getYears() + "years ago";
        }
        user.setLastVisit(result);

    }*/


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

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}
