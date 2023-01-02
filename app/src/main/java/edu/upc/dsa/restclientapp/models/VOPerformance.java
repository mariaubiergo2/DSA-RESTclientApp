package edu.upc.dsa.restclientapp.models;

public class VOPerformance {
    //Como abandonas un nivel. Ejemplo:
    //level: 1, points: 5, date: 05-10-2001
    //Indica que has terminado el nivel 1 el dia 05-10-2001 con 5 puntos
    Integer level;
    Integer points;
    String date;

    public VOPerformance() {
        //this.id = RandomUtils.getId();
    }

    public VOPerformance(Integer level, Integer points, String date) {
        this.setLevel(level);
        this.setPoints(points);
        this.setDate(date);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Performance [ level = "+ level +" puntos = "+ points +", date = " +date+"]";
    }

}