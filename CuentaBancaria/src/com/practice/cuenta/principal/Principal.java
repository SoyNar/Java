package com.practice.cuenta.principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entradaDatos = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria();
        Persona user = new Persona();

        System.out.println("Bienvenido");
        System.out.println("cual es tu nombre");
        String nombre = entradaDatos.nextLine();

        System.out.println("escribe tu numero de documento");
        int documento = entradaDatos.nextInt();


        user.setNombreUSer(nombre);
        user.setDocumento(documento);

        String menu = """
                opciones 
                1. Depositar
                2. Retirar
                """;
        System.out.println(menu);
        System.out.println("escoge una opcion");
        int opcion = entradaDatos.nextInt();

        if(opcion ==1){
            System.out.println("ingrese salgo a depositar ");
            double saldoNuevo = entradaDatos.nextDouble();
            cuenta.depositar(saldoNuevo);
        } else  if(opcion == 2){
            System.out.println("escribe saldo a retirar");
            double retirarSaldo = entradaDatos.nextDouble();
            cuenta.retirar(retirarSaldo);
        } else {
            System.out.println("Escoge una opcion valida");
        }



        System.out.println(user);
        System.out.println(cuenta);
    }
}
