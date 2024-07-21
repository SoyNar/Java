package Poo.Empleados;

public class Employee extends Person {
    private static int idEmployee;
    private int id;
    private double salary;

    // constructos


    public Employee(String name, String lastName, int age, double salary) {
        super(name, lastName, age);
        this.id = ++idEmployee;
        this.salary = salary;
    }

    //getters and setter




    public int getId() {
        return id;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String statusEmployee(){
        return "";
    }
}
