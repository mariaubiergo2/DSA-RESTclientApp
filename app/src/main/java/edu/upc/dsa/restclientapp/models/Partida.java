package edu.upc.dsa.restclientapp.models;

//import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    String idpartida;
    String username;
    String namejuego;
    Integer puntos;
    Integer nivelActual;
    List<VOPerformance> performanceList;

    public Partida() {
        //this.id = RandomUtils.getId();
    }

    public Partida(String username, String namejuego) {
        this.idpartida = "1";
        this.setUsername(username);
        this.setNamejuego(namejuego);
        this.setPuntos(50);
        this.setNivelActual(1);
        this.setPerformanceList(new ArrayList<VOPerformance>());
    }


    public String getIdpartida() {
        return idpartida;
    }
    public void setIdpartida(String idpartida) {
        this.idpartida = idpartida;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getNamejuego() {
        return namejuego;
    }
    public void setNamejuego(String juego) {
        this.namejuego = juego;
    }

    public Integer getPuntos() {
        return puntos;
    }
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    public void addPuntos(Integer puntos ) {
        this.puntos = this.puntos + puntos;
    }

    public Integer getNivelActual() {
        return nivelActual;
    }
    public void setNivelActual(Integer nivelActual) {
        this.nivelActual = nivelActual;
    }
    public void sumNivelActual(Integer numerodenivelesquesubes) {this.nivelActual=this.nivelActual+numerodenivelesquesubes; }

    public List<VOPerformance> getPerformanceList() {
        return performanceList;
    }
    public void setPerformanceList(List<VOPerformance> performanceList) {
        this.performanceList = performanceList;
    }
    public void addPerformance(VOPerformance performance){
        this.performanceList.add(performance);
    }

    @Override
    public String toString() {
        return "Partida [ idpartida= "+ idpartida +", iduser = "+username+", juego = " + namejuego + ", puntos = " + puntos+ ", nivel actual = " + nivelActual +"]";
    }

}