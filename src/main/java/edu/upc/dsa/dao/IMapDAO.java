package edu.upc.dsa.dao;

import edu.upc.dsa.exceptions.MapNotFoundException;
import edu.upc.dsa.modelos.Map;

import java.util.List;

public interface IMapDAO {
    void addMapBBDD(Map map);
    List<Map> getAllMapsBBDD();
    Map getMapBBDD(int id) throws MapNotFoundException;
    Map getRandomMapBBDD() throws MapNotFoundException;
}
