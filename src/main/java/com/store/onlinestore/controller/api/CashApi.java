package com.store.onlinestore.controller.api;

import com.store.onlinestore.model.service.CashService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cash")

public class CashApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        return Response.ok().entity(CashService.getService().findAll()).build();
    }
}
