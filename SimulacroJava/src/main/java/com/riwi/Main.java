package com.riwi;

import com.riwi.Controller.CoderController;
import com.riwi.Controller.ContratacionController;
import com.riwi.Controller.EmpresaController;
import com.riwi.Controller.VacanteController;
import com.riwi.Entitys.Coder;
import com.riwi.Entitys.Contratacion;
import com.riwi.Entitys.Empresa;
import com.riwi.Entitys.Vacante;
import com.riwi.Persistence.IModel.IEmpresa;
import com.riwi.Persistence.Until.Estado;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void empresaMenu(){


    }
    public static void main(String[] args) {



        EmpresaController iEmpresa = new EmpresaController();
        ContratacionController contratacionController = new ContratacionController();
        VacanteController vacanteController = new VacanteController();
//        String name = JOptionPane.showInputDialog("nombre empresa");
//        String ubicacion = JOptionPane.showInputDialog(" escribe nombre de la empresa");
//        Empresa empresaCrear = new Empresa(name,ubicacion);
//        iEmpresa.create(empresaCrear);


             iEmpresa.read();
//            int idDelete = Integer.parseInt(JOptionPane.showInputDialog(" escribe el id que quieres eliminar"));
//
//            iEmpresa.delete(idDelete);
//         actualizar
//        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la empresa"));
//        String nameU= JOptionPane.showInputDialog("ingrese nombre de la empresa");
//        Empresa empresa = new Empresa(nameU,idUpdate);
//        iEmpresa.updateName(empresa);
        CoderController coderController = new CoderController();

//        String  name = JOptionPane.showInputDialog("ingrese el nombre ");
//        String  lastname = JOptionPane.showInputDialog("ingrese el apellido ");
//        String  clan = JOptionPane.showInputDialog("ingrese el clan ");
//        String  tecnology = JOptionPane.showInputDialog("ingrese la tecnologia ");
//        String  cohorte = JOptionPane.showInputDialog("ingrese  cohorte ");
//        String  documento = JOptionPane.showInputDialog("ingrese el Dcoumento ");
//
//
//        Coder coder = new Coder(name,lastname,tecnology,clan,cohorte,documento);
//        coderController.create(coder);
//
//        ///listar coders
        coderController.read();
        vacanteController.read();


        String titulo = JOptionPane.showInputDialog("insert titulo vacante");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("insert salario"));
        String description = JOptionPane.showInputDialog("insert description");
        String tecnologia = JOptionPane.showInputDialog("insert tecnologia");
        String estado = JOptionPane.showInputDialog("insert estado Activo o Inactivo ");
        Estado estado1 = Estado.valueOf(estado);
        int empresaId = Integer.parseInt(JOptionPane.showInputDialog("inser id empresa"));
        Vacante vacante = new Vacante(titulo,estado1,salario,description,tecnologia,empresaId);
        vacanteController.create(vacante);

        int coderID = Integer.parseInt(JOptionPane.showInputDialog(" insert id coder"));
        int vacanteId = Integer.parseInt(JOptionPane.showInputDialog("insert id vacante"));
        Contratacion contratacion1 = new Contratacion(coderID,vacanteId);
        contratacionController.create(contratacion1);
        contratacionController.read();

        }



}