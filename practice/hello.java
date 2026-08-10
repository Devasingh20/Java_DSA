
// import java.util.Scanner;

// public class hello {
//     public static void printName(String name) {
//         System.out.println("Hello " + name);
//     }

//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.print("Enter your name :");
//             String name = sc.nextLine();
//             printName(name);
//         }
//     }
// }

//GCD 

// import java.util.Scanner;

// public class hello {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter a :");
//             int a = sc.nextInt();
//             System.out.println("Enter b :");
//             int b = sc.nextInt();
//             int GCD = gcd(a, b);
//             System.out.println("GCD of " + a + " and " + b + " is " + GCD);
//         }
//     }

//     public static int gcd(int a, int b) {
//         int gcd = 1;
//         for (int i = 1; i <= a && i <= b; i++) {
//             if (a % i == 0 && b % i == 0) {
//                 gcd = i;
//             }
//         }
//         return gcd;
//     }
// }

// import java.util.Scanner;

// public class hello {
// public static int factorial(int n) {
// if (n == 0 || n == 1) {
// return 1;
// } else {
// return n * factorial(n - 1);
// }
// }

// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.print("Enter a number : ");
// int n = sc.nextInt();
// int fact = factorial(n);
// System.out.println("Factorial of " + n + " is " + fact);
// }
// }
// }

// sum of
// odd numbers from 1
// to n
// import java.util.*;

// public class hello {
// public static int sumOfOdd(int n) {
// int sum = 0;
// for (int i = 1; i <= n; i++) {
// if (i % 2 != 0) {
// sum += i;
// }
// }
// return sum;
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter a number :");
// int n = cs.nextInt();
// int oddSum = sumOfOdd(n);
// System.out.println("sum of all odd numbers from 1 to " + n + " is " +
// oddSum);
// }
// }
// }

// greater number
// between two
// numbers
// import java.util.*;

// public class hello {
// public static int greaterNumber(int n, int m) {
// if (n > m) {
// return n;
// }
// if (n == m) {
// System.out.println("Both numbers are equal.");
// return n;
// } else {
// return m;
// }
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter number 1st:");
// int n = cs.nextInt();
// System.out.println("Enter number 2nd:");
// int m = cs.nextInt();
// int greater = greaterNumber(n, m);
// System.out.println("Greater number between " + n + " and " + m + " is " +
// greater);
// }
// }
// }

// greatest common
// divisor with return type.
// import java.util.*;
// public class hello {
// public static int gcd(int n, int m) {
// int gcd = 1;
// for (int i = 1; i <= n && i <= m; i++) {
// if (n % i == 0 && m % i == 0) {
// gcd = i;
// }
// }
// return gcd;
// }

// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.print("Enter number 1st(n):");
// int n = sc.nextInt();
// System.out.print("Enter number 2nd(m):");
// int m = sc.nextInt();
// int gcd = gcd(n, m);
// System.out.println("Greatest common divisor of " + n + " and " + m + " is " +
// gcd);
// }
// }
// }

// without return anything.
// import java.util.*;

// public class hello {
// public static void gcd(int n, int m) {
// int gcd = 1;
// for (int i = 1; i <= n && i <= m; i++) {
// if (n % i == 0 && m % i == 0) {
// gcd = i;
// }
// }
// System.out.println("Greatest common divisor of " + n + " and " + m + " is " +
// gcd);
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter number 1st:");
// int n = cs.nextInt();
// System.out.println("Enter number 2nd:");
// int m = cs.nextInt();
// gcd(n, m);
// }
// }
// }

// fibonacci series
// import java.util.Scanner;

// public class hello {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter a number :");
//             int n = sc.nextInt();
//             System.out.println("Fibonacci serien upto " + n + " terms is ");
//             fibonacci(n);
//         }
//     }

//     public static void fibonacci(int n) {
//         int a = 0;
//         int b = 1;
//         System.out.print(a + " " + b + " ");
//         for (int i = 2; i < n; i++) {
//             int c = a + b;
//             System.out.print(c + " ");
//             a = b;
//             b = c;
//         }
//     }
// }

// public class hello{
// public static void main(String[] args) {
// System.out.println("Hello, world");
// }
// }

// public class hello{
// public static void main(String[] args) {
// int a = 10;
// int b = 20;
// int sum = a+b;
// System.out.println("Sum is: " + sum);
// }
// }

// input in
// java
// import java.util.*;

// public class hello {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter your name: ");
// String name = sc.nextLine();
// System.out.println("Hello, " + name);
// }
// }
// }

