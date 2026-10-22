package polymorphism.runTimePolymorphism;

public class Square extends Shapes {

    // @Override tells the compiler that you intend to override an inherited method.
    // If you accidentally write the wrong method signature, the compiler can catch
    // the mistake.
    // Without @Override, an incorrectly named method can silently become a new
    // method or it calls its parent method.
    // With @Override, the compiler catches the mistake before the program runs.
    @Override
    void area() {
        System.out.println("Inside square.");
    }
}
