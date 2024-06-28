package com.store.onlinestore.controller.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/role")

public class RoleApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        return Response.ok().entity(RoleService.getService().findAll()).build();
    }
}
