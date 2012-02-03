package ch.ge.vaadin

import org.junit.Test
import org.junit.Before
import org.junit.After
import com.vaadin.ui.Button
import org.mockito.Mockito
import static org.mockito.Mockito.*

/**
 * Created by IntelliJ IDEA.
 * User: cuvaa
 * Date: 03.02.12
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */
class VaadinCalculatorTest {

    private VaadinCalculator calculator
    
    @Before void before() {
        calculator = new VaadinCalculator()
        calculator.init()
    }
    
    @After void after() {
        calculator.close()
    }
    
    @Test void shouldDisplay1IfIPressButton1() {
        def event = mock(Button.ClickEvent)
        def button = mock(Button)
        
        when(button.getCaption()).thenReturn(VaadinCalculator.ONE)
        when(event.button).thenReturn(button)

        calculator.buttonClick(event)

        assert calculator.result == VaadinCalculator.ONE

    }

}
