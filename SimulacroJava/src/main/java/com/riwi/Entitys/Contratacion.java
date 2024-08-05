package com.riwi.Entitys;

public class Contratacion {
    private  int id;
    private int coderId;
    private int vacanteId;

    // constructor

    public Contratacion(){}

    public Contratacion(int coderId, int vacanteId) {
        this.coderId = coderId;
        this.vacanteId = vacanteId;
    }

    public Contratacion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoderId() {
        return coderId;
    }

    public void setCoderId(int coderId) {
        this.coderId = coderId;
    }

    public int getVacanteId() {
        return vacanteId;
    }

    public void setVacanteId(int vacanteId) {
        this.vacanteId = vacanteId;
    }
}
