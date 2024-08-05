package com.riwi.Entitys;

public class Empresa {
    private int id;
    private String ubicacion;
    private String name;

    // constructor

    public Empresa(String name, String ubicacion){
        this.name = name;
        this.ubicacion = ubicacion;
    }

    public Empresa(String name, int id){
        this.id = id;
        this.name = name;
    }

    public Empresa(int id, String ubicacion, String name) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.name = name;
    }

    public Empresa() {

    }

    // getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " name:" + name +
                " ubicacion : " + ubicacion;
    }
}
