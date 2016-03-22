package uk.co.bluetel.wwrs;

import org.junit.ClassRule;
import org.junit.Test;
import io.dropwizard.client.JerseyClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.ResourceHelpers;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultResourceTest {

    @ClassRule
    public static final DropwizardAppRule<ApplicationConfiguration> RULE =
            new DropwizardAppRule<ApplicationConfiguration>
                    (ApplicationService.class, ResourceHelpers.resourceFilePath("config.yml"));

    @Test
    public void itShouldReturnAnOkResponseOnGET()
    {
        Client client = new JerseyClientBuilder(RULE.getEnvironment()).build("test client");

        Response response = client.target(
                String.format("http://localhost:%d/", RULE.getLocalPort()))
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }
}
