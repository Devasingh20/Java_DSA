
// public class stringBuilder {
//     public static void main(String[] args) {
//         {
//             StringBuilder sb = new StringBuilder("Hello");
//             sb.append(", World!");
//             System.out.println(sb.toString());
//             sb.replace(7, 12, "Java");
//             System.out.println(sb.toString());
//             sb.delete(5, 7);
//             System.out.println(sb.toString());
//             sb.insert(5, " Beautiful");
//             System.out.println(sb.toString());
//             System.out.println("Length: " + sb.length());
//             System.out.println("Capacity: " + sb.capacity());
//         }
//     }
// }

//append()
// public class stringBuilder {
//     public static void main(String[] args) {
//         {
//             StringBuilder sb = new StringBuilder("Deva");
//             sb.append(" Singh");
//             System.out.println(sb.toString());

//         }
//     }
// }

// insert()
// public class stringBuilder {
// public static void main(String[] args) {
// {
// StringBuilder sb = new StringBuilder("Deva Singh");
// sb.insert(0, "Mr. ");
// System.out.println(sb);
// }
// }
// }

// delete()
// public class stringBuilder {
// public static void main(String[] args) {
// {
// StringBuilder sb = new StringBuilder("Mr. Deva Singh");
// sb.delete(0,4);
// System.out.println(sb);
// }
// }
// }

// replace()
// public class stringBuilder {
// public static void main(String[] args) {
// {
// StringBuilder sb = new StringBuilder("Mr. Deva Singh");
// sb.replace(0,2, "Hi");
// System.out.println(sb);
// }
// }
// }

// reverse()
// public class stringBuilder {
// public static void main(String[] args) {
// {
// StringBuilder sb = new StringBuilder("Mr. Deva Singh");
// sb.reverse();
// System.out.println(sb);
// }
// }
// }

// //capacity()
// public class stringBuilder {
// public static void main(String[] args) {
// {
// StringBuilder sb = new StringBuilder();
// System.out.println("Initial Capacity: " + sb.capacity());
// sb.append("Hello");
// System.out.println("Capacity after appending 'Hello': " + sb.capacity());
// sb.append(" World! This is a test of StringBuilder capacity.");
// System.out.println("Capacity after appending more text: " + sb.capacity());
// }
// }
// }

// public class stringBuilder {
// public static void main(String[] args) {
// {
// StringBuilder sb = new StringBuilder("hello");
// sb.append(" world");
// for (int i = sb.length() - 1; i >= 0; i--) {
// System.out.print(sb.charAt(i));
// }
// }
// }
// }

// unary operators(increment)
//unary(post increment) operator first use the value then change the value
// public class stringBuilder{
//     public static void main(String[] args) {
//         int x = 5;
//         int y = x++ ;
//         System.out.println(y);
//         System.out.println(x);
//     }
// }

//unary(pre increment) operator first change the value then use the value.
// public class stringBuilder{
//     public static void main(String[] args) {
//         int x = 5;
//         int y = ++x ;
//         System.out.println(y);
//         System.out.println(x);
//     }
// }


// public class stringBuilder{
//     public static void main(String[] args) {
//         int a = 3;
//         int b = a++ + ++a;
//         System.out.println(b);
//     }
// }

// public class stringBuilder{
//     public static void main(String[] args) {
//         int a = 7;
//         int b = ++a + a++ + ++a;
//         System.out.println(b);
//     }
// }


// unary operators(decrement)
// public class stringBuilder{
//     public static void main(String[] args) {
//         int x = 5;
//         int y = x-- + 2;
//         System.out.println(x);
//         System.out.println(y);
//     }
// }

// public class stringBuilder{
//     public static void main(String[] args) {
//         int x = 5;
//         int y = x-- + --x;
//         System.out.println(x);
//         System.out.println(y);
//     }
// }

// public class stringBuilder{
//     public static void main(String[] args) {
//         int x = 7;
//         int y = --x + x-- + --x;
//         System.out.println(x);
//         System.out.println(y);
//     }
// }




// public class stringBuilder {
//     public static void main(String[] args) {
//         {
//             int a = 40, b = 13;
//             System.out.println(Integer.toBinaryString(~a));
//             System.out.println((~a));
//             System.out.println(Integer.toBinaryString(a & b));
//             System.out.println(Integer.toBinaryString(a));
//             System.out.println(++a);
//             System.out.println(a++);
//             a++;
//             System.out.println(a);

//         }
//     }
// }

// import java.util.Scanner;

// public class stringBuilder {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number: ");
//         int n = sc.nextInt();

//         int result = n & (n - 1);

//         System.out.println("After removing last set bit: " + Integer.toBinaryString(result));
//     }
// }

// import java.util.Scanner;

// public class stringBuilder {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number: ");
//         int n = sc.nextInt();

//         System.out.print("Enter bit position: ");
//         int i = sc.nextInt();

//         int result = n ^ (1 << i);

//         System.out.println("Result after toggling bit: " + Integer.toBinaryString(result));
//     }
// }


// import java.util.Scanner;

// public class stringBuilder {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number: ");
//         int n = sc.nextInt();

//         System.out.print("Enter bit position: ");
//         int i = sc.nextInt();

//         int result = n | (1 << i);

//         System.out.println("Result after setting bit: " + Integer.toBinaryString(result));
//     }
// }

// import java.util.Scanner;

// public class stringBuilder {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number: ");
//         int n = sc.nextInt();
//         System.out.println(n + " in binary :" + Integer.toBinaryString(n));
//         System.out.print("Enter bit position: ");
//         int i = sc.nextInt();
//         int result = n & (1 << i);
//         if(result != 0){
//             System.out.println("Bit is 1");
//         }else{
//             System.out.println("Bit is 0");
//         }
//     }
// }


// import java.util.Scanner;

// public class stringBuilder {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number: ");
//         int n = sc.nextInt();
//         System.out.println(n + " in binary :" + Integer.toBinaryString(n));
//         System.out.print("Enter bit position: ");
//         int i = sc.nextInt();

//         int result = n ^ (1 << i);

//         System.out.println("Result after toggleing bit: " + Integer.toBinaryString(result));
//     }
// }

// import java.util.Scanner;

// public class stringBuilder {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number: ");
//         int n = sc.nextInt();
//         System.out.println(n + " in binary :" + Integer.toBinaryString(n));
//         int result = n & (n-1);

//         System.out.println("Result after removing last set bit: " + Integer.toBinaryString(result));
//     }
// }