package com.example.story.bdd.stories;

import com.example.story.bdd.steps.ExampleValidatorSteps;
import com.example.story.bdd.reporters.ConsoleStoryReporter;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RunWith(JUnitReportingRunner.class)
public class ExampleJBehaveValidator extends JUnitStories {
    public ExampleJBehaveValidator() {
        configuredEmbedder().embedderControls()
                .doGenerateViewAfterStories(true)
                .doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(false)
                .useStoryTimeoutInSecs(300L);
        useConfiguration(configuration());
    }

    private URL getStoryUrl() {
        URL storyURL = null;
        try {
            // This requires you to start Maven from the project directory
            storyURL = new URL("file://" + System.getProperty("user.dir")
                    + "/src/main/resources/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return storyURL;
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(
                        new LoadFromRelativeFile(getStoryUrl()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withReporters(new ConsoleStoryReporter())
                                .withFormats(
                                        Format.CONSOLE,
                                        Format.HTML,
                                        Format.XML,
                                        Format.STATS))
                .usePendingStepStrategy(new FailingUponPendingStep());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/main/resources"),
                "stories/EXAMPLE.story", "");
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new ExampleValidatorSteps());
    }}