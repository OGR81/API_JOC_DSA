package edu.upc.dsa.dao;

import edu.upc.dsa.exceptions.EnemyNotFoundException;
import edu.upc.dsa.modelos.Enemy;

import java.util.List;

public class enemyDAOImpl implements IEnemyDAO {
    private static IEnemyDAO instance;

    private enemyDAOImpl(){}

    public static IEnemyDAO getInstance(){
        if(instance == null){
            instance = new enemyDAOImpl();
        }
        return instance;
    }

    @Override
    public void addEnemyBBDD(Enemy enemy) {
        Session session = FactorySession.openSession();
        session.save(enemy);
        session.close();
    }

    @Override
    public List<Enemy> getAllEnemiesBBDD() {
        Session session = FactorySession.openSession();
        List<Enemy> enemies = null;

        try {
            enemies = session.findAll(Enemy.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return enemies;
    }

    public Enemy getEnemyBBDD(int id) throws EnemyNotFoundException {
        Session session = FactorySession.openSession();
        Enemy enemy;
        try {
            enemy = (Enemy) session.get(Enemy.class, id);
        } catch (Exception e) {
            throw new EnemyNotFoundException(e.getMessage());
        } finally {
            session.close();
        }

        return enemy;
    }

    public void clear(){
        instance = null;
    }
}