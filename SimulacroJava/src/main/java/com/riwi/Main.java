package com.riwi;

import com.riwi.Controller.CoderController;
import com.riwi.Controller.EmpresaController;
import com.riwi.Entitys.Coder;
import com.riwi.Entitys.Empresa;
import com.riwi.Persistence.IModel.IEmpresa;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        EmpresaController iEmpresa = new EmpresaController();
//        String name = JOptionPane.showInputDialog("nombre empresa");
//        String ubicacion = JOptionPane.showInputDialog(" escribe nombre de la empresa");
//        Empresa empresaCrear = new Empresa(name,ubicacion);
//        iEmpresa.create(empresaCrear);


             iEmpresa.read();
//            int idDelete = Integer.parseInt(JOptionPane.showInputDialog(" escribe el id que quieres eliminar"));
//
//            iEmpresa.delete(idDelete);
        // actualizar
//        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la empresa"));
//        String name = JOptionPane.showInputDialog("ingrese nombre de la empresa");
//        Empresa empresa = new Empresa(name,idUpdate);
//        iEmpresa.updateName(empresa);
        CoderController coderController = new CoderController();

        String  name = JOptionPane.showInputDialog("ingrese el nombre ");
        String  lastname = JOptionPane.showInputDialog("ingrese el apellido ");
        String  tecnology = JOptionPane.showInputDialog("ingrese el tecnologia ");
        String  clan = JOptionPane.showInputDialog("ingrese el clan ");
        String  cohorte = JOptionPane.showInputDialog("ingrese el cohorte ");
        String  documento = JOptionPane.showInputDialog("ingrese el Dcoumento ");


        Coder coder = new Coder(name,lastname,tecnology,clan,cohorte,documento);
        coderController.create(coder);

        ///listar coders
        coderController.read();
        }



}