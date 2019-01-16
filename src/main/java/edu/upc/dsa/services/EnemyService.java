package edu.upc.dsa.services;

import edu.upc.dsa.controladores.GameManagerImpl;
import edu.upc.dsa.dao.IEnemyDAO;
import edu.upc.dsa.exceptions.EnemyNotFoundException;
import edu.upc.dsa.modelos.Enemy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/enemies", description = "Endpoint to Enemy Service")
@Path("/enemy")
public class EnemyService {
    private GameManagerImpl gm;

    private IEnemyDAO daoEnemy;


    public EnemyService() {
        this.gm = GameManagerImpl.getInstance();
    }

    //Get un map
    @GET
    @ApiOperation(value = "Get de un enemy", notes = "Get de un enemy pasando una id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Enemy.class),
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMap(@PathParam("id") int id) throws EnemyNotFoundException {
        Enemy enemy = daoEnemy.getEnemyBBDD(id);
        return Response.status(200).entity(enemy).build();
    }


    //Get all maps
    @GET
    @ApiOperation(value = "Get de todos los maps", notes = "Get de todos los maps")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Enemy.class)
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMaps() {
        List<Enemy> enemies = daoEnemy.getAllEnemiesBBDD();
        return Response.status(200).entity(enemies).build();
    }

    @POST
    @ApiOperation(value = "añadir un enemigo", notes = "post de un enemigo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Enemy.class),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postEnemy(Enemy enemy) {
        daoEnemy.addEnemyBBDD(enemy);
        return Response.status(201).build();
    }
}