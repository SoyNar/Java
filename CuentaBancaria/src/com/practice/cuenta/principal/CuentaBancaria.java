package com.practice.cuenta.principal;

public class CuentaBancaria {

    private int numeroCuenta = 14526678;
    private double saldo = 100;


    public double getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    //metodos depositar y retirar

    public void  depositar (double montoNuevo){

        if(montoNuevo > 0){
           saldo += montoNuevo;
            System.out.println("Saldo actualizado");
        }else {
            System.out.println("cantidad a depositar debe ser mayor a cero");
        }
    }

    public void retirar (double montoNuevo){
        if(montoNuevo >= 0){
            if(saldo > montoNuevo){
                saldo -= montoNuevo;
            }else {
                System.out.println("saldo insuficiente");
            }
        }

    }

    @Override
    public String toString() {
        return "Numero Cuenta: " + getNumeroCuenta() +
                " Saldo: " + getSaldo();
    }
}
