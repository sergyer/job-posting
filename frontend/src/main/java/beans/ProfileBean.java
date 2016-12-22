package beans;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import handlers.SessionContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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


    @PostConstruct
    public void init() {
        user = userService.getUserById(sessionContext.getUser().getId());


    }


   /* public StreamedContent getProfileImage() {
        if (sessionContext.getUser().getImage() == null) {
            return new DefaultStreamedContent(new ByteArrayInputStream(sessionContext.getUser().getImage()));

        }
        return null;
    }*/

    public String updateUser() {
      /*  if (uploadedFile != null) {
            doUploadFile();
        }*/
        userService.updateUser(user);
        sessionContext.setUser(user);

        return null;
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

        }

        return null;
    }

    public void doDeleteFile() {
        user.setImage(null);
        updateUser();
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

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}
