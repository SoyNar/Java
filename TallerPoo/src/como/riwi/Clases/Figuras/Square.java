package como.riwi.Clases.Figuras;

public class Square  extends Figura{
    private double side;

    public Square( String typeFigure, double side){
        super(typeFigure);
        this.side = side;
    }
    //

    @Override
    public void calculateArea() {
        System.out.println("el area del cuadrado es: " + this.side * this.side);
    }
}
