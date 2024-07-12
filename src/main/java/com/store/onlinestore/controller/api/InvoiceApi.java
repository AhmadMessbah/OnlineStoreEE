package com.store.onlinestore.controller.api;

import com.store.onlinestore.model.service.InvoiceService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/invoices")
public class InvoiceApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
//        return Response.ok().entity(InvoiceService.getService().findAll()).build();
        return null;
    }
}

