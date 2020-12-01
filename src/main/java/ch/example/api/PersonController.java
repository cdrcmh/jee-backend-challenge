package ch.example.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonController {

    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPerson() {
        return Response.ok().entity(null).build();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_XML)
    public Response addPersons(Persons persons) {
        return Response.ok().build();
    }

}
