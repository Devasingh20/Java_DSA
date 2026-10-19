public class final_keyword {
    public static void main(String[] args) {
        // The final Keyword with Primitive Types
        final int FILE_NAME = 2;
        System.out.println(FILE_NAME);
        // FILE_OPEN = 3; // Compilation error

        Student s1 = new Student();
        s1.name = "Aman";

        final Student s2 = s1;

        // For reference types, the reference cannot be changed to point to another
        // object, but the object itself may still be modified.
        s2.name = "Rahul"; // Allowed

        // s2 = new Student(); // Compilation error
        System.out.println(s2.name);
    }
}

// The final Keyword with Reference Types
class Student {
    String name;
}