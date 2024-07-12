package com.store.onlinestore.controller.api;


import com.store.onlinestore.model.service.ProductUnitService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/unit")
public class ProductUnitApi {


    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response findAll() throws Exception {
        return null; //Response.ok().entity(ProductUnitService.getService().findAll()).build();
    }
}
