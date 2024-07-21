package Poo;

import java.util.ArrayList;
public class Invent {
    private ArrayList<ProductEspecific> stock;

    //constructor

    public Invent() {
        this.stock = new ArrayList<>();
    }

    // metodos
    // add a products at stock
    public void addProduct(ProductEspecific product){
        this.stock.add(product);
    }

    // list products in stock

    public void listProduct(){
        for(ProductEspecific  product: stock){
            System.out.println( "---" +
                    "name: " +
                    product.getNameProduct() +
                    " Price : " + product.getPrice() +
                    " Category : " + product.getCategory() +
                    " Brand : " + product.getBrand() + "--");

        }
    }

    // methos to delete a product

    public void removeProduct(Integer id){
       for(ProductEspecific product: stock){
           if(id.equals(product.getIdProduct())){
               stock.remove(product);
               System.out.println("producto eliminado");
           } else {
               System.out.println("producto no encontrado");
           }
       }
    }

    // method find by category and name

    public void findByCategoryAndName(String name){
        boolean isProduct = false;
        for(ProductEspecific product: stock){
            if(product.getNameProduct().equalsIgnoreCase(name) ||
                    product.getCategory().equalsIgnoreCase(name)){
                isProduct = true;
                System.out.println("name: " + product.getNameProduct() +
                        " category: " + product.getCategory() +
                        " price :" + product.getPrice() + " id :"+ product.getIdProduct());
            }
        }
        if(!isProduct){
            System.out.println("no encontrado");
        }
        }
    }


