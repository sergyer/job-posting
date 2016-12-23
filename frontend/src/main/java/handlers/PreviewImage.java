package handlers;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.utils.FacesUtil;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/PreviewImage"})
public class PreviewImage extends HttpServlet {


    private UserService userService;


    private static final long serialVersionUID = -6624464650990859671L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPreviewImage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void doPreviewImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FacesContext context = FacesUtil.getFacesContext(request, response);


        /*Injecting spring bean*/
        userService = context.getApplication().evaluateExpressionGet(context, "#{userService}", UserService.class);


        String fileIdStr = request.getParameter("fileId");


        if (fileIdStr != null) {

            UserDTO userDTO = userService.getUserById(Long.valueOf(fileIdStr));
            if (userDTO != null) {
                byte[] content = userDTO.getImage();
                if (content != null) {
                    response.setContentType("image/png");
                    try {
                        response.getOutputStream().write(content);
                    } catch (IOException e) {

                    } catch (Exception e) {

                    } finally {
                        content = null;
                        userDTO = null;
                    }
                    return;
                }
            } else {
                response.addHeader("Pragma", "no-cache");
                response.addDateHeader("Expires", System.currentTimeMillis() - 1000 * 3600);
                try {
                    response.getWriter().println("file object is null");
                } catch (Exception e) {
                }
                return;
            }
        }


        response.addHeader("Pragma", "no-cache");
        response.addDateHeader("Expires", System.currentTimeMillis() - 1000 * 3600);
        try {
            response.getWriter().println("file id is not set");
        } catch (Exception e) {
        }
    }



}
