package com.nar.Entity;

public class Reservation {
    private int id;
    private int seatNumber;
    private int flightId;
    private int travlerId;

    // constructor

    public Reservation() {

    }

    public Reservation( int seatNumber, int flightId, int travlerId) {
        this.seatNumber = seatNumber;
        this.flightId = flightId;
        this.travlerId = travlerId;
    }
    public Reservation(int id, int seatNumber, int flightId, int travlerId){
        this.id = id;
        this.seatNumber = seatNumber;
        this.flightId = flightId;
        this.travlerId = travlerId;
    }
    // getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getTravlerId() {
        return travlerId;
    }

    public void setTravlerId(int travlerId) {
        this.travlerId = travlerId;
    }

    @Override
    public String toString() {

        return   "id:" + id +
                " Number seat: " + seatNumber +
                " flight number : " + flightId +
                " Traveler number :" + travlerId;
    }
}
