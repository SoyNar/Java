package como.riwi.Clases.Figuras;

public class Circle extends Figura{

    private  double pi;
    //constructor
    public Circle(String typeFigure, double pi){
        super(typeFigure);
        this.pi = pi;
    }

    @Override
    public void calculateArea() {
        System.out.println("area del circulo: "+ this.pi * this.pi);
    }


}
