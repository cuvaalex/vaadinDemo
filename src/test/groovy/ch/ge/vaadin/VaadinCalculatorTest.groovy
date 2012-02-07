package ch.ge.vaadin

import org.junit.Test
import org.junit.Before
import org.junit.After
import com.vaadin.ui.Button
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
    
    @Test void shouldDisplay2IfIPressButton2() {
        def event = mock(Button.ClickEvent)
        def button = mock(Button)
        
        when(button.getCaption()).thenReturn("2")
        when(event.button).thenReturn(button)

        calculator.buttonClick(event)

        assert calculator.stored == 2.0

    }

    @Test void shouldDisplay2IfIPressButton2AndPlus() {
        def event = mock(Button.ClickEvent)
        def button = mock(Button)

        when(button.getCaption()).thenReturn("2")
        when(event.button).thenReturn(button)

        calculator.buttonClick(event)

        when(button.getCaption()).thenReturn("+")
        calculator.buttonClick(event)

        assert calculator.current == 2.0

    }

    @Test void shouldDisplay4IfIPressButton2AndPlusAnd4() {
        def event = mock(Button.ClickEvent)
        def button = mock(Button)

        when(button.getCaption()).thenReturn("2")
        when(event.button).thenReturn(button)

        calculator.buttonClick(event)

        when(button.getCaption()).thenReturn("+")
        calculator.buttonClick(event)

        when(button.getCaption()).thenReturn("4")
        calculator.buttonClick(event)

        assert calculator.current == 4.0

    }

    @Test void shouldDisplay6IfIPressButton2AndPlusAnd4AndEqual() {
        def event = mock(Button.ClickEvent)
        def button = mock(Button)

        when(button.getCaption()).thenReturn("2")
        when(event.button).thenReturn(button)

        calculator.buttonClick(event)

        when(button.getCaption()).thenReturn("1")
        calculator.buttonClick(event)

        when(button.getCaption()).thenReturn("4")
        calculator.buttonClick(event)

        when(button.getCaption()).thenReturn("=")
        calculator.buttonClick(event)

        assert calculator.current == 6.0

    }

}
