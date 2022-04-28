package edu.upc.dsa.services;

import edu.upc.dsa.GameManager;
import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/joc", description = "Endpoint to Game Service")
@Path("/usuers")

public class GameService {
    private GameManager manager;

    public GameService() {}

    // GET llista usuaris
    @GET
    @ApiOperation(value = "llista usuaris", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/userList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserList() {
        List<User> u = this.manager.getUsersList();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(u) {};
        return Response.status(201).entity(entity).build();
    }

    // POST -> add user
    @POST
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(User user) {

        if (user.getName()==null || user.getId() == null)
            return Response.status(500).entity(user).build();
        this.manager.addUser(user);
        return Response.status(201).entity(user).build();
    }

    // GET -> consultar usuari
    @GET
    @ApiOperation(value = "consultar Usuari", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/consultUser/{User}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarUsuari(@PathParam("User") User u) {
        if (u == null)
            return Response.status(404).build();
        else
            return Response.status(201).entity(u).build();
    }

    // GET llista users per punt
    @GET
    @ApiOperation(value = "llista Usuaris per un PI", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/listUserPerPoint")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListUserPerPoint(@PathParam("punt") PuntoInteres punto) {
        List<User> l = manager.listaUsersEnPunto(punto);
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(l) {};
        return Response.status(201).entity(entity).build();
    }

    // GET llista usuaris segons punts
    @GET
    @ApiOperation(value = "llista Usuaris segons punts creuats", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List" ),
    })
    @Path("/listUsersSegonsPunts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response llistaUsuarisPIsCreuats() {
        List<User> l = this.manager.listaUsersPorPuntos();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(l) {};
        return Response.status(201).entity(entity).build();
    }
}
