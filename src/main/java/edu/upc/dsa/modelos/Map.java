package edu.upc.dsa.modelos;

public class Map {

    public Map(){}

    private int idMap;
    private int numRows;
    private int numColumns;
    private int numObjects;
    private int numEnemies;



    //private HashMap<Integer, Enemy> mapEnemies;
    //private HashMap<Integer, ObjectModel> mapObjects;


    public Map(int idMap, int numRows, int numColumns, int numObjects, int numEnemies) {
        this.idMap = idMap;
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.numObjects = numObjects;
        this.numEnemies = numEnemies;
    }

    public int getIdMap() {
        return idMap;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    public int getNumObjects() {
        return numObjects;
    }

    public void setNumObjects(int numObjects) {
        this.numObjects = numObjects;
    }

    public int getNumEnemies() {
        return numEnemies;
    }

    public void setNumEnemies(int numEnemies) {
        this.numEnemies = numEnemies;
    }

    @Override
    public String toString() {
        return "Map{" +
                "numColumns=" + numColumns +
                ", idMap=" + idMap +
                ", numObjects=" + numObjects +
                ", numRows=" + numRows +
                ", numEnemies=" + numEnemies +
                '}';
    }
}