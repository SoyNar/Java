package como.riwi.Clases.Figuras;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Circulo",12.2);
        circle.calculateArea();
        Rectangle rectangle = new Rectangle("rectangle",12.3,2.5);
        rectangle.calculateArea();
        Square square = new Square("Cuadrado", 12);
        square.calculateArea();
    }
}
