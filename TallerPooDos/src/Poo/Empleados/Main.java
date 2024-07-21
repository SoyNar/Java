package Poo.Empleados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataEntry = new Scanner(System.in);
        EmployeeManagment employeeManagment = new EmployeeManagment();

        System.out.println("escribe nombre");

        String name = dataEntry.nextLine();

        System.out.println("escriba la edad ");

        int age = dataEntry.nextInt();
        dataEntry.nextLine();

        System.out.println("escriba lastname");
        String lastName = dataEntry.nextLine();

        System.out.println("escriba salario");
        double salary =dataEntry.nextDouble();

        Employee employee = new PermanentEmployee(name,lastName,age,salary);
        employeeManagment.addEmployee(employee);
        employeeManagment.listEmployee();
        dataEntry.nextLine();

        System.out.println("ingresa id del empleado");
        Integer idEmployee = dataEntry.nextInt();
        employeeManagment.removeEmployee(idEmployee);
    }
}
