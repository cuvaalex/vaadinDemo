package ch.ge.vaadin.root;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 * Created by IntelliJ IDEA.
 * User: cuvaa
 * Date: 30.01.12
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class LogingView extends Window {

    public static final String NAME = "LogingView";

    public TextField getUserNameField() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public PasswordField getPasswordField() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public Button getOKButton() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return  NAME;
    }
}

