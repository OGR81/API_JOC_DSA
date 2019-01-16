package edu.upc.dsa.services;

import edu.upc.dsa.dao.IGameDAO;
import edu.upc.dsa.dao.gameDAOimpl;
import edu.upc.dsa.modelos.Game;
import edu.upc.dsa.modelos.Map;
import edu.upc.dsa.modelos.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class GameService {
    private IGameDAO daoGame;


    public GameService() {
        this.daoGame = gameDAOimpl.getInstance();
    }

    @POST
    @ApiOperation(value="Guardar partida", notes="Guarda la partida del usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Game.class),
            @ApiResponse(code = 404, message = "Game not added to database"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response grabarPartida(Integer userId, Integer level, Integer points, Integer health){
        try{
            this.daoGame = gameDAOimpl.getInstance();
            Game game = this.daoGame.saveGame(userId, level, points, health);
            System.out.println("game guardat");
            return Response.status(200).entity(game).build();
        }catch (Exception e){
            return Response.status(404).build();
        }
    }
}
