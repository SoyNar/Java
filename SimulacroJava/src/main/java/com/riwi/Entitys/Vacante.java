package com.riwi.Entitys;

import com.riwi.Persistence.Until.Estado;

public class Vacante {

    private int id;
    private String titulo;
    private Estado status;
    private double salario;
    private String  descripcion;
    private String tecnologia;
    private int empresaID;

    // constructor


    public Vacante(int id, String titulo, Estado status, double salario, String descripcion, String tecnologia, int empresaID) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.salario = salario;
        this.descripcion = descripcion;
        this.tecnologia = tecnologia;
        this.empresaID = empresaID;
    }

    public Vacante(String titulo, Estado status, double salario, String descripcion, String tecnologia, int empresaID) {
        this.titulo = titulo;
        this.status = status;
        this.salario = salario;
        this.descripcion = descripcion;
        this.tecnologia = tecnologia;
        this.empresaID = empresaID;
    }

    public Vacante(){}

    // getter and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Estado getStatus() {
        return status;
    }

    public void setStatus(Estado status) {
        this.status = status;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getEmpresaID() {
        return empresaID;
    }

    public void setEmpresaID(int empresaID) {
        this.empresaID = empresaID;
    }

    @Override
    public String toString() {
        return "id : " + id +
                " titulo :" + titulo +
                " estado: " + status +
                " Salario:" + salario +
                " Descripcion: " + descripcion +
                " Tecnologia: " + tecnologia +
                " Empresa id:" + empresaID;
    }
}

