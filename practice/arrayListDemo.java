
//Basic ArrayList operations in Java

//add() method is used to add elements to the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         System.out.println("ArrayList: " + list);
//     }
// }

//add(index, element) method is used to add elements at a specific index in the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         list.add(1,60); // adding 60 at index 1
//         System.out.println("ArrayList: " + list);
//     }
// }

//remove(index) method is used to remove elements from the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         list.add(1,60); // adding 60 at index 1
//         list.remove(1); // removing element at index 1
//         System.out.println("ArrayList: " + list);
//     }
// }

//remove(object) method is used to remove elements(object) from the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<String> list = new ArrayList<>();
//         list.add("Apple");
//         list.add("Banana");
//         list.add("Cherry");
//         list.add("Date");
//         list.add("Elderberry");
//         list.add(1, "Fig"); // adding "Fig" at index 1
//         list.remove("Fig"); // removing "Fig" from the ArrayList
//         System.out.println("ArrayList: " + list);
//     }
// }

//remove(Integer.valueOf(object)) method is used to remove elements(object) from the ArrayList by specifying the object value
import java.util.ArrayList;

public class arrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(1,60); // adding 60 at index 1
        list.remove(Integer.valueOf(60));
        System.out.println("ArrayList: " + list);
    }
}

//set(index, element) method is used to update elements at a specific index in the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         list.set(1, 60); // updating element at index 1 with 60
//         System.out.println("ArrayList: " + list);
//     }
// }

//get(index) method is used to get elements at a specific index in the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         int element = list.get(1); // getting element at index 1
//         System.out.println("Element at index 1: " + element);
//     }
// }

//contains(object) method is used to check if an element(object) is present in the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         boolean containsElement = list.contains(30); // checking if 30 is present in the ArrayList
//         System.out.println("Does the ArrayList contain 30? " + containsElement);
//     }
// }


//size() method is used to get the number of elements in the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         list.add(1,60); // adding 60 at index 1
//        System.out.println("Size of the ArrayList: " + list.size()); // getting the size of the ArrayList
//     }
// }

//clear() method is used to remove all elements from the ArrayList
// import java.util.ArrayList;

// public class arrayListDemo {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40);
//         list.add(50);
//         list.add(1,60); // adding 60 at index 1
//         System.out.println("ArrayList: " + list);
//         list.clear(); // removing all elements from the ArrayList
//         System.out.println("ArrayList after clear(): " + list);
//     }
// }