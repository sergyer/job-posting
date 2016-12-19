package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Created by sergeyy on 12/19/16.
 */

@ManagedBean
@RequestScoped
public class LogoutBean {
    ExternalContext externalContext;

    public String logout() {
        externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();
        return "index";
    }
}
