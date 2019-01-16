package edu.upc.dsa.dao;

import edu.upc.dsa.exceptions.MapNotFoundException;
import edu.upc.dsa.modelos.Map;

import java.util.List;
import java.util.Random;

public class mapDAOimpl implements IMapDAO {
    private static IMapDAO instance;

    private mapDAOimpl(){}

    public static IMapDAO getInstance(){
        if(instance == null){
            instance = new mapDAOimpl();
        }
        return instance;
    }

    @Override
    public void addMapBBDD(Map map) {
        Session session = FactorySession.openSession();
        session.save(map);
        session.close();
    }

    @Override
    public List<Map> getAllMapsBBDD() {
        Session session = FactorySession.openSession();
        List<Map> maps = null;

        try {
            maps = session.findAll(Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return maps;
    }

    public Map getMapBBDD(int id) throws MapNotFoundException {
        Session session = FactorySession.openSession();
        Map map;
        try {
            map = (Map) session.get(Map.class, id);
        } catch (Exception e) {
            throw new MapNotFoundException(e.getMessage());
        } finally {
            session.close();
        }

        return map;
    }

    public Map getRandomMapBBDD() throws MapNotFoundException {
        Session session = FactorySession.openSession();
        Map map;
        int numMaps;
        try {
            numMaps = session.count(Map.class);
            Random rand = new Random();
            int n = rand.nextInt(numMaps);
            map = (Map) session.get(Map.class, n);
        } catch (Exception e) {
            throw new MapNotFoundException(e.getMessage());
        } finally {
            session.close();
        }

        return map;
    }

    public void clear(){
        instance = null;
    }
}
