package edu.upc.dsa.modelos;

import java.util.Date;
import java.util.HashMap;

/*
 */

public class Game {
    private int idGame;
    private int user_idUser;
    private int level;
    private int points;
    private int health;
    private Date dateHour;


    //Si hacemos un servicio siempre añadir el constructor vacio!!!!
    public Game() {
    }

    public Game(int idGame, int idUser, int level, int points,  int health,
                Date dateHour) {
        this.idGame = idGame;
        this.user_idUser = idUser;
        this.health = health;
        this.points = points;
        this.level = level;
        this.dateHour = dateHour;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdUser() {
        return user_idUser;
    }

    public void setIdUser(int idUser) {
        this.user_idUser = idUser;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getHour() {
        return dateHour;
    }

    public void setHour(Date dateHour) {
        this.dateHour = dateHour;
    }



}
