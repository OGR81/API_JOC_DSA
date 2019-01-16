package edu.upc.dsa.dao;

import edu.upc.dsa.exceptions.ObjectNotFoundException;
import edu.upc.dsa.modelos.ObjectModel;

import java.util.List;

public class objectModelDAOImpl implements IObjectModelDAO {
    private static IObjectModelDAO instance;

    private objectModelDAOImpl(){}

    public static IObjectModelDAO getInstance(){
        if(instance == null){
            instance = new objectModelDAOImpl();
        }
        return instance;
    }

    @Override
    public void addObjectBBDD(ObjectModel object) {
        Session session = FactorySession.openSession();
        session.save(object);
        session.close();
    }

    @Override
    public List<ObjectModel> getAllObjectsBBDD() {
        Session session = FactorySession.openSession();
        List<ObjectModel> objects = null;

        try {
            objects = session.findAll(ObjectModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return objects;
    }

    public ObjectModel getObjectBBDD(int id) throws ObjectNotFoundException {
        Session session = FactorySession.openSession();
        ObjectModel object;
        try {
            object = (ObjectModel) session.get(ObjectModel.class, id);
        } catch (Exception e) {
            throw new ObjectNotFoundException(e.getMessage());
        } finally {
            session.close();
        }

        return object;
    }

    public void clear(){
        instance = null;
    }
}