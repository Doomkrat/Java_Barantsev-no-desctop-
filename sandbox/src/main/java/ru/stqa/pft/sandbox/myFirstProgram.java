package ru.stqa.pft.sandbox;

public class myFirstProgram {

    public static void main(String[] args) {

      hello("world");
      hello("user");
      hello("sergii");

      double l=5;
      System.out.println("square sq with one side"+l+" = "+ area(l));

      double a=5;
      double b=6;
      System.out.println("reqtang square "+a+" and "+b+" = "+area(a,b));


    }

    public static void hello(String somebody){
      System.out.println("Hello, " + somebody + "!");

    }
    public static double area (double len){
      return len * len;
    }
    public static double area(double a, double b){
      return a*b;
    }
}