import java.util.*;

public class hamming {
    public static void main(String[] args) {
        {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the first string :");
                String s1 = sc.nextLine();

                System.out.println("Enter second string :");
                String s2 = sc.nextLine();

                if (s1.length() != s2.length()) {
                    System.out.println("Hamming distance not possible.");
                }
                
                String xor = "";

                int distance = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        distance++;
                        xor+=1;
                    } 
                    else{
                        xor+=0;
                    }
                }
                System.out.println("Hamming distance is :" + distance);
                System.out.println("XOR = " +xor);
            }
        }
    }
}
