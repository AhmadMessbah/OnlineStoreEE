package com.store.onlinestore.controller.api;

import com.store.onlinestore.model.service.InventoryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/inventory")
public class InventoryApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
//        return Response.ok().entity(InventoryService.getService().findAll()).build();
        return null;
    }
}
