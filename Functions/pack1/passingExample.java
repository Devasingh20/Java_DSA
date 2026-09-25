
// name does not change to singh because java has only pass by value.
// public class passingExample {
//     public static void main(String[] args) {
//         String name = "Deva";
//         changeName(name);
//         System.out.println(name);
//     }

//     static void changeName(String naam) {
//         naam = "Singh";  //here you are not changing the object but creating a new object with value"Singh"
//     }
// }

//name is changed if we use return type.
// public class passingExample {

//     public static void main(String[] args) {

//         // 'name' stores a reference to the String object "Deva"
//         String name = "Deva";

//         // The reference stored in 'name' is passed by value to changeName().
//         // changeName() returns a reference to "Singh".
//         // Then 'name' is reassigned to that returned reference.
//         name = changeName(name);

//         // Now 'name' refers to "Singh"
//         System.out.println(name);
//     }

//     static String changeName(String naam) {

//         // 'naam' is a copy of the reference stored in 'name'.
//         // Initially, both 'name' and 'naam' refer to "Deva".
//         //
//         // Here, we are NOT changing the "Deva" String object.
//         // We are simply making the local reference 'naam'
//         // refer to the String object "Singh".
//         naam = "Singh";

//         // Return the reference stored in 'naam'.
//         return naam;
//     }
// }

// The most important rule is:
// Java is always pass-by-value.
// There is no pass-by-reference in Java.
// The confusing part is that when you pass an object, the value being passed is
// a reference to that object.

// When an object is passed to a method, Java copies the reference. If the
// method modifies the object through that reference, the caller sees the
// modification. But if the method makes the parameter reference point to a new
// object, the caller's reference does not change.

public class passingExample {

    // Simple class whose object we will pass to methods
    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {

        // =========================================================
        // CONDITION 1: Primitive → Java passes a copy of the value
        // =========================================================

        int x = 10;

        changePrimitive(x);

        // x is still 10 because the method received a copy of 10
        System.out.println("Primitive: " + x);

        // =========================================================
        // CONDITION 2: Object → reference value is copied
        // Method modifies the EXISTING object
        // =========================================================

        Student student1 = new Student("Deva", 80);

        changeObject(student1);

        // Both 'student1' and 's' inside the method referred
        // to the SAME object.
        //
        // Therefore, changing the object's field is visible
        // to the caller.
        System.out.println("Object modification: "
                + student1.name + " " + student1.marks);

        // =========================================================
        // CONDITION 3: Object → method makes parameter reference
        // point to a NEW object
        // =========================================================

        Student student2 = new Student("Deva", 80);

        changeReference(student2);

        // The local parameter 's' was made to point to a new object.
        // But the caller's 'student2' reference was NOT changed.
        System.out.println("Reference reassignment: "
                + student2.name + " " + student2.marks);

        // =========================================================
        // CONDITION 4: Object → method creates a NEW object and
        // returns it
        // =========================================================

        Student student3 = new Student("Deva", 80);

        student3 = createNewObject(student3);

        // The returned reference is explicitly assigned to student3.
        // Therefore, student3 now refers to the new object.
        System.out.println("Returned object: "
                + student3.name + " " + student3.marks);
    }

    // =============================================================
    // CONDITION 1
    // Primitive value is copied
    // =============================================================

    static void changePrimitive(int value) {

        // 'value' is a copy of x.
        value = 100;

        // Changing 'value' does NOT change x.
    }

    // =============================================================
    // CONDITION 2
    // Reference value is copied, but both references point
    // to the SAME object.
    // =============================================================

    static void changeObject(Student s) {

        // 's' is a copy of the reference stored in student1.
        //
        // Both references point to the same Student object.
        //
        // Therefore, modifying the object's fields affects
        // the same object that student1 refers to.

        s.name = "Singh";
        s.marks = 100;
    }

    // =============================================================
    // CONDITION 3
    // Parameter reference is reassigned to a NEW object.
    // =============================================================

    static void changeReference(Student s) {

        // A completely new Student object is created.
        s = new Student("Singh", 100);

        // 's' now points to the new object.
        //
        // But the caller's student2 still points to the
        // original object.
    }

    // =============================================================
    // CONDITION 4
    // Method creates a new object AND returns its reference.
    // =============================================================

    static Student createNewObject(Student s) {

        // Create a completely new object.
        Student newStudent = new Student("Singh", 100);

        // Return the reference to the new object.
        return newStudent;
    }
}