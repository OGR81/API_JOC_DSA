package edu.upc.dsa.modelos;

public class ObjectModel {


    private int idObjectModel;
    private String name;
    private int price;

    //Si hacemos un servicio siempre añadir el constructor vacio!!!!
    public ObjectModel() {}
                
    public ObjectModel(int idObject, String name, int price) {
        this.idObjectModel = idObject;
        this.name = name;
        this.price = price;
    }

    public int getIdObjectModel() {
        return idObjectModel;
    }

    public void setIdObjectModel(int idObjectModel) {
        this.idObjectModel = idObjectModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}