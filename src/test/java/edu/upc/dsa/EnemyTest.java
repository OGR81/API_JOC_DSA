package edu.upc.dsa;

import edu.upc.dsa.dao.IEnemyDAO;
import edu.upc.dsa.dao.enemyDAOImpl;
import edu.upc.dsa.exceptions.EnemyNotFoundException;
import edu.upc.dsa.modelos.Enemy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EnemyTest {

    private IEnemyDAO dao;

    @Before
    public void setUp() throws Exception {
        this.dao = enemyDAOImpl.getInstance();
    }

    @Test
    public void AddEnemy() throws EnemyNotFoundException {
        Enemy enemy = new Enemy(0, 1, 12, 40);
        dao.addEnemyBBDD(enemy);

        List<Enemy> all = dao.getAllEnemiesBBDD();
        Enemy enemy1 = dao.getEnemyBBDD(all.size());
        Assert.assertNotNull(enemy);
        Assert.assertEquals(1, enemy1.getType());
        Assert.assertEquals(12, enemy1.getSpeed());
        Assert.assertEquals(40, enemy1.getDamage());
    }

    @Test
    public void GetAllEnemies() {
        List<Enemy> enemies = this.dao.getAllEnemiesBBDD();
        Assert.assertNotNull(enemies);
        Assert.assertFalse(enemies.isEmpty());
    }

    @Test
    public void GetEnemy() throws EnemyNotFoundException {
        Enemy enemy = this.dao.getEnemyBBDD(1);
        Assert.assertNotNull(enemy);
        Assert.assertEquals(60, enemy.getDamage());
    }
}
