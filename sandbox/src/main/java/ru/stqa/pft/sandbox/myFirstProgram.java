package ru.stqa.pft.sandbox;

public class myFirstProgram {

    public static void main(String[] args) {

      hello("world");
      hello("user");
      hello("sergii");

      Square s = new Square(5);
      System.out.println("square sq with one side "+s.l+" = "+ s.area( ));

      Rectangle r = new Rectangle (4,6);
      System.out.println("rectang square "+r.a+" and "+r.b+" = "+r.area());


    }

    public static void hello(String somebody){
      System.out.println("Hello, " + somebody + "!");

    }

}