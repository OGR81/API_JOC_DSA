package edu.upc.dsa.dao;

import edu.upc.dsa.modelos.Game;
import edu.upc.dsa.modelos.Map;

import java.util.ArrayList;
import java.util.List;

public class gameDAOimpl implements IGameDAO {

    private static IGameDAO instance;

    private gameDAOimpl(){}

    public static IGameDAO getInstance(){
        if(instance == null){
            instance = new gameDAOimpl();
        }
        return instance;
    }

    @Override
    public Game saveGame(Integer userId, Integer level, Integer points, Integer health) throws Exception{
        Session session = FactorySession.openSession();
        Game game = new Game();
        game.setIdUser(userId);
        game.setLevel(level);
        game.setPoints(points);
        game.setHealth(health);

        //Todo guardar en tabla position?
        try {
            session.save(game);
        }
        catch (Exception e) {
            throw new Exception();
        }
        finally {
            session.close();
        }

        return game;
    }


    @Override
    public Game getGameById(Integer id) throws Exception {
        Session session = FactorySession.openSession();
        Game game;
        try {
            game = (Game)session.get(Game.class, id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }

        return game;
    }

    @Override
    public List<Game> getGames(Integer userId) throws Exception {
        Session session = FactorySession.openSession();
        List<Game> games = new ArrayList<>();
        try {
            //Todo obtener todos las partidas de un usuario.
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
        return games;
    }
}
