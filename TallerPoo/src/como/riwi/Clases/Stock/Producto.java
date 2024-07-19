package como.riwi.Clases.Stock;

public class Producto {
    private static int id;
    private int idProduct;
    private String description;
    private int amoun;

    // constructor

    public Producto(String description, int amoun){
        this.description = description;
        this.amoun += amoun;
        this.idProduct  = ++id;
    }



    //getter and setters

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmoun() {
        return amoun;
    }

    public void setAmoun(int amoun) {
        this.amoun = amoun;
    }

}
