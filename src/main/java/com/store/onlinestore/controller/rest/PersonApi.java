package com.store.onlinestore.controller.rest;

import com.store.onlinestore.model.entity.Person;
import com.store.onlinestore.model.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/person")
public class PersonApi {
    @Inject
    private PersonService personService;

    @PUT
    // media type convert error
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editPerson(Person person) {
        try {
            System.out.println("PERSON API EDIT : " + person.toString());

            personService.edit(person);
            return Response.ok().entity("salam").build();
        }catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        try {
            System.out.println("PERSON API DELETE : " + id);
            personService.remove(id);
            return Response.accepted().build();
        }catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
