package staticExample;

public class Humans {
    int age;
    String name;
    int salary;
    boolean married;
   static int population;

    public Humans(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Humans.population += 1;
    }
    public static void main(String[] args) {
        
    }

}
