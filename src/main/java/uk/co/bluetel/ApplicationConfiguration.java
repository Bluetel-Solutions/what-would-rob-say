package uk.co.bluetel;

import uk.co.bluetel.core.Template;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ApplicationConfiguration extends Configuration {

    /**
     * Template name
     */
    @NotEmpty
    private String template;

    /**
     * The Default Template name
     */
    @NotEmpty
    private String defaultName = "Default";

    /**
     * Database Configuration, taking from the configuration.yml file
     */
    @Valid
    @NotNull
    @JsonProperty("database")
    private DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();

    /**
     * Returns the current template name
     * @return String
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Sets the current template name
     * @param template
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * Returns the default template name
     * @return String
     */
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * Sets the Default template name
     * @param defaultName
     */
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    /**
     * Builds the current template
     * @return Template
     */
    public Template buildTemplate() {
        return new Template(template, defaultName);
    }

    /**
     * Returns the Database configuration, taken from the yml configuration file
     * @return DatabaseConfiguration
     */
    public DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }

    /**
     * Overrides the database config
     * @param databaseConfiguration
     */
    public void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }
}
