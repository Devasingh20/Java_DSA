package staticExample;

public class Main {
    public static void main(String[] args) {
        Humans deva = new Humans(20, "Deva", 20000, false);
        Humans singh = new Humans(18, "singh", 15000, false);
        System.out.println(deva.name);
        System.out.println(singh.name);
        System.out.println(singh.age);
        System.out.println(singh.salary);
        System.out.println(singh.married);
        System.out.println(Humans.population);
        System.out.println(Humans.population);

        //for accessing non-static method we must create a Main obj.
        Main obj = new Main();
        obj.print();
    }


  // here the print method is non-static so we need to create a obj to access this method.
  void print(){
    System.out.println("Hello world");
  }

}
