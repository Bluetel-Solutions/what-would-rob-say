package uk.co.bluetel.wwrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class DefaultResource {

    /**
     * Default Route, just to test the Application
     * @return Response
     */
    @GET
    public Response getDefault() {
        return Response.ok("Route Working").build();
    }
}
