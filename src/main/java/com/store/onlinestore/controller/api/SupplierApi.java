package com.store.onlinestore.controller.api;

import com.store.onlinestore.model.service.PersonService;
import com.store.onlinestore.model.service.SupplierService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/supplier")
public class SupplierApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
//        return Response.ok().entity(SupplierService.getService().findAll()).build();
        return null;

    }
}
