package ru.stqa.pft.sandbox;

public class HomeWork {
  public static void main(String args[]) {
    Point1 p1 = new Point1();
    Point1 p2 = new Point1();
    p1.x = 10;
    p1.y = 20;
    p2.x = 25;
    p2.y = 35;
    System.out.println("First point coordinates : x1 = " + p1.x + " у1 = " + p1.y);
    System.out.println("First point coordinates : x2 = " + p2.x + " у2 = " + p2.y);
    System.out.println("Distance betwenn points points" + distance1(p1,p2));
  }
  public static double distance1(Point1 p1, Point1 p2){
    double xdif=p1.x-p2.x;
    double ydif=p1.y-p2.y;
    return Math.sqrt((xdif*xdif) + (ydif*ydif));
  }
}
