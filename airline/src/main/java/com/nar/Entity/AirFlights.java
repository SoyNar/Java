package com.nar.Entity;



public class AirFlights {
    private int id;
    private String destination;
    private String date;
    private String time;
    private int flight_id;

    // constructor

    public AirFlights(String destination, String date, String time, int flight_id) {
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.flight_id = flight_id;
    }

    public AirFlights( ){

    }

    public AirFlights(int id, String destination, String date, String time, int flight_id) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.flight_id = flight_id;
    }

    //getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    @Override
    public String toString() {
        return "id:" + id +
                " Destination:" + destination +
                " Date :" + date +
                " Time: " + time +
                " id_airplane: " + flight_id;
    }
}
