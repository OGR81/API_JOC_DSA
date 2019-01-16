package edu.upc.dsa.services;

import edu.upc.dsa.dao.IMapDAO;
import edu.upc.dsa.dao.mapDAOimpl;
import edu.upc.dsa.exceptions.MapNotFoundException;
import edu.upc.dsa.modelos.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/maps", description = "Endpoint to Map Service")
@Path("/maps")
public class MapService {

    private IMapDAO daoMap;

    public MapService() {
        this.daoMap = mapDAOimpl.getInstance();
    }
    
    //Get un map
    @GET
    @ApiOperation(value = "Get de un map", notes = "Get de un map pasando una id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Map.class),
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMap(@PathParam("id") int id) throws MapNotFoundException {
        Map map = daoMap.getMapBBDD(id);
        return Response.status(200).entity(map).build();
    }

    @POST
    @ApiOperation(value = "crear un map", notes = "post de un map pasando un Map")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Map.class),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMap(Map map) {

        daoMap.addMapBBDD(map);
        return Response.status(201).build();
    }

    //Get all maps
    @GET
    @ApiOperation(value = "Get de todos los maps", notes = "Get de todos los maps")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Map.class)
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMaps() {
        List<Map> maps = daoMap.getAllMapsBBDD();
        return Response.status(200).entity(maps).build();
    }

}