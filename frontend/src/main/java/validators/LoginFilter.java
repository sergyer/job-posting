package validators;

import handlers.SessionContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by sergeyy on 12/27/16.
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/pages/admin/*")
public class LoginFilter implements Filter {

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n");

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        SessionContext sessionContext = (SessionContext) request.getSession().getAttribute("sessionContext");

        if (sessionContext.getUser().getEmail() == null) {

            response.sendRedirect("../../login.xhtml");


         /*   FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("notAuthorized"));
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);*/

        } else {

            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {


    }

}
