package como.riwi.Clases;

public class Empleados {
    //Sistema de Gestión de Empleados: Diseña un sistema donde puedas
    //gestionar empleados utilizando la POO. Crea una clase Empleado con
    //atributos como nombre, posición, salario y id. Implementa métodos para
    //obtener y modificar estos atributos, además de un método para aumentar el
    //salario por un porcentaje dado.

    // atributos
    // atributos
    private static int contadorEmpleado;
    private String cargo;
    private double salario;
    private String nombre;
    private int id;

    //constructor

    public Empleados(String nombre, String cargo, double salario){
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.id = ++contadorEmpleado;

    }

    // metodo

    public double aumentarSalario(double aumento){
        if(aumento > 0 ){
            this.salario += aumento;
            System.out.println("salario aumentado: " + this.salario);
        }else {
            System.out.println("el monto no puede ser menor a cero" );
        }
        return this.salario;
    }

    @Override
    public String toString() {
        return  " id : " + this.id + "" +
                " Nombre : " + this.nombre +
                " Cargo: " + this.cargo +
                " Salario : " + this.salario;

    }

}
