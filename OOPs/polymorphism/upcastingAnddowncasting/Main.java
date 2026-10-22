package polymorphism.upcastingAnddowncasting;

class Box { // if we put final keyword here we cannot override the display method here.
            // whenever you put a class as final then implicitly declare all of its methods
            // final too.
    void display() {
        System.out.println("I am a Box");
    }
}

class BoxWeight extends Box {
    @Override
    void display() {
        System.out.println("I am a BoxWeight");
    }
}

class GiftBox extends Box {
    @Override
    void display() {
        System.out.println("I am a GiftBox");
    }
}

public class Main {

    static void printBox(Box box) {
        box.display();
    }

    public static void main(String[] args) {
        printBox(new Box());
        printBox(new BoxWeight());
        printBox(new GiftBox());
    }
}

//