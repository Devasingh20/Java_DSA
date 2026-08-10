//add method in hashset
// import java.util.HashSet;
// public class HashsetDemo {
//     public static void main(String[] args) {
//         HashSet<Integer> set = new HashSet<>();
//         set.add(1);
//         set.add(2);
//         set.add(3);
//         set.add(4);
//         System.out.println("HashSet: " + set);
//     }
// }

//remove method in hashset
// import java.util.HashSet;
// public class HashsetDemo {
//     public static void main(String[] args) {
//         HashSet<Integer> set = new HashSet<>();
//         set.add(1);
//         set.add(2);
//         set.add(3);
//         set.add(4);
//         set.add(5);
//         set.remove(3);
//         System.out.println("HashSet: " + set);
//     }
// }

//contains method in hashset
// import java.util.HashSet;
// public class HashsetDemo {
//     public static void main(String[] args) {
//         HashSet<Integer> set = new HashSet<>();
//         set.add(1);
//         set.add(2);
//         set.add(3);
//         set.add(4);
//         set.add(5);
//         boolean contains = set.contains(3);
//         System.out.println("HashSet: " + set);
//         System.out.println("Contains 3: " + contains);
//     }
// }

//size method in hashset
// import java.util.HashSet;
// public class HashsetDemo {
//     public static void main(String[] args) {
//         HashSet<Integer> set = new HashSet<>();
//         set.add(1);
//         set.add(2);
//         set.add(3);
//         set.add(4);
//         set.add(5);
//         int size = set.size();
//         System.out.println("HashSet: " + set);
//         System.out.println("Size: " + size);
//     }
// }

//enhanced for loop in hashset
// import java.util.HashSet;

// public class HashsetDemo {
//     public static void main(String[] args) {
//         HashSet<Integer> set = new HashSet<>();
//         set.add(1);
//         set.add(2);
//         set.add(3);
//         set.add(4);
//         set.add(5);
//         for (int num : set) {
//             System.out.println(num);
//         }
//     }
// }

//traversing using iterator in hashset
import java.util.HashSet;
import java.util.Iterator;

public class HashsetDemo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}