package OOPs.Inheritance;

public class Box {
    double length;
    double height;
    double width;

    Box() {
        super();
        this.length = 10;
        this.height = 20;
        this.width = 30;
    }

    Box(double length, double height) {
        this.length = length;
        this.height = height;
    }

    Box(double length, double height, double width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    //cube
    Box(double side){
        this.length = side;
        this.height = side;
        this.width = side;
    }
}
