package Poo.Empleados;

public class TemporalEmployee extends Employee {


    public TemporalEmployee(String name, String lastName, int age, int id, double salary) {
        super(name, lastName, age, salary);
    }

    @Override
    public String statusEmployee() {
        return  "Schdle : Acording to program";
    }
}
