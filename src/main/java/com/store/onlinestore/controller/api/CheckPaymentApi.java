package com.store.onlinestore.controller.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;

@Path("/check")

public class CheckPaymentApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        return null;
    }
}
