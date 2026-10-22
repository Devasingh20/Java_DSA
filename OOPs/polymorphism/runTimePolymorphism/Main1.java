package polymorphism.runTimePolymorphism;

public class Main1 {
    public static void main(String[] args) {

        Shapes shape = new Shapes();
        shape.area();

        Circle circle = new Circle();
        circle.area();

        Square square = new Square();
        square.area();

    }
}
