package uk.co.bluetel.wwrs;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ApplicationConfiguration extends Configuration {

    /**
     * The Template Name
     */
    @NotEmpty
    private String template;

    /**
     * The Default Template Name
     */
    @NotEmpty
    private String defaultName = "Default";

    /**
     * Returns the Template name
     * @return String
     */
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    /**
     * Sets the Template name
     * @param template
     */
    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * Returns the Default Name
     * @return String
     */
    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * Sets the Default Name
     * @param name
     */
    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}
