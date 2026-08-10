// package Functions.pack1;

// public class shadowing {
//     int num = 10; // instance variable
//      void show(){
//         System.out.println(num);
//         // int num = 20;  // local variable shadows instance variable
//         System.out.println("Local num: " + num);
//         System.out.println("Instance num: " + this.num); // using 'this' to refer to instance variable
//     }
//     public static void main(String[] args) {
//         shadowing obj = new shadowing();
//         obj.show();
//     }
// }

//using static method
// public class shadowing {
//     static int num = 10;
//     // num is a static (class) variable, so only one copy is shared among all
//     // objects of the class
//     // In this program, num is a static (class) variable
//     // shared by all objects.
//     // Inside the show() method, a local variable num is declared, which shadows the
//     // class variable. Therefore, direct access to num refers to the local variable.
//     // To access the class variable, we use shadowing.num. The program demonstrates
//     // variable shadowing and scope resolution in Java.

//     static void show() {
//         System.out.println(num);
//         int num = 20; // local variable shadows class variable
//         System.out.println("Local num: " + num);
//         System.out.println("Instance num: " + shadowing.num); // using 'shadowing' to refer to class variable
//     }

//     public static void main(String[] args) {
//         // shadowing obj = new shadowing();
//         // obj.show();
//         show();
//         System.out.println(num);
//     }
// }

//using non-static method
public class shadowing {
    static int num = 10;
    // num is a static (class) variable, so only one copy is shared among all
    // objects of the class
    // In this program, num is a static (class) variable
    // shared by all objects.
    // Inside the show() method, a local variable num is declared, which shadows the
    // class variable. Therefore, direct access to num refers to the local variable.
    // To access the class variable, we use shadowing.num. The program demonstrates
    // variable shadowing and scope resolution in Java.

   static  void show() {
        System.out.println(num);
        // int num = 20; // local variable shadows class variable
        int x;
        // System.out.println(x); // scope will begin when the value is initialisd.
        x = 50;
        System.out.println(x); // 50
        System.out.println("Local num: " + num);
        System.out.println("Instance num: " + shadowing.num); // using 'shadowing' to refer to class variable
    }

    public static void main(String[] args) {
        // shadowing obj = new shadowing();
        // obj.show();
        show();
        System.out.println(num);
    }
}