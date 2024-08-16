package com.riwi.Controller;

import com.riwi.Entitys.Vacante;
import com.riwi.Model.VacanteModel;
import com.riwi.Persistence.IModel.IVacante;

import javax.swing.*;
import java.util.List;

public class VacanteController {

    IVacante iVacante = new VacanteModel();

    public void read(){
        List<Vacante> listVacante = this.iVacante.read();
        JOptionPane.showMessageDialog(null,listVacante.toString());
    }
    public void create(Vacante vacante){
        this.iVacante.cread(vacante);
    }

    public void delete(Integer id){
        iVacante.delete(id);
    }

    public void listVacante(Vacante vacante){
        List<Vacante> listaVacante = this.iVacante.read();
        listaVacante.forEach(System.out::println);
    }

    public Vacante update(Vacante vacante){
        return  this.iVacante.update(vacante);
    }
}
