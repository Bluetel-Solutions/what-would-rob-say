package uk.co.bluetel.core;

import com.google.common.base.Optional;

import static java.lang.String.format;

public class Template {
    /**
     * String representation of the content
     */
    private final String content;

    /**
     * Default template name string
     */
    private final String defaultName;

    /**
     * Construct, sets up dependencies
     * @param content
     * @param defaultName
     */
    public Template(String content, String defaultName) {
        this.content = content;
        this.defaultName = defaultName;
    }

    /**
     * Renders the current template
     * @param name
     * @return The rendered content
     */
    public String render(Optional<String> name) {
        return format(content, name.or(defaultName));
    }
}
