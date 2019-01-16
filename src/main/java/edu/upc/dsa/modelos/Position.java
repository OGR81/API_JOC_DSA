package edu.upc.dsa.modelos;

public class Position {
    
    private int idPosition;
    private int x;
    private int y;
    private int idGame;
    private int idMap;
    private int idEnemy;
    private int idObject;


    //Si hacemos un servicio siempre añadir el constructor vacio!!!!
    public Position() {}

    public Position(int idPosition, int x, int y, int idGame, int idMap, int idEnemy, int idObject) {
        this.idPosition = idPosition;
        this.x = x;
        this.y = y;
        this.idGame = idGame;
        this.idMap = idMap;
        this.idEnemy = idEnemy;
        this.idObject = idObject;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdMap() {
        return idMap;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public int getIdEnemy() {
        return idEnemy;
    }

    public void setIdEnemy(int idEnemy) {
        this.idEnemy = idEnemy;
    }

    public int getIdObject() {
        return idObject;
    }

    public void setIdObject(int idObject) {
        this.idObject = idObject;
    }
}