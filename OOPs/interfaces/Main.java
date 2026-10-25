package interfaces;

public class Main {
    public static void main(String[] args) {
        // Engine car = new Car(); // same as below
        // Car c = new Car();
        // c.acc();
        // c.brake();
        // c.start();
        // c.stop();

        // Media carMedia = new Car();
        // carMedia.stop(); // Calls the stop() implementation associated with the Media interface's
                         // implementation in Car. If multiple interfaces declare the same method
                         // signature, one implementation in Car may serve both interfaces.
                         // To avoid ambiguity about which behavior is intended, use separate
                         // methods or separate classes when different behaviors are required.
            NiceCar car = new NiceCar();
            car.start();
            car.stop();
            car.musicStart();
            car.musicStop();
            car.upgradeCar();
            car.start();
    }
}
