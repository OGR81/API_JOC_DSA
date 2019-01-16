package edu.upc.dsa.dao;

import edu.upc.dsa.exceptions.ObjectNotFoundException;
import edu.upc.dsa.modelos.ObjectModel;

import java.util.List;

public interface IObjectModelDAO {
    void addObjectBBDD(ObjectModel object);
    List<ObjectModel> getAllObjectsBBDD();
    ObjectModel getObjectBBDD(int id) throws ObjectNotFoundException;
}
