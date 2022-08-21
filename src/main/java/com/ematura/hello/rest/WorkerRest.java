package com.ematura.hello.rest;

import com.ematura.hello.entities.Worker;
import com.ematura.hello.services.WorkerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("suppliers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WorkerRest {
    @Inject
    WorkerService service;

    @Path("new")
    @POST
    public Response createWorker(Worker Worker){
        service.createWorker(Worker);
        return Response.ok(Worker).build();
    }

    @Path("{id}")
    @GET
    public Worker getWorker(@PathParam("id") Integer id){
        return service.findWorkerById(id);
    }

    @Path("")
    @GET
    public List<Worker> getAllWorkers(){
        return service.getAllWorkers();
    }
}
