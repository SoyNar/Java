package com.riwi.Controller;

import com.riwi.Entitys.Contratacion;
import com.riwi.Model.ContratacionModel;
import com.riwi.Persistence.IModel.IContratacion;

import javax.swing.*;
import java.util.List;

public class ContratacionController {

    IContratacion contratacion = new ContratacionModel();
    public Contratacion read(Contratacion contratacion){
        return this.contratacion.cread(contratacion);
    }

    public void read(){
        List<Contratacion> listContratacion = this.contratacion.read();
        JOptionPane.showMessageDialog(null, listContratacion.toString());


    }

    public void create(Contratacion contratacion){
        this.contratacion.cread(contratacion);
    }
}
