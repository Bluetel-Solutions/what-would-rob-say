package uk.co.bluetel.wwrs;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import uk.co.bluetel.wwrs.auth.User;
import uk.co.bluetel.wwrs.auth.WWRSAuthenticator;
import uk.co.bluetel.wwrs.auth.WWRSAuthorizer;
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
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new WWRSAuthenticator())
                .setAuthorizer(new WWRSAuthorizer())
                .buildAuthFilter()
        ));
        environment.jersey().register(new AuthValueFactoryProvider.Binder(User.class));
        environment.jersey().register(new DefaultResource());

        // Add Health Checks
        environment.healthChecks().register("Template", new TemplateHealthCheck(configuration.getTemplate()));
    }
}
