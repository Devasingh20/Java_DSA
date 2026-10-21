package OOPs.Inheritance;

public class Main {
   public static void main(String[] args) {

      // Here, the constructor call depends upon the number and types of arguments
      // passed.
      // Java selects the appropriate overloaded constructor based on the arguments
      // provided.
      System.out.println("box");
      Box box = new Box();
      System.out.println(box.length + " " + box.height + " " + box.width);

      System.out.println("box2");
      Box box2 = new Box(20, 50);
      System.out.println(box2.length + " " + box2.height);

      System.out.println("box3");
      Box box3 = new Box(30, 40, 50);
      System.out.println(box3.length + " " + box3.height + " " + box3.width);

      System.out.println("box4");
      Box box4 = new Box(50);
      System.out.println(box4.length + " " + box4.height + " " + box4.width);

      BoxWeight box5 = new BoxWeight(10, 20, 30, 40);
      System.out.println(box5.length + " " + box5.height + " " + box5.width + " " + box5.weight);

      // - Box is the reference type.
      // - box6 is the reference variable.
      // - new BoxWeight(10, 20, 30, 40) creates a BoxWeight object.
      // - This assignment is called upcasting, because a child-class object(BoxWeight
      // object) is
      // assigned to a parent-class(Box ) reference.
      // The actual object is still a BoxWeight, but the reference type is Box. 

      Box box6 = new BoxWeight(10, 20, 30, 40); //upcasting
      // System.out.println(box6.weight); //error
      System.out.println(box6.height);

      BoxWeight box7 = (BoxWeight) box6;
      System.out.println(box7.height);

      // System.out.println(box6.weight); gives an error because : Java checks the
      // reference type at compile time to determine which fields can be accessed.
      // Since box6 has reference type Box, Java does not allow direct access to
      // weight.
      // Even though the actual object is a BoxWeight, the reference type limits which
      // members you can access.


      //Multilevel inheritance
      BoxPrice box8 = new BoxPrice(2000,10,20,30,40);
      System.out.println(box8.cost);

   }
}
