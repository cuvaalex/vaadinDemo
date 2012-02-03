package ch.ge.vaadin

import com.vaadin.ui.Button
import spock.lang.Specification
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by IntelliJ IDEA.
 * User: cuvaa
 * Date: 02.02.12
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
class CalculatorSpec extends Specification {
    def VaadinCalculator application
        
    def setup() {
        application = new VaadinCalculator()
        application.init()
    }

    def cleanup() {
        application.close()
    }

    def whenIAdd2and4IExpect6() {
        when:
        clickButton("C")
        clickButton("2")
        clickButton("+")
        clickButton("4")
        clickButton("=")

        then:
        def result = application.result
        result == "6"
    }

    def clickButton(String buttonName){
        def clickEvent = mock(Button.ClickEvent)
        def button = mock(Button)
        
        when(button.getCaption()).thenReturn(buttonName)
        when(clickEvent.button).thenReturn(button)

        application.buttonClick(clickEvent)
    }
}
