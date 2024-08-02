package com.nar.Entity;

public class Traveler {
    private int id;
    private String name;
    private String lastName;
    private int idNumber;

    //Constructor


    public Traveler() {

    }

    public Traveler(String name, String lastName, int idNumber) {
        this.name = name;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }
// getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return  " id: " + id +
                " name:" + name +
                " lastname: " + lastName +
                " CC : " +  idNumber;
    }
}
