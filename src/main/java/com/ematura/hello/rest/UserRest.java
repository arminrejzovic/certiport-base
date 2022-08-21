package com.ematura.hello.rest;

import com.ematura.hello.entities.User;
import com.ematura.hello.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("suppliers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRest {
    @Inject
    UserService service;

    @Path("new")
    @POST
    public Response createUser(User User){
        service.createUser(User);
        return Response.ok(User).build();
    }

    @Path("{id}")
    @GET
    public User getUser(@PathParam("id") Integer id){
        return service.findUserById(id);
    }

    @Path("")
    @GET
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
}
