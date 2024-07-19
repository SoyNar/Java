package como.riwi.Clases.Figuras;

public class Rectangle extends Figura {
    private  double side1;
    private double side2;

    // constructor

    public Rectangle(String typeFigure, double side1, double side2){
        super(typeFigure);
        this.side1 = side1;
        this.side2 = side2;

    }

    @Override
    public void calculateArea() {
        System.out.println("area of rectangle: " + this.side1 * this.side2);
    }
}
