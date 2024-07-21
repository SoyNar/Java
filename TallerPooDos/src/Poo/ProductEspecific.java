package Poo;

public class ProductEspecific  extends Product{

    private String category;
    private String brand;

    // getters and setter


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // constructor
    public ProductEspecific(double price, String nameProduct, String category, String brand) {
        super(price, nameProduct);
        this.category = category;
        this.brand = brand;
    }
}
