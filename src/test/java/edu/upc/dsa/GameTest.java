package edu.upc.dsa;

import edu.upc.dsa.dao.IGameDAO;
import edu.upc.dsa.dao.gameDAOimpl;
import edu.upc.dsa.modelos.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private IGameDAO dao;

    @Before
    public void setUp() throws Exception{
        this.dao = gameDAOimpl.getInstance();
    }

    @Test
    public void TestSaveGame() throws Exception{
        Game game = this.dao.saveGame(1,2,25,5);
        Assert.assertNotNull(game);
    }

    @Test
    public void TestGetGame() throws Exception {

    }
}
