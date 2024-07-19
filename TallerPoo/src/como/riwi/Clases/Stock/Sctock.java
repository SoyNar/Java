package como.riwi.Clases.Stock;

import java.util.ArrayList;

public class Sctock {

    private ArrayList<Producto> stockProducts;

    // constructor

    public Sctock(){
        this.stockProducts = new ArrayList<>();
    }

    // metodo para agregar un producto
    public void addProduct(Producto producto){
        this.stockProducts.add(producto);
    }
    // remove product
// recorrer arraylist y buscar producto con id, y eliminarlo
    public void removeProduct (Integer id){
        boolean isFound = false;
    for(Producto producto : this.stockProducts){
        if(producto.getIdProduct() == id){
            isFound = true;
            this.stockProducts.remove(producto);
            System.out.println("Producto Eliminado");
        }
        if(!isFound){
            System.out.println("producto no encontrado");
        }
    }
//        for(int i=0; i<this.stockProducts.size(); i++){
//            if(this.stockProducts.get(i).getIdProduct() == id){
//                this.stockProducts.remove(i);
//                System.out.println("producto eliminado");
//            }else {
//                System.out.println("producto no encontrado");
//            }
//        }
    }

    //metodo para listar todos los productos

    public void listProducts(){
        for(int i=0; i<this.stockProducts.size(); i++){
            System.out.println(" lista de productos");
            System.out.println("nombre:" + this.stockProducts.get(i).getDescription() + " Amount: " + this.stockProducts.get(i).getAmoun() + "id Product: " + this.stockProducts.get(i).getIdProduct() );
        }
    }
}
