package ch.ge.vaadin.stories;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;

import java.net.URL;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: cuvaa
 * Date: 31.01.12
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public class AcceptanceEmbedder extends Embedder {

    /**
     *
     * @return
     */
    @Override
    public Configuration configuration() {
        Class<?> embedderClass = this.getClass();
        URL codeLocation = CodeLocations.codeLocationFromClass(embedderClass);

        return;
    }

}
