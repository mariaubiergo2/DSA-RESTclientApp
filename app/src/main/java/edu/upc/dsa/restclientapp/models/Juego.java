package edu.upc.dsa.restclientapp.models;

public class Juego {
    String namejuego;
    String descripcio;
    Integer numniveles;

    public Juego() {    }

    public Juego(String namejuego, String description, int num) {
        this();
        this.setDescripcio(description);
        this.setNamejuego(namejuego);
        this.setNumniveles(num);
    }

    public String getNamejuego() {
        return namejuego;
    }

    public void setNamejuego(String namejuego) {
        this.namejuego = namejuego;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Integer getNumniveles() {
        return numniveles;
    }

    public void setNumniveles(Integer numniveles) {
        this.numniveles = numniveles;
    }

    @Override
    public String toString() {
        return "Juego [name = " + namejuego + ", description = " + descripcio +", niveles = " + numniveles +"]";
    }
}