package validators;

import handlers.SessionContext;
import org.hibernate.Session;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by sergeyy on 12/26/16.
 */
public class AuthenticationPhaseListener implements PhaseListener {
    private Map<String, String> pagePermissionsMap;


    private void pagePermissionsMap() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (pagePermissionsMap == null) {
            pagePermissionsMap = new HashMap<>();

            try {
                ResourceBundle bundle = facesContext.getApplication().
                        getResourceBundle(facesContext, "access");
                if (bundle != null) {
                    Enumeration e = bundle.getKeys();
                    while (e.hasMoreElements()) {
                        String key = (String) e.nextElement();
                        String value = bundle.getString(key);
                        pagePermissionsMap.put(key, value);
                    }
                }
            } catch (Exception e) {

            }

        }

    }


    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        FacesContext context = phaseEvent.getFacesContext();
        ExternalContext ex = context.getExternalContext();

        try {
            pagePermissionsMap();

            String viewId = "/index.xhtml";


            if (context.getViewRoot() != null && context.getViewRoot().getViewId() != null) {
                viewId = context.getViewRoot().getViewId();
            }

            Integer permission = Integer.valueOf(pagePermissionsMap.get(viewId));
            SessionContext sessionContext = (SessionContext) ex.getSessionMap().get("sessionContext");
            if (sessionContext == null) {
                redirect(context,"index.xhtml");
            }

            if (sessionContext != null && sessionContext.getUser().getRole().equals(1) && permission.equals(1)) {
                redirect(context, "userlist.xhtml");
            }
        } catch (Exception e) {
            redirect(context,"index.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {

    }


    private static void redirect(FacesContext facesContext, String url) {
        try {
            facesContext.getExternalContext().redirect(url);
        } catch (IOException e) {
            throw new FacesException("Cannot redirect to " + url + " due to IO exception.", e);
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return null;
    }
}