// conditional statements
// in
// java
// import java.util.*;

// public class hello {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter your age: ");
// int age = sc.nextInt();
// if (age >= 18) {
// System.out.println("You are eligible to vote.");
// } else {
// System.out.println("You are not eligible to vote.");
// }
// }
// }
// }

// loops in
// java
// import java.util.*;

// public class hello {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a number: ");
// int n = sc.nextInt();
// for (int i = 1; i <= 10; i++) {
// System.out.println(n + " x " + i + " = " + (n * i));
// }
// }
// }
// }

// functions in
// java
// import java.util.*;

// public class hello{
// public static void main(String[] args) {
// try(Scanner sc = new Scanner(System.in)){
// System.out.println("Enter a number: ");
// int n = sc.nextInt();
// double fact = factorial(n);
// System.out.println("Factorial of " + n + " is " + fact);
// }
// }
// static double factorial(int n){
// if(n==0 || n==1){
// return 1;
// }
// else{
// return n * factorial(n-1);
// }
// }
// }
// import java.util.*;

// public class hello {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a number : ");
// int n = sc.nextInt();
// for (int i = 1; i <= 10; i++) {
// System.out.println(n + " x " + i + " = " + (n * i));
// }
// }
// }
// }

// while loop

// public class hello {
// public static void main(String[] args) {
// int i = 1;
// while (i <= 10) {
// System.out.println(i);
// i++;
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// int i = 0;
// do {
// System.out.println(i);
// i++;
// } while (i <= 10);
// }
// }

// public class hello {
// public static void main(String[] args) {
// int sum = 0;
// for (int i = 1; i <= 5; i++) {
// sum += i;
// }
// System.out.println(sum);
// }}

// star pattern

