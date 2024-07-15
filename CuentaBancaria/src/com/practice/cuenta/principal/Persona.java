package com.practice.cuenta.principal;

public class Persona {
    private String nombreUSer;
    private int documento;
// getters and setters
    public void setNombreUSer(String nombreUSer) {
        this.nombreUSer = nombreUSer;
    }

    public String getNombreUSer() {
        return nombreUSer;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getDocumento() {
        return documento;
    }


    @Override
    public String toString() {
        return " ----Datos Personales---- " +
                "  Nombre: "+ getNombreUSer() + '\'' +
                "  Documento: " + getDocumento();
    }
}
