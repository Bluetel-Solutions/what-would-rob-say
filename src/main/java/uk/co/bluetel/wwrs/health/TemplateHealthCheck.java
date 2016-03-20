package uk.co.bluetel.wwrs.health;

import com.codahale.metrics.health.HealthCheck;

import javax.xml.transform.Result;

public class TemplateHealthCheck extends HealthCheck {

    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "NOTFOUND");
        if (!saying.contains("NOTFOUND")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
