package ru.stqa.pft.sandbox;

public class HomeWork {
  public static void main(String args[]) {
    Point1 p1 = new Point1(10,20);
    Point1 p2 = new Point1(25,35);

    System.out.println("First point coordinates : x1 = " + p1.x + " у1 = " + p1.y);
    System.out.println("First point coordinates : x2 = " + p2.x + " у2 = " + p2.y);
    System.out.println("Distance betwenn points points" + (p1.distance1(p2)));
  }

}
