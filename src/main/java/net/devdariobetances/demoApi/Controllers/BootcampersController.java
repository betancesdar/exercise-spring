package net.devdariobetances.demoApi.Controllers;


import net.devdariobetances.demoApi.Models.Bootcamper;
import net.devdariobetances.demoApi.services.BootcamperService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class BootcampersController {

    private BootcamperService bootcamperService;


    public BootcampersController(BootcamperService bootcamperService){
        this.bootcamperService = bootcamperService;

        this.bootcamperService.add(new Bootcamper("Alex"));
        this.bootcamperService.add(new Bootcamper("Andy"));
        this.bootcamperService.add(new Bootcamper("Koki"));
        this.bootcamperService.add(new Bootcamper("Mary"));
        this.bootcamperService.add(new Bootcamper("Elena"));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listAll(){
        return bootcamperService.getAll();
    }
    @GET
    @Path("/bootcampers/{name}")
    @Produces("application/json")
    public Bootcamper getBootcamper(@PathParam("name") String name){
        return bootcamperService.getBootcamper(name);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addBootcamper(Bootcamper bootcamper){
        bootcamperService.add(bootcamper);
        return Response.created(
                URI.create("/bootcampers" + bootcamper.getName())
        ).build();
    }



}
