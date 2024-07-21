package Poo;

public class Product {
    // clase modelo
    private static int id;
    private String nameProduct;
    private double price;
    private int idProduct;


    // constructor
  public Product(double price, String nameProduct){
      this.nameProduct = nameProduct;
      this.price = price;
      this.idProduct = ++id;
  }


    // getters and setters


    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
