package interfaces;

public class NiceCar {
    private Engine engine;
    private final Media player = new CDPlayer();

    public NiceCar(Engine engine) {
        this.engine = engine;
    }

    public NiceCar() {
        this.engine = new PowerEngine();
    }

    void start() {
        engine.start();
    }

    void stop() {
        engine.stop();
    }

    void musicStart() {
        player.start();
    }

    void musicStop() {
        player.stop();
    }

    public void upgradeCar() {
        this.engine = new ElectricEngine();
    }

}
