package com.ematura.hello.rest;

import com.ematura.hello.entities.Certificate;
import com.ematura.hello.services.CertificateService;
import com.ematura.hello.services.CertificateService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("certificates")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CertificateRest {
    @Inject
    CertificateService service;

    @Path("new")
    @POST
    public Response createCertificate(Certificate certificate){
        service.createCertificate(certificate);
        return Response.ok(certificate).build();
    }

    @Path("{id}")
    @GET
    public Certificate getCertificate(@PathParam("id") Integer id){
        return service.findCertificateById(id);
    }

    @Path("{id}")
    @DELETE
    public Response deleteCertificate(@PathParam("id") Integer id){
        service.deleteCertificate(id);
        return Response.noContent().build();
    }

    @Path("")
    @GET
    public List<Certificate> getAllCertificates(){
        return service.getAllCertificates();
    }
}
