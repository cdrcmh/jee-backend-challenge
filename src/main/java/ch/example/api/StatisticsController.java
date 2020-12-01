package ch.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/statistics")
public class StatisticsController {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getStatistics() {
        return Response.ok().entity(null).build();
    }

}
