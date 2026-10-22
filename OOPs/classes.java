
// package OOPs;

public class classes {
    public static void main(String[] args) {
        Student Deva = new Student("Deva singh", 90, 50008);
        Deva.marks = 90; // this overrides the marks value from class
        System.out.println(Deva.marks);
        System.out.println(Deva.name);
        System.out.println(Deva.roll_no);
        Deva.greeting();
        Deva.greeting1();
        Deva.changeName("Meva");

        Student random = new Student();
        System.out.println(random.name);
        System.out.println(Deva);
    }
}

// values provided by the class
// class Student{

// String name = "Deva singh";
// int marks = 100;
// int roll_no = 50008;
// }

// values provided by the constructor
class Student {
    String name;
    int marks;
    int roll_no;


    void greeting() {
        System.out.println("Hello, I am " + name);
    }

    void greeting1() {
        System.out.println("Hello, I am " + this.name);
    }

    void changeName(String newName) {
        name = newName;
        System.out.println(name);
    }

    Student() {
        // this is how you call a constructor from another constructor
        // internally: new Student (13, "default person", 100.0f);
        this("random person", 50, 50008);
    }

    //non-parameterized constructor
    // Student() {
    //     this.name = "Deva singh";
    //     this.marks = 100;
    //     this.roll_no = 50008;
    // }

    Student(String name, int marks, int roll_no){
          this.name = name;
          this.marks = marks;
          this.roll_no = roll_no;
    }
}