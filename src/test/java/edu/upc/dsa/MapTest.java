package edu.upc.dsa;

import edu.upc.dsa.dao.IMapDAO;
import edu.upc.dsa.dao.mapDAOimpl;
import edu.upc.dsa.exceptions.MapNotFoundException;
import edu.upc.dsa.modelos.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MapTest {

    private IMapDAO dao;

    @Before
    public void setUp() throws Exception {
        this.dao = mapDAOimpl.getInstance();
    }

    @Test
    public void AddMap() throws MapNotFoundException {
        Map map = new Map(0, 10, 10, 4, 2);
        dao.addMapBBDD(map);
        Map map1 = dao.getMapBBDD(3);
        Assert.assertNotNull(map);
        Assert.assertEquals(10, map1.getNumRows());
        Assert.assertEquals(10, map1.getNumColumns());
        Assert.assertEquals(4, map1.getNumObjects());
        Assert.assertEquals(2, map1.getNumEnemies());
    }

    @Test
    public void GetAllMaps() {
        List<Map> maps = this.dao.getAllMapsBBDD();
        Assert.assertFalse(maps.isEmpty());
    }

    @Test
    public void GetMap() throws MapNotFoundException {
        Map map = this.dao.getMapBBDD(0);
        Assert.assertNull(map);
        map = this.dao.getMapBBDD(1);
        Assert.assertNotNull(map);
        Assert.assertEquals(20, map.getNumRows());
    }

    @Test
    public void GetRandomMap() throws MapNotFoundException {
        this.dao = mapDAOimpl.getInstance();
        Map map = this.dao.getRandomMapBBDD();
        Assert.assertNotNull(map);
        Assert.assertTrue(map.getIdMap() != 0);
    }

}
