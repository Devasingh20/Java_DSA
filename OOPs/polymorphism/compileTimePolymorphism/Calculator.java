package polymorphism.compileTimePolymorphism;

// Compile-time polymorphism (static polymorphism)
// The method to use is selected by the compiler based on the method signature
// and the arguments.
// Achieved through: Method overloading.
public class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Calculator add = new Calculator();
        System.out.println(add.sum(5, 5));

        Calculator add1 = new Calculator();
        System.out.println(add1.sum(5, 5, 5));

        Calculator multiply = new Calculator();
        System.out.println(multiply.multiply(5, 5));
    }
}
