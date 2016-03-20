package uk.co.bluetel.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DefaultResource {

    /**
     * A basic Resource, this just returns a Response.
     * @return Response
     */
    @GET
    public Response getDefault() {
        return Response.ok("Route Working").build();
    }
}
