package ch.ge.vaadin.stories;

import ch.ge.vaadin.root.ErrorView;
import ch.ge.vaadin.root.LogingView;
import com.vaadin.Application;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Window;
import org.fest.assertions.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;

import static org.fest.assertions.Assertions.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.*;

/**
 * Created by IntelliJ IDEA.
 * User: cuvaa
 * Date: 30.01.12
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class LoggingSteps {
    private LogingView logingView;

    @Given("login windows")
    public void aLoginView(){
        logingView = new LogingView();
    }

    @When("I log my $username and $password")
    public void logWithUsernameAndPassword(String username, String password){
        logingView.getUserNameField().setValue(username);
        logingView.getPasswordField().setValue(password);
        logingView.getOKButton();
    }

    @Then("system show the main page")
    public void thenShowTheMainPage() {
        String resultWindow = getCurrentWindowName();
        assertThat(resultWindow).isNotEqualTo(logingView.NAME);
    }

    @Then("system show the login page")
    public void thenShowALoginError() {
        String currentWindow = getCurrentWindowName();
        assertThat(currentWindow).isEqualTo(logingView.NAME);

    }

    @Then("system show an error page and the user is blocked for 1 hour")
    public void thenShowAnErrorPageAndUserIsLogOutFor1Hour() {
        String currentWindow = getCurrentWindowName();
        assertThat(currentWindow).isEqualTo(ErrorView.NAME);
    }

    private String getCurrentWindowName() {
        return logingView.getApplication().getMainWindow().getName();
    }
    
}

