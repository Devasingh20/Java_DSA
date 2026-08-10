public class stringExample {
    public static void main(String[] args) {
        String message = greet();
        System.out.println(message);
    }

    // if you specifying return type it must have to return.
    static String greet() {
        String greeting = "Who are you?";
        return greeting;
    }
}