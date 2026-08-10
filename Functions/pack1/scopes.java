// package Functions.pack1;

public class scopes {
    // int a = 50;
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(b);
        System.out.println(a);
        { // anything in the outside you can use inside but, anything is in inside you
          // cannot use outside. And this block is also inside the main function.
          // int a = 100; // already initialised outside the block in the same method and
          // hence you cannot initialised again.

            a = 100; // reassign the original ref. variable to some other value.
            int c = 90; // values initialized in this block will remain in this block.
            System.out.println(c);
            System.out.println(a); // 100
        }
        // System.out.println(c); // c cannot use outside.
        System.out.println(a); // 100
        int c = 1000;
        System.out.println(c);
    }
}
