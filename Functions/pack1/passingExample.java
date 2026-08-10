
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
public class passingExample {
    public static void main(String[] args) {
        String name = "Deva";
        name = changeName(name);
        System.out.println(name);
    }

    static String changeName(String naam) {
        naam = "Singh";
        return naam;
    }
}