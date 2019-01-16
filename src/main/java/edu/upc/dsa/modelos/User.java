package edu.upc.dsa.modelos;

public class User {

    private int idUser;
    private String mail;
    private String password;

    //Si hacemos un servicio siempre añadir el constructor vacio!!!!
    public User() {
    }

    public User(int idUser, String mail, String password) {
        this.idUser = idUser;
        this.mail = mail;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
