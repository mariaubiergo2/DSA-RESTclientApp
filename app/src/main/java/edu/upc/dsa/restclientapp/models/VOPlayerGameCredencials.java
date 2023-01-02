package edu.upc.dsa.restclientapp.models;

public class VOPlayerGameCredencials {
    String namejuego;
    String username;

    public VOPlayerGameCredencials() {
        //this.id = RandomUtils.getId();
    }

    public VOPlayerGameCredencials(String namejuego, String username) {
        this.setNamejuego(namejuego);
        this.setUsername(username);
    }

    public String getNamejuego() {
        return namejuego;
    }

    public void setNamejuego(String namejuego) {
        this.namejuego = namejuego;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}