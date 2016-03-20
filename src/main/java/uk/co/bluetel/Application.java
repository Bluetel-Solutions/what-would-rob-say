package uk.co.bluetel;

import uk.co.bluetel.core.Template;
import uk.co.bluetel.resources.DefaultResource;
import uk.co.bluetel.templates.HealthCheck;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.migrations.MigrationsBundle;

public class Application extends Service<ApplicationConfiguration> {

    /**
     * Main method that controls the running of the Application
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new Application().run(args);
    }

    /**
     * Init's the Application, This is where you would add new bundles
     * For example, Hibernate.
     * @param bootstrap
     */
    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.setName("what-would-rob-say");
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<ApplicationConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(ApplicationConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });
    }

    /**
     * Runs the Application, this is where you can add resources and such.
     * @param configuration
     * @param environment
     * @throws ClassNotFoundException
     */
    @Override
    public void run(ApplicationConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {

        final Template template = configuration.buildTemplate();

        environment.addHealthCheck(new HealthCheck(template));
        environment.addResource(new DefaultResource());
    }
}
