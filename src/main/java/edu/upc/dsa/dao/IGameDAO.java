package edu.upc.dsa.dao;

import edu.upc.dsa.modelos.Game;
import edu.upc.dsa.modelos.Map;

import java.util.List;

public interface IGameDAO {
    Game saveGame(Integer userId, Integer level, Integer points, Integer health) throws Exception;
    Game getGameById(Integer id) throws Exception;
    List<Game> getGames(Integer userId) throws Exception;
}
