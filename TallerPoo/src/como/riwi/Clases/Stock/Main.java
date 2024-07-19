package como.riwi.Clases.Stock;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dataEntry = new Scanner(System.in);
        String menu = """
                Menu:
                Elige una opcion
                1. add a product
                2. remove a product
                3. list products
                4. exit
                """;
        int option= 0;
        Sctock optionsStock = new Sctock();
        while(option !=4){
            System.out.println(menu);
            option = dataEntry.nextInt();
            switch (option){
                case 1:
                    dataEntry.nextLine();
                    System.out.println("ingrese nombre del producto");
                     String nameProduct = dataEntry.nextLine();
                    System.out.println("ingrese la cantidad");
                    int amount = dataEntry.nextInt();
                    Producto producto = new Producto(nameProduct, amount);
                    optionsStock.addProduct(producto);
                    break;
                case 2:
                    System.out.println("ingrese el id del producto");
                    int idProduct = dataEntry.nextInt();
                    optionsStock.removeProduct(idProduct);
                    break;
                case 3:
                    optionsStock.listProducts();
                    break;
                case 4:
                    System.out.println("saliendo del sistema");
                    break;

                default:
                    System.out.println("opcion invalida");
                    break;

            }
        }

    }
}
