package OOPs.Inheritance;



//Multilevel inheritance
public class BoxPrice extends BoxWeight {
    double cost;

    public BoxPrice(double cost, double length, double height, double width, double weight) {
        super(length, height, width, weight);
        this.cost = cost;
    }
    
    public BoxPrice(double side, double cost, double weight){
        super(side,weight);
        this.cost = cost;
    }
}
