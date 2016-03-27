package uk.co.bluetel.wwrs;

import javax.annotation.security.RolesAllowed;
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
    @RolesAllowed("Basic")
    public Response getDefault() {
        return Response.ok("Hello normal user!").build();
    }

    /**
     * Resource only available for the admin.
     * @return
     */
    @GET
    @Path("/admin")
    @RolesAllowed("Admin")
    public Response getAdmin(){return Response.ok("Hello Admin!").build();}
}
