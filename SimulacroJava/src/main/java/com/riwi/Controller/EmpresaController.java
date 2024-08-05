package com.riwi.Controller;

import com.riwi.Entitys.Empresa;
import com.riwi.Model.EmpresaModel;
import com.riwi.Persistence.IModel.IEmpresa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaController {

    IEmpresa iEmpresa = new EmpresaModel();
    public Empresa create(Empresa nuevaEmpresa){
         return this.iEmpresa.cread(nuevaEmpresa);

    }

    public void read(){
        List<Empresa> listaEmpresas = iEmpresa.read();
        listaEmpresas.forEach(System.out::println);
    }

    public void delete(int id){
        this.iEmpresa.delete(id);
    }

    public void updateName (Empresa empresa){
        this.iEmpresa.update(empresa);
    }
}
