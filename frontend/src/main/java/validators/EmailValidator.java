package validators;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergeyy on 12/26/16.
 */

@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {


    private ResourceBundle bundle = ResourceBundle.getBundle("i18n");

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String enteredEmail = (String) o;
        Pattern p = Pattern.compile("^[a-zA-Z0-9._-]+@.+\\.[a-z]+");

        FacesMessage errorMsg = new FacesMessage(bundle.getString("wrongEmailFormat"));
        if (enteredEmail.trim().length() > 255) {
            throw new ValidatorException(errorMsg);
        }

        Matcher matcher = p.matcher(enteredEmail.trim());
        boolean matchfound = matcher.matches();
        if (!matchfound) {
            throw new ValidatorException(errorMsg);

        }
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }
}
