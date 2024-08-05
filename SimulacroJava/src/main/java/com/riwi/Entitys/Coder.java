package com.riwi.Entitys;

public class Coder {

    private int id;
    private String name;
    private  String lastname;
    private String clan;
    private String tecnology;
    private String cohorte;
    private String idDocument;

    // constructor

    public Coder(String name, String lastname, String clan, String tecnology, String cohorte, String idDocument) {
        this.name = name;
        this.lastname = lastname;
        this.clan = clan;
        this.tecnology = tecnology;
        this.cohorte = cohorte;
        this.idDocument = idDocument;
    }

    public  Coder (){}



    //setter and getters


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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getTecnology() {
        return tecnology;
    }

    public void setTecnology(String tecnology) {
        this.tecnology = tecnology;
    }

    public String getCohorte() {
        return cohorte;
    }

    public void setCohorte(String cohorte) {
        this.cohorte = cohorte;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    @Override
    public String toString() {
        return   "id : " + id +
                "name :" +name +
                " Lastname :" + lastname +
                " clan : " + clan +
                " tecnologia :" + tecnology +
                " cohorte :" + cohorte +
                " Documento: " + idDocument;

    }
}
