package com.ematura.hello.rest;

import com.ematura.hello.entities.Supplier;
import com.ematura.hello.services.SupplierService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("suppliers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SupplierRest {
    @Inject
    SupplierService service;

    @Path("new")
    @POST
    public Response createSupplier(Supplier supplier){
        service.createSupplier(supplier);
        return Response.ok(supplier).build();
    }

    @Path("{id}")
    @GET
    public Supplier getSupplier(@PathParam("id") Integer id){
        return service.findSupplierById(id);
    }

    @Path("")
    @GET
    public List<Supplier> getAllSuppliers(@QueryParam("name") String name, @QueryParam("city") String city){
        if (name != null && city != null){
            return service.filterSuppliers(name, city);
        }
        return service.getAllSuppliers();
    }
}
