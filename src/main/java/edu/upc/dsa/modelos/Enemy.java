package edu.upc.dsa.modelos;

public class Enemy{

    public Enemy(){

    }
    private int idEnemy;
    private int type;
    private int speed;
    private int damage;

    public Enemy(int idEnemy, int type, int speed, int damage) {
        this.idEnemy = idEnemy;
        this.type = type;
        this.speed = speed;
        this.damage = damage;
    }

    public int getIdEnemy() {
        return idEnemy;
    }

    public void setIdEnemy(int idEnemy) {
        this.idEnemy = idEnemy;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