// public class hello {
// public static void main(String[] args) {
// for (int i = 0; i < 5; i++) {
// for (int j = 0; j < 5; j++) {
// System.out.print("*");
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 1; j <= i; j++) {
// System.out.print("*");
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 5; j >= i; j--) {
// System.out.print("*");
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 4; i++) {
// for (int j = 1; j <= 5; j++) {
// if (i == 1 || j == 1 || i == 4 || j == 5) {
// System.out.print("*");
// } else {
// System.out.print(" ");
// }
// }
// System.out.println();
// }
// }
// }

// public class hello{
// public static void main(String[] args) {
// for(int i = 1;i<=5; i++){
// for(int j = 1; j<=5-i; j++){
// System.out.print(" ");
// }
// for(int j = 1; j<=i; j++){
// System.out.print("*");
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 1; j <= 5 - i + 1; j++) {
// System.out.print(j);
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 5 - i + 1; j >= 1; j--) {
// System.out.print(j);
// }
// System.out.println();
// }
// }
// }

// floyd's triangle

// public class hello {
// public static void main(String[] args) {
// int number = 1;
// for (int i = 1; i <= 5; i++) {
// for (int j = 1; j <= i; j++) {
// System.out.print(number + " ");
// number++;
// }
// System.out.println();
// }
// }
// }

// 0,1 pattern

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 10; i++) {
// for (int j = 1; j <= i; j++) {
// if ((i + j) % 2 == 0) {
// System.out.print(1 + " ");
// } else {
// System.out.print(0 + " ");
// }
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (int j = 1; j <= i; j++) {
// System.out.print("* ");
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (int j = 1; j <= i; j++) {
// System.out.print("* ");
// }
// System.out.println();
// }
// for (int i = 4; i >= 1; i--) {
// for (int j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (int j = 1; j <= i; j++) {
// System.out.print("* ");
// }
// System.out.println();
// }
// }
// }

// butterfly pattern

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 4; i++) {
// for (int j = 1; j <= i; j++) {
// System.out.print("*");
// }
// for (int j = 1; j <= 2 * (4 - i); j++) {
// System.out.print(" ");
// }
// for (int j = 1; j <= i; j++) {
// System.out.print("*");
// }
// System.out.println();
// }
// for (int i = 4; i >= 1; i--) {
// for (int j = 1; j <= i; j++) {
// System.out.print("*");
// }
// for (int j = 1; j <= 2 * (4 - i); j++) {
// System.out.print(" ");
// }
// for (int j = 1; j <= i; j++) {
// System.out.print("*");
// }
// System.out.println();
// }
// }
// }

// solid rhombus

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (int j = 1; j <= 5; j++) {
// System.out.print("*");
// }
// System.out.println();
// }
// }
// }

// hollow rhombus

// public class hello {
// public static void main(String[] args) {
// int i, j;
// for (i = 1; i <= 5; i++) {
// for (j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (j = 1; j <= 5; j++) {
// System.out.print("* ");
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// int i, j;
// for (i = 1; i <= 5; i++) {
// for (j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (j = 1; j <= i; j++) {
// System.out.print(i + " ");
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (int j = i; j >= 1; j--) {
// System.out.print(j);
// }
// for (int j = 2; j <= i; j++) {
// System.out.print(j);
// }
// System.out.println();
// }
// }
// }

// public class hello {
// public static void main(String[] args) {
// for (int i = 1; i <= 5; i++) {
// for (int j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (int j = 1; j <= 2 * i - 1; j++) {
// System.out.print("*");
// }
// System.out.println();
// }
// for (int i = 4; i >= 1; i--) {
// for (int j = 1; j <= 5 - i; j++) {
// System.out.print(" ");
// }
// for (int j = 1; j <= 2 * i - 1; j++) {
// System.out.print("*");
// }
// System.out.println();
// }
// }
// }

// functions in
// java
// import java.util.*;
// public class hello {
// public static void printName(String name) {
// System.out.println("Hello " + name);
// }
// public static void main(String[] args) {
// try(Scanner sc = new Scanner(System.in)){

// }
// }
// }

// import java.util.*;

// public class hello {
// public static int factorial(int n) {
// if (n == 0 || n == 1) {
// return 1;
// } else {
// return n * factorial(n - 1);
// }
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter a number :");
// int n = cs.nextInt();
// int fact = factorial(n);
// System.out.println("Factorial of " + n + " is " + fact);
// }
// }
// }

// sum of
// odd numbers from 1
// to n
// import java.util.*;

// public class hello {
// public static int sumOfOdd(int n) {
// int sum = 0;
// for (int i = 1; i <= n; i++) {
// if ((i & 1) != 0) {
// sum += i;
// }
// }
// return sum;
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter a number :");
// int n = cs.nextInt();
// int oddSum = sumOfOdd(n);
// System.out.println("sum of all odd numbers from 1 to " + n + " is " +
// oddSum);
// int[] arr = {1,2,3};
// sorting.printArray(arr);
// }
// }
// }

// greater number
// between two
// numbers
// import java.util.*;

// public class hello {
// public static int greaterNumber(int n, int m) {
// if (n > m) {
// return n;
// }
// if (n == m) {
// System.out.println("Both numbers are equal.");
// return n;
// } else {
// return m;
// }
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter number 1st:");
// int n = cs.nextInt();
// System.out.println("Enter number 2nd:");
// int m = cs.nextInt();
// int greater = greaterNumber(n, m);
// System.out.println("Greater number between " + n + " and " + m + " is " +
// greater);
// }
// }
// }

// greatest common
// divisor with return type.
// import java.util.*;

// public class hello {
// public static int gcd(int n, int m) {
// int gcd = 1;
// for (int i = 1; i <= n && i <= m; i++) {
// if (n % i == 0 && m % i == 0) {
// gcd = i;
// }
// }
// return gcd;
// // System.out.println("never reached");
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter number 1st:");
// int n = cs.nextInt();
// System.out.println("Enter number 2nd:");
// int m = cs.nextInt();
// int gcd = gcd(n, m);
// System.out.println("Greatest common divisor of " + n + " and " + m + " is " +
// gcd);
// }
// }
// }

// without return anything.
// import java.util.*;

// public class hello {
// public static void gcd(int n, int m) {
// int gcd = 1;
// for (int i = 1; i <= n && i <= m; i++) {
// if (n % i == 0 && m % i == 0) {
// gcd = i;
// }
// }
// System.out.println("Greatest common divisor of " + n + " and " + m + " is " +
// gcd);
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter number 1st:");
// int n = cs.nextInt();
// System.out.println("Enter number 2nd:");
// int m = cs.nextInt();
// gcd(n, m);
// }
// }
// }

// fibonacci series
// import java.util.*;

// public class hello {
// public static void fibonacci(int n) {
// int a = 0, b = 1;
// System.out.print(a + " " + b + " ");
// for (int i = 2; i < n; i++) {
// int c = a + b;
// System.out.print(c + " ");
// a = b;
// b = c;
// }
// }

// public static void main(String[] args) {
// try (Scanner cs = new Scanner(System.in)) {
// System.out.println("Enter a number :");
// int n = cs.nextInt();
// System.out.println("Fibonacci series upto " + n + " terms is :");
// fibonacci(n);
// }
// }
// }
