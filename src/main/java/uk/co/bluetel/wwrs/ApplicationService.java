package uk.co.bluetel.wwrs;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.co.bluetel.wwrs.health.TemplateHealthCheck;

public class ApplicationService extends Application<ApplicationConfiguration> {

    /**
     * Main Application method, calls to run the Application
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    /**
     * Returns the Application Name
     * @return String representation of the App name
     */
    @Override
    public String getName() {
        return "what-would-rob-say";
    }

    /**
     * Initializes the App
     * @param bootstrap
     */
    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {

    }

    /**
     * Runs the Application
     * @param configuration
     * @param environment
     */
    @Override
    public void run(ApplicationConfiguration configuration,
                    Environment environment) {

        // Add Resources
        environment.jersey().register(new DefaultResource());

        // Add Health Checks
        environment.healthChecks().register("Template", new TemplateHealthCheck(configuration.getTemplate()));
    }
}
