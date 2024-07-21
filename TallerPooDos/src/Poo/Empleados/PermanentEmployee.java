package Poo.Empleados;

public class PermanentEmployee extends Employee{

    public PermanentEmployee(String name, String lastName, int age, double salary) {
        super(name, lastName, age, salary);

    }

    @Override
    public String statusEmployee() {
        return "Schdule: M - F 8 hours";
    }
}
