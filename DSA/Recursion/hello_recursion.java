// public class hello_recursion {

//     public static void main(String[] args) {

//         // Program execution starts from main()
//         // main() calls message()
//         message();
//     }

//     static void message() {

//         // 1. Print Hello world
//         System.out.println("Hello world");

//         // 2. After printing, message() calls message1()
//         message1();

//         // 5. After message1() finishes, control comes back here.
//         // There is nothing left to execute in message().
//         // So message() finishes.
//     }

//     static void message1() {

//         // 1. Print Hello world
//         System.out.println("Hello world");

//         // 2. message1() calls message2()
//         message2();

//         // 4. message2() finishes and control comes back here.
//         // Nothing is left in message1(), so message1() finishes.
//     }

//     static void message2() {

//         // 1. Print Hello world
//         System.out.println("Hello world");

//         // 2. message2() calls message3()
//         message3();

//         // 3. message3() finishes and control comes back here.
//         // Nothing is left in message2(), so message2() finishes.
//     }

//     static void message3() {

//         // 1. Print Hello world
//         System.out.println("Hello world");

//         // 2. message3() calls message4()
//         message4();

//         // 3. message4() finishes and control comes back here.
//         // Nothing is left in message3(), so message3() finishes.
//     }

//     static void message4() {

//         // Print Hello world for the 5th time
//         System.out.println("Hello world");

//         // There is nothing else in message4().
//         // So message4() finishes.
//         // Control returns to message3().
//     }
// }

//In the above example the point is to be noted that all the functions have the same body and doing the same thing, then why are you creating again and again a simple solution is "call the function itself (Recursion)".
//Recursion.
public class hello_recursion {

    public static void main(String[] args) {

        // Program execution starts here.
        // We call message() only once.
        message(1);
    }

    static void message(int n) {

        // Base Case:
        // When n becomes 5, stop the recursion.
        if (n == 5) {
            System.out.println("Hello World");
            return;
        }
        // Recursive Call:
        message(n + 1);

        // Print the message once.
        System.out.println("Hello World");

    }
}
