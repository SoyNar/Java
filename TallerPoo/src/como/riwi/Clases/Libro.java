package como.riwi.Clases;

public class Libro {

    //atributos
    private String name;
    private String atuor;
    private int year;
    private  boolean isPrestado;

    //Constuctor
    public Libro(String name, String autor, int year){
        this.name = name;
        this.atuor = autor;
        this.year = year;
        this.isPrestado = true;
    }

    //metodos

    public void prestarLibro (){
        if(!this.isPrestado){
            isPrestado = true;
            System.out.println("prestado");
        }else {
            System.out.println("el libro ya esta prestado");
        }
    }

    public void devolverLibro (){
        if(isPrestado){
            isPrestado = false;
            System.out.println("Devuelto");
        } else{
            System.out.println("libro no ha sido devuelto");
        }
    }

    @Override
    public String toString() {
        return "Titulo" + this.name + "Autor: " + this.atuor + "Año de Publicación: " + this.year;
    }
}
