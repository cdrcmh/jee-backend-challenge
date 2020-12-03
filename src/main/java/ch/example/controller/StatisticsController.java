package ch.example.controller;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ch.example.service.SingletonEJBLocal;

@Path("/statistics")
public class StatisticsController {

    @EJB
    public SingletonEJBLocal singletonEJB;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStatistics() {
        return Response.ok().entity(singletonEJB.getStatistics().toString()).build();
    }

}
