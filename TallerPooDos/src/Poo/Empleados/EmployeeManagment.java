package Poo.Empleados;

import java.util.ArrayList;

public class EmployeeManagment {
    private ArrayList<Employee> manangment;

    public EmployeeManagment(){
        this.manangment = new ArrayList<>();
    }

    // add employee

    public void addEmployee(Employee employee){
        this.manangment.add(employee);
    }

    // list employee
    public void listEmployee(){
        for(Employee employe : manangment){
             System.out.println("name: " + employe.getName()
                     + " lastName : "
                     + employe.getLastName()
                     + " Age :" + employe.getAge()
                     + " Salary :" + employe.getSalary()
                     + " Status :" + employe.statusEmployee());
        }


    }

    public void removeEmployee(Integer id){
        boolean idFound = false;

        for(int i =0; i<manangment.size(); i++){
            if(id.equals(manangment.get(i).getId())){
                idFound = true;
                manangment.remove(manangment.get(i).getId());
            }
        }
        if(!idFound){
            System.out.println("no encontrado");
        }
    }
}

