package polymorphism.runTimePolymorphism;

// Runtime polymorphism (dynamic polymorphism)
// The overridden instance method implementation is selected at runtime based on the actual object's class.
// Achieved through: Method overriding and inheritance.

// Runtime polymorphism: Method overriding
// Definition: Method overriding occurs when a subclass provides its own implementation of an inherited instance method with a compatible signature.
// The implementation that runs is determined by the actual object's class at runtime.

// Which members you can access is determined by the reference type (subject to access modifiers).
//Which overridden instance method executes is determined by the actual object's type at runtime.
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal;

        animal = new Dog();
        animal.sound();

        animal = new Cat();
        animal.sound();
    }
}
