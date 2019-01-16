package edu.upc.dsa;

import edu.upc.dsa.dao.IObjectModelDAO;
import edu.upc.dsa.dao.objectModelDAOImpl;
import edu.upc.dsa.exceptions.ObjectNotFoundException;
import edu.upc.dsa.modelos.ObjectModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ObjectModelTest {

    private IObjectModelDAO dao;

    @Before
    public void setUp() throws Exception {
        this.dao = objectModelDAOImpl.getInstance();
    }

    @Test
    public void AddObject() throws ObjectNotFoundException {

        ObjectModel object = new ObjectModel(0, "Espada", 10);
        dao.addObjectBBDD(object);

        List<ObjectModel> all = dao.getAllObjectsBBDD();
        Assert.assertNotNull(all);
        Assert.assertFalse(all.isEmpty());

        ObjectModel t = dao.getObjectBBDD(all.size());
        Assert.assertNotNull(t);
        Assert.assertEquals(10, t.getPrice());
        Assert.assertEquals("Espada", t.getName());
    }

    @Test
    public void GetAllObjects() {
        List<ObjectModel> objects = this.dao.getAllObjectsBBDD();
        Assert.assertNotNull(objects);
        Assert.assertFalse(objects.isEmpty());
    }

    @Test
    public void GetObject() throws ObjectNotFoundException {
        ObjectModel object  = this.dao.getObjectBBDD(2);
        Assert.assertNotNull(object);
        Assert.assertEquals(3, object.getPrice());
    }
}
