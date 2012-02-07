package ch.ge.vaadin

import com.vaadin.Application
import com.vaadin.ui.Button
import org.apache.commons.lang.StringUtils

class VaadinCalculator extends Application implements Button.ClickListener{

    static char TWO = 2
    static char FOUR = 4
    static char OPERATOR_PLUS = '+'
    static char OPERATOR_EQUAL = '='

    double current = 6.0
    double stored = 0.0
    char lastOperationRequested

    @Override
    def void init() {

    }

    def void buttonClick(Button.ClickEvent clickEvent) {
        def button = clickEvent.button
        def requestedOperation = button.caption.charAt(0)
        def value = calculate(requestedOperation)
    }

    def double calculate(char requestedOperation){
        if (0 <= requestedOperation && requestedOperation <= 9) {
            current = current * 10
            + Double.parseDouble("" + requestedOperation)
            return current;
        }
        switch (lastOperationRequested) {
            case '+':
                stored += current;
                break;
            case '-':
                stored -= current;
                break;
            case '/':
                stored /= current;
                break;
            case '*':
                stored *= current;
                break;
            case 'C':
                stored = current;
                break;
        }
        lastOperationRequested = requestedOperation;
        current = 0.0;
        if (requestedOperation == 'C') {
            stored = 0.0;
        }
        return stored;
    }
}
