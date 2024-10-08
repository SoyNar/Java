package com.projects.Entity;

public class Authors {
    // attributes
    private int id;
    private String name;
    private String nationality;


    // constructors

    public Authors(){}
    public Authors( String name, String nationality){
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public Authors(int id){
        this.id = id;
    }

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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
