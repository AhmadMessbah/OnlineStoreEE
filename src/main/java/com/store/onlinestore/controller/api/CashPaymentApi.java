package com.store.onlinestore.controller.api;

import com.store.onlinestore.model.service.CashPaymentService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cash")

public class CashPaymentApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        return Response.ok().entity(CashPaymentService.getService().findAll()).build();
    }
}
