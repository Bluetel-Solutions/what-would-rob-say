package uk.co.bluetel.templates;

import uk.co.bluetel.core.Template;
import com.google.common.base.Optional;

public class HealthCheck extends com.yammer.metrics.core.HealthCheck {

    private final Template template;

    public HealthCheck(Template template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        template.render(Optional.of("woo"));
        template.render(Optional.<String>absent());
        return Result.healthy();
    }
}
