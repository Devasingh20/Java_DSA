package abstraction;

public class Main {
    public static void main(String[] args) {
        parent son = new son();
        son.career();
        son.partner();

        parent daughter = new daughter();
        daughter.career();
        daughter.partner();

        // instantiated means creating an object of a class. When we
        // write new son(), we instantiate the son class, meaning we create a son
        // object.

        // parent p = new parent(); // Compilation error why--> An abstract class cannot
        // be instantiated directly because it may contain abstract methods that have no
        // implementation. but we can
        // create a reference of its type that refers to an object of a concrete
        // subclass.

        // parent.career(); //error : We cannot call parent.career() because career() is
        // an abstract instance method, not a static method. In Java, instance methods
        // must be called through an object reference rather than directly through the
        // class name or implicitly within an instance context. An abstract class cannot
        // be instantiated directly, but we can
        // create a reference of its type that refers to an object of a concrete
        // subclass.
        // Remember: Class name is used to access static members, whereas instance
        // methods are called through object references.

    

        // How it works: parent son = new son();
        // son.career();
        // 1. Parent son — the reference type is Parent.
        // 2. new Son() — the actual object belongs to class Son.
        // 3. son.career() — Java checks at compile time that career() is accessible
        // through Parent.
        // 4. At runtime, dynamic method dispatch selects and executes Son's overridden
        // implementation of career().
    }
}
