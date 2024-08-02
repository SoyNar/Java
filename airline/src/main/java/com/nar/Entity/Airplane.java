package com.nar.Entity;

public class Airplane {
    private int id;
    private String model;
    private int lenght;

    // constructor

    public Airplane() {
    }
public  Airplane(int id){
        this.id = id;
}
    public Airplane( String model, int lenght) {
        this.model = model;
        this.lenght = lenght;
    }

    public Airplane (int id, String model, int lenght){
        this.model = model;
        this.id =id;
        this.lenght = lenght;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }


    @Override
    public String toString() {
        return "id: " + getId() +
                "Model :" + model
                + "capacity: " + lenght;
    }
}
