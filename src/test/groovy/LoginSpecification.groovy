
/**
 * Created by IntelliJ IDEA.
 * User: cuvaa
 * Date: 01.02.12
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */

import spock.lang.*
import ch.ge.vaadin.root.LogingView
import static org.fest.assertions.Assertions.*
import ch.ge.vaadin.MyVaadinApplication
import static org.mockito.Mockito.*
import com.vaadin.ui.PasswordField
import com.vaadin.ui.TextField;

class ALoginView extends Specification {         

    MyVaadinApplication app

    def setup() {
        app = new MyVaadinApplication()
        app.init()
    }

    def cleanup() {
        app.close()
    }

    def "log user with coorect values"() {
        def logingView = mock(LogingView)
        def passwordField = mock(PasswordField)
        def usernameField = mock(TextField)

        when:
        when(passwordField.getValue()).thenReturn(password)
        when(logingView.passwordField).thenReturn(passwordField)
        when(usernameField.getValue()).thenReturn(username)
        when(logingView.userNameField).thenReturn(usernameField)
        
        then:
        def resultWindow = getResultWindow(logingView)
        resultWindow == viewName
        
        where:
        username | password  | viewName
        'toto'   | 'totopwd' | LogingView.NAME
        'tata'   | 'tatapwd' | "test"

        
    }
    
    def getResultWindow(view) {
        return app.getMainWindow().getName()
    }
}
