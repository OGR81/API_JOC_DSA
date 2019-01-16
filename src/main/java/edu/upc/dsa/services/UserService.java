package edu.upc.dsa.services;

import edu.upc.dsa.dao.IUserDAO;
import edu.upc.dsa.dao.userDAOimpl;
import edu.upc.dsa.exceptions.UserNotAddedException;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.modelos.Credentials;
import edu.upc.dsa.modelos.Game;
import edu.upc.dsa.modelos.Map;
import edu.upc.dsa.modelos.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/users", description = "Endpoint to User Service")
@Path("/users")
public class UserService {

    private IUserDAO daoUser;


    public UserService() {
        this.daoUser = userDAOimpl.getInstance();
    }

    
    //Añadir un user
    @POST
    @ApiOperation(value = "Post user", notes = "Añade un user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= User.class),
            @ApiResponse(code = 404, message = "User not added to database"),
    })
    @Path("/registro")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    //
    public Response newUser(Credentials cred) {
        try{
            System.out.println(cred.getMail()+ " "+cred.getPassword());

            this.daoUser = userDAOimpl.getInstance();
            User user = this.daoUser.registro(cred.getMail(), cred.getPassword());
            System.out.println("user creat!!!!");
            return Response.status(200).entity(user).build();
        }catch (UserNotAddedException e) {
            return Response.status(404).build();
        }
    }

    //Logear un user
    @POST
    @ApiOperation(value = "Logear user", notes = "Logea un user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= User.class),
            @ApiResponse(code = 404, message = "User not added to database"),
    })
    @Path("/login/{mail}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("mail") String mail, @PathParam("password") String password) {
        try{
            this.daoUser = userDAOimpl.getInstance();
            User user = this.daoUser.login(mail,password);
            return Response.status(201).entity(user).build();
        }catch (UserNotFoundException e) {
            return Response.status(404).build();
        }
    }
}