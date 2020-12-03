package ch.example.controller;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.net.URI;

import ch.example.model.Event;
import ch.example.model.Persons;
import ch.example.service.SingletonEJBLocal;
import ch.example.util.XMLValidation;

@Path("/person")
public class PersonController {

    @EJB
    public SingletonEJBLocal singletonEJB;

    @GET
    @Produces(MediaType.TEXT_XML)
    public Response getPersons() {
        return Response.ok().entity(singletonEJB.getPersons()).build();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_XML)
    public Response addPersons(String p) {
        if (XMLValidation.validateXMLSchema(p)) {
            Persons persons = JAXB.unmarshal(new StringReader(p), Persons.class);
            singletonEJB.addPerson(persons.getPerson());
            return Response.created(URI.create("")).build(); // cannot return unique ressource id on bulk add
        } else {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "XML validation failed.").build();
        }
    }

}
