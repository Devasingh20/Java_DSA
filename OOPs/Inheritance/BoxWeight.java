package OOPs.Inheritance;



//Inheritance
public class BoxWeight extends Box{
    double weight;

    public BoxWeight(double length, double height, double width, double weight){
        super(length, height, width);
        this.weight = weight;
    }

    public BoxWeight(double side, double weight){
        super(side);
        this.weight = weight;
    }
}
