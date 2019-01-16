package edu.upc.dsa.dao;

import edu.upc.dsa.exceptions.EnemyNotFoundException;
import edu.upc.dsa.modelos.Enemy;

import java.util.List;

public interface IEnemyDAO {
    void addEnemyBBDD(Enemy enemy);
    List<Enemy> getAllEnemiesBBDD();
    Enemy getEnemyBBDD(int id) throws EnemyNotFoundException;
}
