package Poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataEntry = new Scanner(System.in);
        Invent totalInvent = new Invent();
        int option = 0;
        String menu = """
                Welcome
                choose an option
                1. add a product
                2. list products
                3. remove a product
                4. find a product
                5. exit
                """;

        do {
            System.out.println(menu);
            option = dataEntry.nextInt();
            switch (option){
                case 1:
                    dataEntry.nextLine();
                    System.out.println("enter product name");
                    String productName = dataEntry.nextLine();
                    System.out.println("enter product price");
                    double priceProduct = dataEntry.nextDouble();
                    System.out.println("enter product category");
                    dataEntry.nextLine();
                    String nameCategory = dataEntry.nextLine();
                    System.out.println("enter bran product");
                    String branProduct = dataEntry.nextLine();
                    ProductEspecific productEspecific = new ProductEspecific(priceProduct,nameCategory,nameCategory,branProduct );
                    totalInvent.addProduct(productEspecific);
                    break;
                case 2:
                    totalInvent.listProduct();
                    break;

                case 3:
                    System.out.println("enter id product");
                    int idProducto = dataEntry.nextInt();
                    totalInvent.removeProduct(idProducto);
                    break;

                case 4:
                        dataEntry.nextLine();
                        System.out.println("Escriba el nombre o categoria del producto");
                        String name = dataEntry.nextLine();
                        totalInvent.findByCategoryAndName(name);
                        break;

                default:
                    System.out.println("ingrese opcion valida");
                    break;
            }
        } while (option != 5);
    }
}
