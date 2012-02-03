package ch.ge.vaadin

import com.vaadin.Application
import com.vaadin.ui.Button

class VaadinCalculator extends Application implements Button.ClickListener{

    static String ONE = "1"
    String result = 6

    @Override
    def void init() {

    }

    def void buttonClick(Button.ClickEvent clickEvent) {
        def button = clickEvent.button
        result = button.caption
    }
}
